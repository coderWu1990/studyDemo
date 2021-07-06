package com.wd.java.algorithm.dynamicplan;

import java.util.Arrays;


public class DynamicPlan {
	static int MAX=5;
	static int count=0;
	static int[][] maxSum=new int[MAX][MAX];
	static int[][] D = new int[MAX][MAX]; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				maxSum[i][j]=-1;
			}
		}
		int[] temp=new int[]{7,3,8,8,1,0,2,7,4,4,4,5,2,6,5};
		int t=0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < i+1; j++) {
				D[i][j]=temp[t++];
			}
		}
		for (int i = 0; i < MAX; i++) {
			System.out.println(Arrays.toString(D[i]));
		}
		System.out.println(""+getMaxSum(D,4,0,0));
		for (int i = 0; i < MAX; i++) {
			System.out.println(Arrays.toString(maxSum[i]));
		}
	}
	
	//n表示层数
	public static int getMaxSum(int[][] D,int n,int i,int j){
		//System.out.println("count="+(count++)+" i="+i+" j="+j);
		if(maxSum[i][j]!=-1){
			return maxSum[i][j];
		}
		System.out.println("count="+(count++)+" i="+i+" j="+j);
		if(i == n){
			return D[i][j];
		}else{
			int x = getMaxSum(D,n,i+1,j);
			int y = getMaxSum(D,n,i+1,j+1);
			//System.out.println("x="+x+" y="+y+" i="+i+" j="+j);
			maxSum[i][j]=Math.max(x,y)+D[i][j];
		}
		return maxSum[i][j];
	}
}
