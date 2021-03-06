/**
 *
 */
package com.wd.demo.hook;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

import com.wd.demo.base.MyApp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-19 下午7:58:05 <br/>
 *
 */
public class AmsInvocationHandler implements InvocationHandler {

    private Object iActivityManagerObject;

    AmsInvocationHandler(Object iActivityManagerObject) {
        this.iActivityManagerObject = iActivityManagerObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        Log.i("HookUtil", method.getName());
        // 我要在这里搞点事情
        if ("startActivity".contains(method.getName())) {
            Log.e("HookUtil", "Activity已经开始启动");

            //换掉
            Intent intent = null;
            int index = 0;
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg instanceof Intent) {
                    //说明找到了startActivity的Intent参数
                    intent = (Intent) args[i];
                    //这个意图是不能被启动的，因为Acitivity没有在清单文件中注册
                    index = i;
                }
            }
            Log.e("HookUtil", "代理 小弟到此一游！！！");
            //伪造一个代理的Intent，代理Intent启动的是proxyActivity
            Intent proxyIntent = new Intent();
            ComponentName componentName = new ComponentName(MyApp.getContext(), HookActivity1.class);
            proxyIntent.setComponent(componentName);
            proxyIntent.putExtra("oldIntent", intent);
            args[index] = proxyIntent;
        }
        return method.invoke(iActivityManagerObject, args);
    }

}