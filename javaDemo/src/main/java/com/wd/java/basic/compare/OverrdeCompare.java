package com.wd.java.basic.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverrdeCompare {

	public static void main(String[] args){
		List<Integer> list=new ArrayList<Integer>();
		list.add(8);
		list.add(1);
		list.add(5);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg0-arg1;
			}
		});
		System.out.println(Arrays.toString(list.toArray()));
	}
}
