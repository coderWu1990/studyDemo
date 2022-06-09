package com.wd.demo.util.reflex;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PublicMethod {

    public static String getPriMethod(Context context) throws Exception {
        ClassLoader cl = context.getClassLoader();
        Class class1 = cl.loadClass("com.wd.demo.util.reflex.PrivateMethod");
        Log.i("wd", "2=" + Arrays.toString(class1.getMethods()));
        Method method = class1.getMethod("getName");
        String ret = (String) method.invoke(class1.newInstance());
        return ret;
    }

    public static void getPriMethod2() throws Exception {
        Class class1 = Class.forName("com.wd.demo.util.reflex.PrivateMethod");
        Method methods1 = class1.getDeclaredMethod("getName");
        methods1.setAccessible(true);
        // 通过实例化的对象，调用无参数的方法
        String name = (String) methods1.invoke(class1.newInstance());
        // 注意参数不是String
        Method methods2 = class1.getDeclaredMethod("getAge", int.class);
        methods2.setAccessible(true);
        String age = (String) methods2.invoke(class1.newInstance(), 30);// 通过对象，调用有参数的方法
        Log.i("wd", "name=" + name + " age=" + age);
    }

    public static void setPriVar() {
        try {
            Class c = Class.forName("com.wd.demo.util.reflex.PrivateMethod");
            Object obj = c.newInstance();
            // 获取成员变量 Class类的方法 getFields() class文件中的所有公共的成员变量
            // 返回值是Field[] Field类描述成员变量对象的类

//			Field[] fields = c.getFields();
//			System.out.println("size="+fields.length);
//			for (Field f : fields) {
//				System.out.println(f);
//			}
            PrivateMethod pm = new PrivateMethod();
            Field field = pm.getClass().getDeclaredField("mName");
            field.setAccessible(true);
            // 获取指定的成员变量 String name
            // Class类的方法 Field getField(传递字符串类型的变量名) 获取指定的成员变量
            //Field field = c.getField("mName");

            // Field类的方法 void set(Object obj, Object value) ,修改成员变量的值
            // Object obj 必须有对象的支持, Object value 修改后的值
            field.set(obj, "王五");
            System.out.println(pm.getNa());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setSomeFields(PrivateMethod rp) throws Exception {
        // TODO Auto-generated method stub
        //获得ReflectPoint类中的一个属性str1
        Field field = rp.getClass().getDeclaredField("mName");
        //强制获取属性中的值（私有属性不能轻易获取其值）
        field.setAccessible(true);
        System.out.println(field.get(rp));
        //修改属性的值
        field.set(rp, "1234567890");
        System.out.println(rp.getNa());
    }

}
