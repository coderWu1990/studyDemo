package com.wd.demo.activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.demo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingActivity extends Activity implements View.OnClickListener {

    int count = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btPing:
                if (mIpAddr.getText().toString().equals("")) {
                    Toast.makeText(PingActivity.this, "请填写IP地址", Toast.LENGTH_SHORT)
                            .show();
                    break;
                }
                bTheadRun = true;
                mPing.setEnabled(false);
                mStop.setEnabled(true);
                // String ipAddr = mIpAddr.getText().toString();
                mTextView.setText("连接中...\n");
                count = 0;
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (bTheadRun) {
                            String ipAddr = mIpAddr.getText().toString();

                            Process process = null;
                            String result = "";
                            try {
                                process = Runtime.getRuntime().exec(
                                        "/system/bin/ping -c 1 -w 4 -s 24 "
                                                + ipAddr);
                                Log.i("ping", "exec");
                                InputStream input = process.getInputStream();
                                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(input));
                                StringBuffer buffer = new StringBuffer();
                                String line = "";
                                // String sub="64 bytes";
                                String sub1 = "ms";
                                String sub2 = "unreachable";
                                String sub3 = "Unreachable";
                                String sub4 = "timeout ";
                                while ((line = in.readLine()) != null) {

                                    int b = line.indexOf(sub1);
                                    int a = line.indexOf(sub2);
                                    int c = line.indexOf(sub3);
                                    int d = line.indexOf(sub4);
                                    if (b > 0 || a > 0 || c > 0 || d > 0) {
                                        // String display=line.substring(a,b);
                                        buffer.append(line);

                                        Message msg = new Message();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("result", line);
                                        Log.i("ping", "result:" + result);
                                        msg.setData(bundle);
                                        PingActivity.this.UIhandler
                                                .sendMessage(msg);
                                        count = 31;
                                        break;
                                    }
                                }

                            } catch (IOException e) {
                                Log.i("ping", "e:" + e.getMessage());
                                e.printStackTrace();
                            }

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            count++;
                            if (count == 10) {

                                new Handler(getMainLooper()).post(new Runnable() {

                                    @Override
                                    public void run() {
                                        // TODO Auto-generated method stub
                                        mTextView.setText("连接超时！\n");
                                        mPing.setEnabled(true);
                                        mStop.setEnabled(false);
                                        bTheadRun = false;
                                    }
                                });
                            }
                        }
                    }

                });
                thread.start();
                break;
            case R.id.stop:
                mPing.setEnabled(true);
                mStop.setEnabled(false);
                bTheadRun = false;
                break;
            case R.id.clear:
                mTextView.setText("");
                break;
            case R.id.set_back:
                sendBack();
                break;
            default:
                break;
        }
    }

    private void sendBack() {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private Button mPing;// ping包按钮
    private Button mStop;// stop按钮
    private Button mClear;// 清除按钮
    private EditText mIpAddr;// ip地址输入框
    private TextView mTextView;// 系统返回
    private boolean bTheadRun;
    private Thread thread;
    private UIHandler UIhandler;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private static final String[] addrList = {"www.baidu.com", "192.168.3.1",
            "192.168.1.1", "8.8.8.8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_ping);
        mIpAddr = (EditText) findViewById(R.id.ed_ipaddr);
        mTextView = (TextView) findViewById(R.id.ping_content);
        mTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        spinner = (Spinner) findViewById(R.id.spinner1);
        // 将可选内容与ArrayAdapter连接起来
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, addrList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 将adapter 添加到spinner中
        spinner.setAdapter(adapter);

        // 添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

        // 设置默认值
        spinner.setVisibility(View.VISIBLE);
        mPing = (Button) findViewById(R.id.btPing);
        mStop = (Button) findViewById(R.id.stop);
        mClear = (Button) findViewById(R.id.clear);
        mPing.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mClear.setOnClickListener(this);
        mStop.setEnabled(false);
        UIhandler = new UIHandler();
        findViewById(R.id.set_back).setOnClickListener(this);
    }

    class SpinnerSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            mIpAddr.setText(addrList[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String result = bundle.getString("result");
            mTextView.append(result + "\r\n");
            int offset = mTextView.getLineCount() * mTextView.getLineHeight();
            if (offset > mTextView.getHeight()) {
                mTextView.scrollTo(0, offset - mTextView.getHeight());
            }
        }
    }
}