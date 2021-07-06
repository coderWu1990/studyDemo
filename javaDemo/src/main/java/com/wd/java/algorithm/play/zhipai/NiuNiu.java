package com.wd.java.algorithm.play.zhipai;

import java.util.List;

public class NiuNiu extends ZhiPai {

	private final static int T_WHN = 20;
	private final static int T_NN = 10;
	private final static int T_N9 = 9;
	private final static int T_N8 = 8;
	private final static int T_N7 = 7;
	private final static int T_N6 = 6;
	private final static int T_N5 = 5;
	private final static int T_N4 = 4;
	private final static int T_N3 = 3;
	private final static int T_N2 = 2;
	private final static int T_N1 = 1;
	private final static int T_MN = 0;

	public NiuNiu() {
		initCount(52, 5);
	}

	@Override
	protected int getPaiType(List<Integer> pai) {
		if (isNiu(pai)) {
			int s=getNiuS(pai);
			if((s%10)==0){
				if(s==50){
					return T_WHN;
				}else{
					return T_NN;
				}
			}else{
				return s%10;
			}
		} else {
			return T_MN;
		}
	}

	private boolean isNiu(List<Integer> pai) {
		if (pai == null || pai.size() != 5) {
			return false;
		}
		int[][] dd = getAllcom();
		for (int i = 0; i < dd.length; i++) {
			int a = getShu(pai.get(dd[i][0]));
			int b = getShu(pai.get(dd[i][1]));
			int c = getShu(pai.get(dd[i][2]));
			// System.out.println(a+" "+b+" "+c);
			if ((a + b + c) % 10 == 0) {
				return true;
			}
		}
		return false;
	}

	private int getNiuS(List<Integer> pai) {
		int total = getShu(pai.get(0)) + getShu(pai.get(1))
				+ getShu(pai.get(2)) + getShu(pai.get(3)) + getShu(pai.get(4));
		return total;
	}

	private int getShu(int o) {
		int t = o / 4 + 2;
		if (t == 14) {
			return 1;
		} else if (t > 9) {
			return 10;
		} else {
			return t;
		}
	}

	private int[][] getAllcom() {
		int a = 0, b = 1, c = 2;
		int[][] pp = new int[10][3];
		int count = 0;
		while (count < 10) {
			pp[count] = new int[] { a, b, c };
			count++;
			// System.out.println("第" + count + "次：" + a + " " + b + " " + c);
			if (c < 4) {
				c++;
			} else if (c == 4) {
				if (b < 3) {
					b++;
				} else {
					a++;
					b = a + 1;
				}
				c = b + 1;
			}
		}
		return pp;
	}

	@Override
	protected String showPaiType(int type) {
		String s = "xx";
		switch (type) {
		case T_WHN:
			s = "wuhuan";
			break;
		case T_NN:
			s = "nn";
			break;
		case T_MN:
			s = "mn";
			break;
		default:
			s="n"+type;
			break;	
		}
		return s + "  ";
	}

	@Override
	protected boolean bigPai(List<Integer> pai1, List<Integer> pai2) {
		return getPaiType(pai1)>getPaiType(pai2);
	}

	@Override
	protected int calBill(Player p1, Player p2) {
		int type1=getPaiType(p1.getmPoker());
		int type2=getPaiType(p2.getmPoker());
		int maxType=type1>type2?type1:type2;
		int m=1;
		if(maxType==T_WHN){
			m=5;
		}else if(maxType==T_NN){
			m=3;
		}else if(maxType==T_N8||maxType==T_N9){
			m=2;
		}
		if(type1<type2){
			m=-m;
		}
		p1.winM(m);
		p2.winM(-m);
		return -m;
	}

	
}
