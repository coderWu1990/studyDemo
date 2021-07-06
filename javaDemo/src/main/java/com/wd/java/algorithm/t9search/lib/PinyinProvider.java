package com.wd.java.algorithm.t9search.lib;

/**
 * 拼音提供者
 */
public interface PinyinProvider {

    /**
     * @param input 输入
     * @return 拼音
     */
    String[] getPinyin(char input);

}
