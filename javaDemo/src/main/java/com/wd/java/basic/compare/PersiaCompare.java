package com.wd.java.basic.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersiaCompare implements Comparator<String>{
	
	public int compare(String s1, String s2) {
		return getUnicodeStr(s2).compareTo(getUnicodeStr(s1));
	}
	
	/**
	 * 波斯文字母从低到高顺序对应的unicode字符
	 */
	private final static String[] PERSIA_LETTERS=new String[]{ 
		"u0621",	 	
		"u0627",
		"u0622",
		"u0623",	
		"u0628",
		"u067e",	
		"u062a",	
		"u062b", 	
		"u062c",
		"u0686",
		"u062d",	 	
		"u062e",	
		"u062f",
		"u0630",
		"u0631",	
		"u0632",
		"u0698", 	
		"u0633",	 	
		"u0634",
		"u0635",
		"u0636",
		"u0637",
		"u0638",
		"u0639",	 	
		"u063a", 	
		"u0641",	
		"u0642",
		"u0643",
		"u06a9",
		"u06af",	
		"u0644", 	
		"u0645", 	
		"u0646",	
		"u0648",
		"u0624",
		"u0647",		 	
		"u064a",	
		"u06cc",	 	
		"u0649", 	
		"u0626"
	};
	private static List<String> LETTERS=new ArrayList<String>();
	static{
		Collections.addAll(LETTERS, PERSIA_LETTERS);
	}
	/**
	 * 
	 * @param source 波斯文
	 * @return 波斯文对应的顺序字符串
	 */
	public static String getUnicodeStr(String source) {
		if(source==null||source.length()==0){
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (int i =0; i < source.length(); i++) {
			String hex = Integer.toHexString(source.charAt(i));
			if (hex.length() == 2) {
				//对应的ascll码
				stringBuffer.append(hex);
			} else if (hex.length() == 3) {
				hex = "u0" + hex;
			}else if(hex.length() == 4){
				hex = "u" + hex;
			}
			//System.out.println("hex="+hex);
			if (LETTERS.contains(hex)) {
				int index = LETTERS.indexOf(hex);
				if (index < 10) {
					stringBuffer.append("0");
				}
				stringBuffer.append(Integer.toString(index));
			}
		}
		System.out.println(source+"="+stringBuffer.toString());
		return stringBuffer.toString();
	}
	
	public static String getUnicode(String source) {
		if(source==null||source.length()==0){
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			String hex = Integer.toHexString(source.charAt(i));
			// System.out.println("hex="+hex);
			stringBuffer.append("u0" + hex);

		}
		System.out.println(source+"="+stringBuffer.toString());
		return stringBuffer.toString();
	}
}
