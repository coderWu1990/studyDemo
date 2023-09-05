package com.wd.java.basic.crypto;

import com.wd.java.utils.ByteUtil;

import java.util.Base64;

/**
 * @author wudi
 * @desc
 * @time 2023-07-21 17:07
 */
public class Base64Test {
    public static void main(String[] args) {
        System.out.println("kai");
        String str = "absfdsfdsf";
        System.out.println("加密后：" + Base64.getEncoder().encodeToString(str.getBytes()));
        String str2 = "YWI=";
        System.out.println("解密：" + new String(Base64.getDecoder().decode(str2)));


        String str3 = "RygBAAABAgAAAAgAgFt7IlBhcmVudElkMZJpZmllciI6ImljZUNhbmRpZGF0AEQAgGUiLCJ3ZWJydGNYejoiY3aCOjAgMSB1ZHAgMjEzMDcwNgAAAIA0MzEgMTAuODguNTIuODMgMzYzMzYgdHlwIGhvc3QgAAAAgHJhZGRyIDAuMC4wLjAgcnBvcnQgMCBnZW5lcmF0aW8CiECBbjEibmV0d29yay1jgkI5OTkH4FNkcE1pZBGAMAvgTGluZUluAAiFomRleCI6MCwicmV0E5JzZXNz8ZhJYhxvZmZs8YNfkQBlcl9VJF85AECA8WR9LJB3QDEyczYxNjk0NDk4ODE1IDExMy4xIS0yMjkuOTEgNBAEAIA5OTAycztzcmZseHBDjWQifV0=";
        //        System.out.println("解密："+ new String(Base64.getDecoder().decode(str3)));
        //解压缩
        byte[] data = QuickLZUtils.decompress(Base64.getDecoder().decode(str3));
//        System.out.println("解压缩："+ ByteUtil.bytesToHexString(data));
        System.out.println("解压缩：" + new String(data));
    }
}
