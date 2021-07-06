package com.wd.java.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 给定无序数组和一个值，找到两个数和为值的元素
 * @author ZH-SW-Wudi
 *
 */
public class SortList1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//aa();
		int[] nums=new int[]{2,4,6,5,5};
		int target=10;
		System.out.println(Arrays.toString(twoSum02(nums, target)));
	}
	
	/**
	 * 给定无序数组和一个值，找到两个数和为值的元素，不能使用额外空间复杂度
	 */
	private static void aa() {
		int[] list = new int[30];
		Random random = new Random();
		int value = random.nextInt(100);
		for (int i = 0; i < list.length; i++) {
			list[i] = random.nextInt(100);
		}
		System.out.println("value=" + value);
		
		//defSearch(list, value);
		//comSearch(list, value);
	}

	public static int[] twoSum02(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			System.out.println("complement="+complement+"="+map.get(complement));
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] twoSum03(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
			int complement = target - nums[i];
			if(map.containsKey(complement)&&map.get(complement)!=i) {
				return new int[] {map.get(complement), i};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void comSearch(int[] list,int value){
		bubbleSort_02(list);
		int h=0;
		for (int i = 0; i < list.length; i++) {
			if(value<list[i]){
				h=i;
				break;
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = i + 1; j < h; j++) {
				if (list[i] + list[j] == value) {
					System.out.println(value + "=" + list[i] + "+" + list[j]
							+ " 位ss置" + i + "<>" + j);
				}
			}
		}
	}
	
	public static void defSearch(int[] list,int value){
		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (list[i] + list[j] == value) {
					System.out.println(value + "=" + list[i] + "+" + list[j]
							+ " 位置" + i + "<>" + j);
				}
			}
		}
	}

	/**
	 * 冒泡排序
	 * @param arrs
	 */
	public static void bubbleSort_02(int[] arrs) {
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i + 1; j < arrs.length; j++) {
				if (arrs[i] > arrs[j]) {
					int temp = arrs[i];
					arrs[i] = arrs[j];
					arrs[j] = temp;
				}
			}
		}
	}

}
