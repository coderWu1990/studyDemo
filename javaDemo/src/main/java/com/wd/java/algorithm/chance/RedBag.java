package com.wd.java.algorithm.chance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 计算红包的概率
 */
public class RedBag {
    public static void main(String[] args) {
        fen(100, 5);
    }

    public static void fen(double money, int num) {
        List<Double> list = new ArrayList<>();
        int count = num;
        for (int i = 0; i < count; i++) {
            money = RedBag.rand(money, num--, list);
            System.out.println("第"+(i+1)+"人:" + list.get(i));
        }
    }

    private static double rand(double money, int people, List<Double> l) {
        if (people == 1) {
            double red = Math.round(money * 100) / 100.0;
            l.add(red + 0.01);
            return 0;
        }
        Random random = new Random();
        double min = 0;
        double max = money / people * 2.0;
        double red = random.nextDouble() * max;
        red = red <= min ? min : red;
        red = Math.floor(red * 100) / 100.0;
        l.add(red + 0.01);
        double remain = Math.round((money - red) * 100) / 100.0;
        return remain;
    }
}
