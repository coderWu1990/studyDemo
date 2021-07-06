package com.wd.java.utils;

/***
 * 存储大小(单位)转换器
 */
public class SizeConverterUtil{

    public static void main(String[] args) {
        System.out.println(convertKB(1024*5,true));
        System.out.println(convertKB(1088,true));
        System.out.println(convertKB(1088,false));
        System.out.println(convertMB(1088,true));
        System.out.println(convertBytes(1088,true));
    }

    // 单位转换
    private static final String[] UNITS = new String[] {
        "B", "KB", "MB", "GB", "TB", "PB", "**"
    };

    private static final int LAST_IDX = UNITS.length-1;

    private static final String FORMAT_F = "%1$-1.2f";
    private static final String FORMAT_F_UNIT = "%1$-1.2f%2$s";

    private static final String FORMAT_D = "%1$-1d";
    private static final String FORMAT_D_UNIT = "%1$-1d%2$s";

    // -----------------------------------------------------------------------
    public static String convertBytes(float B, boolean trim) {
        return trim ? trimConvert(0, B, true) : convert(0, B, false);
    }

    public static String convertKB(float KB, boolean trim) {
        return trim ? trimConvert(1, KB, true) : convert(1, KB, false);
    }

    public static String convertMB(float MB, boolean trim) {
        return trim ? trimConvert(2, MB, true) : convert(2, MB, false);
    }

    /***
     * <p> 存储大小单位间的转换. 注意该方法的最大单位为PB, 最小单位为B,
     * 任何超出该范围的单位最终会显示为**. </p>
     *
     * @param unit 从哪个单位开始
     * @param size 存储大小, 注意是float, 不要以整形的形式传入, 否则会溢出(如:1024*1024这种,
     * 它是先将1024*1024作为int相乘再转换为float的, 如果值过大的话就会溢出了,
     * 所以这么写1024.0F*1024.0F)
     * @param withUnit 返回的结果字符串是否带有对应的单位
     * @return
     */
    private static String convert(int unit, float size, boolean withUnit) {
        int unitIdx = unit;
        while (size > 1024) {
            unitIdx++;
            size /= 1024;
        }
        if (withUnit) {
            int idx = unitIdx < LAST_IDX ? unitIdx : LAST_IDX;
            return String.format(FORMAT_F_UNIT, size, UNITS[idx]);
        }
        return String.format(FORMAT_F, size);
    }

    /***
     * <p> 存储大小单位间的转换, 如果转换后小数部分为0, 则去除小数部分.
     * 注意该方法的最大单位为PB, 最小单位为B, 任何超出该范围的单位最终会显示为**. </p>
     *
     * @param unit 从哪个单位开始
     * @param size 存储大小, 注意是float, 不要以整形的形式传入, 否则会溢出(如:1024*1024这种,
     * 它是先将1024*1024作为int相乘再转换为float的, 如果值过大的话就会溢出了,
     * 所以这么写1024.0F*1024.0F)
     * @param withUnit 返回的结果字符串是否带有对应的单位
     * @return
     */
    private static String trimConvert(int unit, float size, boolean withUnit) {
        int unitIdx = unit;
        while (size > 1024) {
            unitIdx++;
            size /= 1024;
        }

        int sizeInt = (int) size;
        boolean isfloat = size - sizeInt > 0.0F;
        if (withUnit) {
            int idx = unitIdx < LAST_IDX ? unitIdx : LAST_IDX;
            if (isfloat) {
                return String.format(FORMAT_F_UNIT, size, UNITS[idx]);
            }
            return String.format(FORMAT_D_UNIT, sizeInt, UNITS[idx]);
        }

        if (isfloat) {
            return String.format(FORMAT_F, size);
        }
        return String.format(FORMAT_D, sizeInt);
    }
}