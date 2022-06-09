/**
 *
 */
package com.wd.demo.util.reflex;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-2-23 下午7:35:57 <br/> 
 *
 */
public class ReflectPoint {
    public int x = 2345;
    private int y;
    private String str1 = "hello";

    public String getStr1() {
        return str1;
    }

    private String str2 = "yelow";
    private String str3 = "binbin";

    public ReflectPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public ReflectPoint() {
        super();
    }

}
