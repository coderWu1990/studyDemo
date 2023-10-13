package com.wd.java.utils;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wudi
 * @desc
 * @time 2023-09-25 14:06
 */
public class SHA256Example {
    public static void main(String[] args) {
        String data = "Hello, world!";

        try {
            // 创建SHA-256哈希算法实例
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 计算哈希值
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

            // 将哈希值转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // 打印SHA-256哈希值
            System.out.println("SHA-256哈希值：" + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
