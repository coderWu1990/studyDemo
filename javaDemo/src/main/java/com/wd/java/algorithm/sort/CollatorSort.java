package com.wd.java.algorithm.sort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * @author ZH-SW-Wudi
 * 
 */
public class CollatorSort {

	/**
	 * 排序，为空的排在后面
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("周杰伦");
		list.add("");
		list.add("赵雷");
		list.add("银河映像");
		list.add("BENODY");
		//系统的排序器
		final Collator collator = Collator.getInstance(Locale.CHINA);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String lhs, String rhs) {
				// TODO Auto-generated method stub
				return collator.compare(lhs, rhs);
			}
		});
		System.out.println(Arrays.toString(list.toArray()));
	}

}
