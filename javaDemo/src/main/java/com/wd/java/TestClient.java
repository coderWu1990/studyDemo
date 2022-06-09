package com.wd.java;

import com.wd.java.utils.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author wudi
 * @desc
 * @time 2021-07-29 19:01
 */
public class TestClient {
    public static void main(String[] args) {

        System.out.println(TimeUtil.getGapTime(8000000));
        System.out.println(TimeUtil.getGapTime2(8000000));
    }
}
