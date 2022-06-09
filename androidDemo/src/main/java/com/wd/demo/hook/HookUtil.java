/**
 *
 */
package com.wd.demo.hook;

import android.content.Context;
import android.os.Handler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-19 下午7:54:53 <br/>
 *
 */

public class HookUtil {

    private Class<?> proxyActivity;

    private Context context;

    public HookUtil(Class<?> proxyActivity, Context context) {
        this.proxyActivity = proxyActivity;
        this.context = context;
    }

    public void hookAms() {

        // 一路反射，直到拿到IActivityManager的对象
        try {
            Class<?> ActivityManagerNativeClss = Class
                    .forName("android.app.ActivityManagerNative");
            Field defaultFiled = ActivityManagerNativeClss
                    .getDeclaredField("gDefault");
            defaultFiled.setAccessible(true);
            Object defaultValue = defaultFiled.get(null);
            // 反射SingleTon
            Class<?> SingletonClass = Class.forName("android.util.Singleton");
            Field mInstance = SingletonClass.getDeclaredField("mInstance");
            mInstance.setAccessible(true);
            // 到这里已经拿到ActivityManager对象
            Object iActivityManagerObject = mInstance.get(defaultValue);

            // 开始动态代理，用代理对象替换掉真实的ActivityManager，瞒天过海
            Class<?> IActivityManagerIntercept = Class
                    .forName("android.app.IActivityManager");

            AmsInvocationHandler handler = new AmsInvocationHandler(
                    iActivityManagerObject);

            Object proxy = Proxy.newProxyInstance(Thread.currentThread()
                            .getContextClassLoader(),
                    new Class<?>[]{IActivityManagerIntercept}, handler);

            // 现在替换掉这个对象
            mInstance.set(defaultValue, proxy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hookSystemHandler() {
        try {

            Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);
            //获取主线程对象
            Object activityThread = currentActivityThreadMethod.invoke(null);
            //获取mH字段
            Field mH = activityThreadClass.getDeclaredField("mH");
            mH.setAccessible(true);
            //获取Handler
            Handler handler = (Handler) mH.get(activityThread);
            //获取原始的mCallBack字段
            Field mCallBack = Handler.class.getDeclaredField("mCallback");
            mCallBack.setAccessible(true);
            //这里设置了我们自己实现了接口的CallBack对象
            mCallBack.set(handler, new ActivityThreadHandlerCallback(handler));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
