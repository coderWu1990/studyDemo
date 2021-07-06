package com.wd.java.algorithm.t9search.lib;

/**
 * T9 匹配信息
 */
public final class T9MatchInfo {
	private boolean mMatchFound;
	private int mMatchStart;
	private int mMatchLength;

	private T9MatchInfo mNext;

	T9MatchInfo() {
		this.mMatchFound = false;
		this.mMatchStart = -1;
		this.mMatchLength = 0;
	}

	void set(int matchStart, int matchLength) {
		if ((matchStart < 0 && matchLength > 0)
				|| (matchStart >= 0 && matchLength <= 0)) {
			throw new IndexOutOfBoundsException(
					"INVALID MATCH OFFSETS: matchStart=" + matchStart
							+ ", matchLength=" + matchLength);
		}

		this.mMatchFound = matchStart >= 0;
		this.mMatchStart = matchStart;
		this.mMatchLength = matchLength;
	}

	void setNext(T9MatchInfo next) {
		if (this != next)
			mNext = next;
	}

	/**
	 * @return <code>true</code> - 已匹配, <code>false</code> - 其他.
	 */
	public boolean found() {
		return mMatchFound;
	}

	/**
	 * @return 匹配的起始位置. <code>-1</code> - 如果未匹配.
	 */
	public int start() {
		return mMatchStart;
	}

	/**
	 * @return 匹配的长度. <code>0</code> - 如果未匹配.
	 */
	public int length() {
		return mMatchLength;
	}

	/**
	 * @return <code>true</code> - 如果存在下一个匹配信息, <code>false</code> - 其他.
	 */
	public boolean hasNext() {
		return mNext != null;
	}

	/**
	 * @return 下一个匹配信息
	 */
	public T9MatchInfo next() {
		return mNext;
	}

	@Override
	public String toString() {
		return "T9MatchInfo{" + "mMatchFound=" + mMatchFound + ", mMatchStart="
				+ mMatchStart + ", mMatchLength=" + mMatchLength + ", mNext="
				+ mNext + '}';
	}

}
