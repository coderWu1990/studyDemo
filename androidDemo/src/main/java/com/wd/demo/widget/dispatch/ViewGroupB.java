package com.wd.demo.widget.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ViewGroupB extends RelativeLayout {

    public ViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewGroupB dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewGroupB dispatchTouchEvent UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewGroupB onInterceptTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewGroupB onInterceptTouchEvent UP");
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewGroupB onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewGroupB onTouchEvent UP");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

}
