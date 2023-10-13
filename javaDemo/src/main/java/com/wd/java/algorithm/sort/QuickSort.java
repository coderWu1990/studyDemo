package com.wd.java.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 6, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pivot;
        if (left < right) {
            pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    /**
     * 将数组分成两部分，pivot之前的数都比key小，之后的都比key大
     *
     * @param arr
     * @param left
     * @param right
     * @return pivot 中轴角标
     */
    static int partition(int[] arr, int left, int right) {
        //以数组的第一位作为比较基准值
        int key = arr[left];
        //循环遍历，直到left和right重合
        while (left < right) {
            //从后向前遍历，直到找到比key值小的数停止
            while (left < right && arr[right] >= key) {
                right--;
            }
            //将找到的数赋值给left角标
            arr[left] = arr[right];
            //从前向后遍历，直到找到比key值大的数停止
            while (left < right && arr[left] <= key) {
                left++;
            }
            //将找到的数赋值给此时的right角标
            arr[right] = arr[left];
        }
        //此时left位是空缺的，将key值赋值给left
        arr[left] = key;
        return left;
    }

}
