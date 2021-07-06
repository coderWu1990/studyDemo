/**
 * 
 */
package com.wd.java.basic.annotation;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-20 下午8:13:31 <br/> 
 *
 */
public class Student {
	@WdAnnotation(name = "sunwukong",age = 23,score = {99,66,77})
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }

}
