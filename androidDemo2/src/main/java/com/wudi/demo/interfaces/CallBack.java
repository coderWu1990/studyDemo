package com.wudi.demo.interfaces;

/**
 * @author gaosi
 * @desc 接口回调
 * @time 2020/8/28 2:09 PM
 */
public interface CallBack<T> {
    /**
     * @param result
     */
    void onSuccess(T result);

    /**
     * @param code
     * @param msg
     */
    void onFail(int code, String msg);

}