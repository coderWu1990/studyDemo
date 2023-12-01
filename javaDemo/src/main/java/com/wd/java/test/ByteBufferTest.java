package com.wd.java.test;

import com.wd.java.utils.ByteUtil;

import java.nio.ByteBuffer;

/**
 * @author wudi
 * @desc
 * @time 2023-11-01 11:02
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        byteBuffer.put((byte) 4);
        System.out.println("limit=" + byteBuffer.limit());
        System.out.println("byteBuffer=" + ByteUtil.bytesToHexString(byteBuffer.array()));
        byte[] bytes = new byte[2];
        //直接调用返回为null
//        byteBuffer.get(bytes);
        //两句一起调用才行
        byteBuffer.flip();
        byteBuffer.get(bytes);
        System.out.println("bytes=" + ByteUtil.bytesToHexString(bytes));

        //调之后
        System.out.println("limit=" + byteBuffer.limit());
        System.out.println("byteBuffer=" + ByteUtil.bytesToHexString(byteBuffer.array()));

        //clear调之后，数据还是存在
        byteBuffer.clear();
        System.out.println("limit=" + byteBuffer.limit());
        System.out.println("byteBuffer=" + ByteUtil.bytesToHexString(byteBuffer.array()));
    }
}
