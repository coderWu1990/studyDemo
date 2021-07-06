package com.wd.java.algorithm.play.zhipai;

import java.util.List;

public class JHua extends ZhiPai {

	public JHua() {
		initCount(52, 3);
	}

	private final static int T_BAOZI = 6;
	private final static int T_THS = 5;
	private final static int T_JH = 4;
	private final static int T_SZ = 3;
	private final static int T_DZ = 2;
	private final static int T_SP = 1;
	private final static int T_WX = -1;

	private int[] getPshu(List<Integer> pp) {
		if (pp == null || pp.size() != 3) {
			return null;
		}
		int s1 = pp.get(0) / 4;
		int s2 = pp.get(1) / 4;
		int s3 = pp.get(2) / 4;
		int t = 0;
		// 先排序 //s1<s2<s3
		if (s1 > s2) {
			t = s1;
			s1 = s2;
			s2 = t;
		}
		if (s1 > s3) {
			t = s1;
			s1 = s3;
			s3 = t;
		}
		if (s2 > s3) {
			t = s3;
			s3 = s2;
			s2 = t;
		}
		return new int[] { s1, s2, s3 };
	}

	private int getDuiS(int[] ss) {
		if (ss == null || ss.length != 3) {
			return -1;
		}
		if (ss[0] == ss[1]) {
			return ss[0];
		} else {
			return ss[1];
		}
	}

	private int getDuiO(int[] ss) {
		if (ss == null || ss.length != 3) {
			return -1;
		}
		if (ss[0] == ss[1]) {
			return ss[2];
		} else if (ss[1] == ss[2]) {
			return ss[0];
		} else {
			return ss[1];
		}
	}

	private int getDuiH(List<Integer> pp) {
		if (pp == null || pp.size() != 3) {
			return -1;
		}
		int s1 = pp.get(0) / 4;
		int s2 = pp.get(1) / 4;
		int s3 = pp.get(2) / 4;
		if (s1 != s2 && s1 != s3) {
			return pp.get(0) % 4;
		} else if (s2 != s1 && s2 != s3) {
			return pp.get(1) % 4;
		} else {
			return pp.get(2) % 4;
		}
	}

	private int getMaxH(List<Integer> pp) {
		if (pp == null || pp.size() != 3) {
			return -1;
		}
		int s1 = pp.get(0) / 4;
		int s2 = pp.get(1) / 4;
		int s3 = pp.get(2) / 4;
		if (s1 >= s2 && s1 >= s3) {
			return pp.get(0) % 4;
		} else if (s2 >= s1 && s2 >= s3) {
			return pp.get(1) % 4;
		} else {
			return pp.get(2) % 4;
		}
	}

	private boolean isShunzi(int a, int b, int c) {
		if ((a + 1 == b) && (a + 2 == c)) {
			return true;
		} else if (a == 0 && b == 1 && c == 12) {// "A23"
			return true;
		}
		return false;
	}

	@Override
	public int getPaiType(List<Integer> pp) {
		if (pp == null || pp.size() != 3) {
			return -1;
		}
		int type = T_SP;
		int a1 = pp.get(0);
		int a2 = pp.get(1);
		int a3 = pp.get(2);

		int s1 = getPshu(pp)[0];
		int s2 = getPshu(pp)[1];
		int s3 = getPshu(pp)[2];

		int h1 = a1 % 4;
		int h2 = a2 % 4;
		int h3 = a3 % 4;
		if ((s1 == s2) && (s1 == s3)) {
			type = T_BAOZI;
		} else if ((h1 == h2) && (h1 == h3)) {
			if (isShunzi(s1, s2, s3)) {
				type = T_THS;
			} else {
				type = T_JH;
			}
		} else if (isShunzi(s1, s2, s3)) {
			type = T_SZ;
		} else if ((s1 == s2) || (s1 == s3) || (s2 == s3)) {
			type = T_DZ;
		}else{
			type = T_WX;
		}
		return type;
	}

	@Override
	public String showPaiType(int type) {
		String s = "sanpai";
		switch (type) {
		case T_BAOZI:
			s = "BAOZI";
			break;
		case T_THS:
			s = "THS";
			break;
		case T_JH:
			s = "JH";
			break;
		case T_SZ:
			s = "SZ";
			break;
		case T_DZ:
			s = "DZ";
			break;
		}
		return s + "  ";
	}

	@Override
	public boolean bigPai(List<Integer> p1, List<Integer> p2) {
		int t1 = getPaiType(p1);
		int t2 = getPaiType(p2);
		if (t1 != t2) {
			return t1 > t2;
		} else {
			int[] s1 = getPshu(p1);
			int[] s2 = getPshu(p2);
			if (t1 == T_BAOZI) {
				return s1[0] > s2[0];
			} else if (t1 == T_DZ) {
				if (getDuiS(s1) != getDuiS(s2)) {
					return getDuiS(s1) > getDuiS(s2);
				} else if (getDuiO(s1) != getDuiO(s2)) {
					return getDuiO(s1) > getDuiO(s2);
				} else {
					return getDuiH(p1) > getDuiH(p2);
				}

			} else {
				// 比大小
				if (s1[2] != s2[2]) {
					return s1[2] > s2[2];
				} else if (s1[1] != s2[1]) {
					return s1[1] > s2[1];
				} else if (s1[1] != s2[1]) {
					return s1[0] > s2[0];
				} else {
					return getMaxH(p1) > getMaxH(p2);
				}
			}
		}
	}
	
	@Override
	protected int calBill(Player p1, Player p2) {
		return 0;
	}

}
