package com.wd.java.algorithm.t9search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import com.wd.java.algorithm.t9search.lib.PinyinProvider;
import com.wd.java.algorithm.t9search.lib.T9MatchInfo;
import com.wd.java.algorithm.t9search.lib.T9Matcher;
import com.wd.java.algorithm.t9search.lib.T9Utils;

public final class T9SearchSupport {

	private static final PinyinProvider PINYIN_PROVIDER;
	private static final HanyuPinyinOutputFormat FORMAT;

	static {
		FORMAT = new HanyuPinyinOutputFormat();
		FORMAT.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);

		PINYIN_PROVIDER = new PinyinProvider() {
			@Override
			public String[] getPinyin(char input) {
				Set<String> set = new HashSet<String>();
				try {
					String[] pys = PinyinHelper.toHanyuPinyinStringArray(input,
							FORMAT);
					if (pys == null)
						return null;

					// 去除重复
					set.addAll(Arrays.asList(pys));
					return set.toArray(new String[set.size()]);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				} finally {
					set.clear();
				}

				return null;
			}
		};
	}

	private T9SearchSupport() {
	}

	/**
	 * 生成T9键
	 * 
	 * @param input
	 *            输入
	 * @return T9键
	 */
	public static String buildT9Key(String input) {
		return T9Utils.buildT9Key(input, PINYIN_PROVIDER);
	}

	/**
	 * 过虑
	 */
	public static List<Contact> filter(List<Contact> contacts, String key) {
		ArrayList<Contact> filtered = new ArrayList<Contact>();

		if (contacts != null && contacts.size() > 0) {
			for (Contact contact : contacts) {
				T9MatchInfo nameMatch = T9Matcher.matches(contact.t9Key, key);
				T9MatchInfo numberMatch = T9Matcher.matchesNumber(
						contact.phoneNumber, key);

				if (nameMatch.found() || numberMatch.found()) {
					Contact c = new Contact(contact);
					c.nameMatchInfo = nameMatch;
					c.phoneNumberMatchInfo = numberMatch;
					filtered.add(c);
				}
			}

			Collections.sort(filtered, COMPARATOR);
		}

		return filtered;
	}

	private static final Comparator<Contact> COMPARATOR = new Comparator<Contact>() {

		@Override
		public int compare(Contact left, Contact right) {
			T9MatchInfo leftNameMatch = left.nameMatchInfo;
			T9MatchInfo rightNameMatch = right.nameMatchInfo;
			if (leftNameMatch.found()) {
				if (rightNameMatch.found()) {
					int lStart = leftNameMatch.start();
					int rStart = rightNameMatch.start();

					if (lStart < rStart) {
						return -1;
					} else if (lStart > rStart) {
						return 1;
					}

					int lLen = getMatchLength(leftNameMatch);
					int rLen = getMatchLength(rightNameMatch);

					int temp = left.name.length() - lLen
							- (right.name.length() - rLen);
					if (temp != 0) {
						if (lLen < rLen) {
							return 1;
						} else if (lLen > rLen) {
							return -1;
						}
						return temp;
					} else if (lLen != rLen) {
						if (left.name.length() > right.name.length()) {
							return 1;
						} else if (left.name.length() < right.name.length()) {
							return -1;
						}
					}

					return left.name.compareToIgnoreCase(right.name);

				} else {
					return -1;
				}
			} else if (rightNameMatch.found()) {
				return 1;
			}

			T9MatchInfo leftNumberMatch = left.phoneNumberMatchInfo;
			T9MatchInfo rightNumberMatch = right.phoneNumberMatchInfo;
			if (leftNumberMatch.found()) {
				if (rightNumberMatch.found()) {
					int lStart = leftNumberMatch.start();
					int rStart = rightNumberMatch.start();

					if (lStart < rStart) {
						return -1;
					} else if (lStart > rStart) {
						return 1;
					} else {
						return left.phoneNumber
								.compareToIgnoreCase(right.phoneNumber);
					}
				} else {
					return -1;
				}
			} else if (rightNumberMatch.found()) {
				return 1;
			}

			return 0;
		}

		private int getMatchLength(T9MatchInfo matchInfo) {
			int len = 0;
			while (matchInfo != null) {
				len += matchInfo.length();
				matchInfo = matchInfo.next();
			}

			return len;
		}
	};

}
