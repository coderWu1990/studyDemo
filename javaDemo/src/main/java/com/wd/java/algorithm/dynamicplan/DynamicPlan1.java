package com.wd.java.algorithm.dynamicplan;

public class DynamicPlan1 {
	static int count=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+getMax());
	}
	public static int getMax(){
		int MAX = 5;
		int[][] D = new int[MAX][MAX];   //存储数字三角形
		int[] temp=new int[]{7,3,8,8,1,0,2,7,4,4,4,5,2,6,5};
		int t=0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < i+1; j++) {
				D[i][j]=temp[t++];
			}
		}
		int n = MAX-1;              //n表示层数
		int i = 0; int j = 0;
		int maxSum = getMaxSum(D,n,i,j);
		return maxSum;
	}
	public static int getMaxSum(int[][] D,int n,int i,int j){
		System.out.println("count="+(count++)+" i="+i+" j="+j);
		if(i == n){
			//System.out.println(" i="+i+" return");
			return D[i][j];
		}
		int x = getMaxSum(D,n,i+1,j);
		int y = getMaxSum(D,n,i+1,j+1);
		//System.out.println("xy i="+i+" j="+j);
		return Math.max(x,y)+D[i][j];
	}
}
