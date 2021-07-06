package com.wd.java.ds.heap;
import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

	private int[] arr;       // 堆是完全二叉树，底层用数组存储
    private int capacity;    // 堆中能存储的最大元素数量
    private int n;          // 当前堆中元素数量

    public Heap(int count) {
        capacity = count;
        arr = new int[capacity+1];
        n = 0;
    }

    public void insert(int value) {
        if (n >= capacity) {
            // 超过堆大小了，不能再插入元素
            return;
        }
        n++;
        // 先将元素插入到队尾中
        arr[n] = value;

        int i = n;
        // 由于我们构建的是一个大顶堆，所以需要不断调整以让其满足大顶堆的条件
        while (i/2 > 0 && arr[i] > arr[i/2]) {
            swap(arr, i, i/2);
            i = i / 2;
        }
    }
	
	private void swap(int[] arr,int a,int b){
		int t=arr[a];
		arr[a]=arr[b];
		arr[b]=t;
	}
	
	public void print(){
		System.out.println(Arrays.toString(arr));
	}
}
