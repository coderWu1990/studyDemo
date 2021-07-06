package com.wd.java.ds.sparse;

import android.util.SparseArray;

/**
 * Created by wudi on 2021/7/2 下午4:11
 * Note:sparse是android层的，这边跑不起来
 */
public class SparseArrayTest {

    public static void main(String[] args) {
        SparseArray<String> array=new SparseArray<>();
        array.put(1,"aa");
        array.put(2,"bb");
        System.out.println(array.get(1));
    }
}
