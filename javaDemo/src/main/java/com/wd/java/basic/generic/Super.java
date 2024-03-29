package com.wd.java.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudi
 * @desc
 * @time 2023-02-20 19:02
 */
public class Super {

    class Self extends Super {
    }

    class Son extends Self {
    }

    void test() {
        List<? extends Self> a = new ArrayList<>();//参数类型上界是Self
//        a.add(new Son());//error 不能放入任何类型，因为编译器只知道a中应该放入Self的某个子类，但具体放哪种子类它并不知道，因此，除了null以外，不能放入任何类型
//        a.add(new Self());//error
//        a.add(new Super());//error
//        a.add(null);//ok
//        Self s1 = a.get(0); //返回类型是确定的Self类，因为<? extends T> 只能用于方法返回，告诉编译器此返参的类型的最小继承边界为T，T和T的父类都能接收，但是入参类型无法确定，只能接受null的传入
//        Super s2 = a.get(0); //Self类型可以用Super接收
//        Son s3 = a.get(0); //error:子类不能接收父类型参数

        //--------------------------------------

        List<? super Self> b = new ArrayList<>();//参数类型下界是Self
//        b.add(new Son());//ok 只能放入T类型，且满足T类型的超类至少是Self，换句话说，就是只能放入Self的子类型
//        b.add(new Self());//ok 本身类型也可以
//        b.add(new Super());//ERROR超类不可以
//        b.add(null);//ok
//        Object o1 = b.get(0);//返回类型是未知的， 因为<? super T>只能用于限定方法入参，告诉编译器入参只能是T或其子类型，而返参只能用Object类接收
//        Son o2 = b.get(0);//error
//        Self o3 = b.get(0);//error
//        Super o4 = b.get(0);//error

    }
}
