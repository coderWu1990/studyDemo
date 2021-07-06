package com.wd.java.algorithm.play.zhipai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokeDDZ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FaPai();
	}

	public static void FaPai() {
		Random random = new Random();
		List<Integer> mIntegers = new ArrayList<>();
		while (mIntegers.size() < 54) {
			int a = random.nextInt(54) + 1;
			if (!mIntegers.contains(a)) {
				mIntegers.add(a);
			}
		}
		int[] pa = new int[18];
		int[] pb = new int[18];
		int[] pc = new int[18];
		for (int i = 0; i < mIntegers.size(); i += 3) {
			pa[i / 3] = mIntegers.get(i);
			pb[i / 3] = mIntegers.get(i + 1);
			pc[i / 3] = mIntegers.get(i + 2);
		}
		
		showPai(pa);
		showPai(pb);
		showPai(pc);
	}
	
	/**
	 * 冒泡排序
	 */
	public static void bubbleSort_02() {
		int[] arrs={8,5,1,9,7,2,6,4,8,3,7};
		for (int i = 0; i < arrs.length; i++) {
			for (int j =i+1; j < arrs.length; j++) {
				if(arrs[i]>arrs[j]){
					int temp=arrs[i];
					arrs[i]=arrs[j];
					arrs[j]=temp;
				}
			}
		}
	}

	private static void showPai(int[] aa) {
		for (int i = 0; i < aa.length; i++) {
			System.out.print(transPai(aa[i])+" ");
		}
		System.out.println("");
	}
	
	private static String transPai(int d){
		if(d>54){
			return "无效";
		}else if(d==54){
			return "大王";
		}else if(d==53){
			return "小王";
		}
		String head="";
		String body="";
		int shu=d/4;
		int type=d%4;
		switch (type) {
		case 0:
			head="黑";
			break;
		case 1:
			head="红";
			break;
		case 2:
			head="方";
			break;
		case 3:
			head="梅";
			break;
		default:
			break;
		}
		if(shu<=8){
			body=""+(shu+2);
		}else if(shu==9){
			body="J";
		}else if(shu==10){
			body="Q";
		}else if(shu==11){
			body="K";
		}else if(shu==12){
			body="A";
		}
		return head+body;
	}

}
