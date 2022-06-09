/**
 *
 */
package com.wd.demo.util.reflex;

import java.lang.reflect.Field;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-2-23 下午7:40:37 <br/> 
 *
 */
public class ReflectPointTest {
    public static void main(String[] args) throws Exception {
        ReflectPoint rp = new ReflectPoint();
        setSomeFields(rp);
        System.out.println(rp.getStr1());
    }

    public static void setSomeFields(ReflectPoint rp) throws Exception {
        // TODO Auto-generated method stub
        //获得ReflectPoint类中的一个属性str1
        Field field = rp.getClass().getDeclaredField("str1");
        //强制获取属性中的值（私有属性不能轻易获取其值）
        field.setAccessible(true);
        System.out.println(field.get(rp));
        //修改属性的值
        field.set(rp, "123456789");
        System.out.println(rp.getStr1());
    }

    private static void getAllFields(ReflectPoint rp) throws Exception {
        // TODO Auto-generated method stub
        Field[] fields = rp.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(rp));
        }
    }

}
