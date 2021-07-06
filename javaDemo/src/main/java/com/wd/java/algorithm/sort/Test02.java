package com.wd.java.algorithm.sort;

import java.util.Arrays;


public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {10,7,5,6,8,3,4,2,1,9};
		System.out.println(Arrays.toString(arr));
		System.out.println();
        quickSort(arr, 0, arr.length-1);
		
	}
	
	public static void quickSort(int[] data,int low,int high){
		System.out.println("low="+low+" high="+high);
		if(low>=high){
			return;
		}
		boolean isHigh = true;
		int tLow=low;
		int tHigh=high;
		int temp=data[tLow];
		int index=tLow;
		while (tLow<tHigh) {
			if(isHigh){
				if (temp <= data[tHigh]) {
					tHigh--;
				} else {
					data[tLow] = data[tHigh];
					data[tHigh] = temp;
					index=tHigh;
					isHigh = false;
				}
			}else{
				if (temp >= data[tLow]) {
					tLow++;
				} else {
					data[tHigh] = data[tLow];
					data[tLow] = temp;
					index=tLow;
					isHigh = true;
				}
			}
		}
		printArr(data);
		System.out.println(tLow+"<>"+tHigh);
		System.out.println();
		quickSort(data, low, index-1);
		quickSort(data, index+1, high);
	}
	
	private static void sort(){
		int[] data = new int[] { 45, 9, 11, 21, 44, 4, 51, 2, 5, 13 };
		int low = 0;
		int high = data.length - 1;
		int temp = data[low];
		boolean isHigh = true;
		while (low < high) {
			if (isHigh) {
				if (temp < data[high]) {
					high--;
				} else {
					data[low] = data[high];
					data[high] = temp;
					isHigh = false;
				}
				System.out.println(">>  low=" + low + " hign=" + high);
			} else {
				if (temp > data[low]) {
					low++;
				} else {
					data[high] = data[low];
					data[low] = temp;
					isHigh = true;
				}
				System.out.println("<<  low=" + low + " hign=" + high);
			}
		}
		printArr(data);
	}

	private static void printArr(int[] data) {
		StringBuilder buffer = new StringBuilder(data.length * 2);
		buffer.append('[');
		for (int i = 0; i < data.length; i++) {
			buffer.append(data[i]);
			if (i != data.length - 1) {
				buffer.append(", ");
			}
		}
		buffer.append(']');
		System.out.println(buffer.toString());
	}

}
