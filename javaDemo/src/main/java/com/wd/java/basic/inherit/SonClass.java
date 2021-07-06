/**
 * 
 */
package com.wd.java.basic.inherit;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-3 下午7:19:50 <br/> 
 *
 */
public class SonClass extends FatherClass {
	 
    private String name;
 
    /**
     * 子类无参构造
     */
    SonClass(){
        System.out.println("--子类无参构造--");
    }
    /**
     * 子类带参构造
     * @param name
     */
    SonClass(String name){
        this.name=name;
        System.out.println("--子类带参构造--"+this.name);
    }
    /**
     * 子类静态代码块
     */
    static{
        System.out.println("--子类静态代码块--");
    }
    /**
     * 子类的非静态代码块
     */
    {
        System.out.println("--子类的非静态代码块--");
    }
    /**
     * 重写父类方法
     */
    @Override
    public void speak(){
        System.out.println("--子类重写(Override)了父类的方法--");
    } 
    //然后再加入一个main函数
 
    public static void main(String[] args) {
 
        System.out.println("--Main主程序调动--");
//        FatherClass father=new FatherClass("父亲");
//        father.speak();
        SonClass son=new SonClass("儿子");
        son.speak();
 
    }
}
