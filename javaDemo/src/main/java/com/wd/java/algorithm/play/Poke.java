/**
 * Copyright (c) 深圳市众鸿科技股份有限公司
 * @file_name Poke.java
 * @class com.test.Poke
 * @create 下午4:44:44
 */
package com.wd.java.algorithm.play;

import java.util.Random;

/**
 * 
 * <p></p>
 * 下午4:44:44
 *
 * @author ZH-SW-Wudi
 * @version 1.0.0
 */
public class Poke {

	public static int total[] =new int[54];
	public static int a[]=new int[20];
	public static int b[]=new int[17];
	public static int c[]=new int[17];
	public static int count=0;
	
	public static int run=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random=new Random();
		
		while (true) {
			int s=random.nextInt(54);
			boolean l=true;
			run++;
			//System.out.println("次数："+run+" 随机数："+s);
			for (int i = 0; i < 54; i++) {
				//System.out.println("已存："+total[i]+"size="+count);
				if(total[i]==s){
					//System.out.println("continul:"+count);
					l=false;
				}
			}
			if(count==53){
				//够数了
				break;
			}
			if(l){
				//不是重复的，添加
				total[count]=s;
				count++;
			}
			
		}
		for (int i = 0; i < total.length-3; i++) {
			int v=total[i];
			if(i%3==0){
				a[i/3]=v;
			}else if(i%3==1){
				b[i/3]=v;
			}else if(i%3==2){
				c[i/3]=v;
			}
		}
		a[17]=total[51];
		a[18]=total[52];
		a[19]=total[53];
		
		soft(a);
		soft(b);
		soft(c);
		
		
		
		prF(a);
		pr(a);
		prF(b);
		pr(b);
		prF(c);
		pr(c);
		
		//System.out.println(""+51%13);
	}
	
	public static void prF(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+1+" ");
		}
		System.out.println("");
	}
	
	public static void pr(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			int v=nums[i]+1;
			System.out.print(v%13+2);
			if(v/13==0){
				//System.out.print("T");
			}else if(v/13==1){
				//System.out.print("F");
			}else if(v/13==2){
				//System.out.print("M");
			}else if(v/13==3){
				//System.out.print("H");
			}else if(v/13==4){
				System.out.print("W");
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void soft(int[] nums){
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				count++;
				if(((nums[j])%13)>((nums[j+1])%13)){
					int a=nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=a;
				}
			}
		}
	}

}
