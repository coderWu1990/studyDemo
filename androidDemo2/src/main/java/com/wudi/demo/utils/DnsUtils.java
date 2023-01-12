package com.wudi.demo.utils;

import android.util.Log;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author wudi
 * @desc 通过次工具可以解析网址对应的ip
 * @time 2023-01-12 9:31
 */
public class DnsUtils {
    public static void testDns(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                parseHostGetIPAddress("www.baidu.com");
                parseHostGetIPAddress("coturn2.test.leiniao.com");
            }
        }).start();
    }

    private static String[] parseHostGetIPAddress(String host) {
        long t1=System.currentTimeMillis();
        String[] ipAddressArr = null;
        try {
            InetAddress[] inetAddressArr = InetAddress.getAllByName(host);
            if (inetAddressArr != null && inetAddressArr.length > 0) {
                ipAddressArr = new String[inetAddressArr.length];
                for (int i = 0; i < inetAddressArr.length; i++) {
                    ipAddressArr[i] = inetAddressArr[i].getHostAddress();
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Log.i("wwd","parseHostGetIPAddress="+e.getMessage());
            return null;
        }
        long gap=System.currentTimeMillis()-t1;
        Log.i("wwd","parseHostGetIPAddress success="+gap+" "+ Arrays.toString(ipAddressArr));
        return ipAddressArr;
    }
}
