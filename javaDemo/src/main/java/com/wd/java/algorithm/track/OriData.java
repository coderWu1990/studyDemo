/**
 * 
 */
package com.wd.java.algorithm.track;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2020-12-16 下午4:10:24 <br/>
 * 
 */
public class OriData {

	public static int[] XOUT = new int[] { 168, 177, 184, 192, 200, 209, 217,
			225, 234, 245, 254, 266, 280, 298 };
	public static int[] XIN = new int[] { 472, 466, 462, 457, 454, 451, 447,
			444, 443, 442, 442, 447, 457, 471 };
	public static int[] Y = new int[] { 385, 375, 365, 355, 345, 335, 325, 315,
			305, 295, 285, 275, 265, 255 };

	public static float mArrayX[] = new float[] { 10f, 10f, 10f, 10f, 10f, 10f,
			10f, 10f, 10f, 10f, 10f, 10f, 10f, 10f, 10f, 10f, 10f, 10f, 10f,
			10f, 10f, 10f, 10f, 10f }; // 地面关键点位置的X坐标

	public static float mArrayYR[] = new float[] { 0.6f, 0.55f, 0.5f, 0.45f,
			0.4f, 0.35f, 0.3f, 0.25f, 0.2f, 0.15f, 0.1f, 0.05f, 0.05f, 0.1f,
			0.15f, 0.2f, 0.25f, 0.3f, 0.35f, 0.4f, 0.45f, 0.5f, 0.55f, 0.6f }; // 保存屏幕上Y轴的坐标Yr

	// 地面关键点位置的Y坐标..要考虑到camera能看到的地面的Y的最小值（边界问题）
	public static float mArrayY[] = new float[] { 4f, 3.75f, 3.5f, 3.25f, 3f,
			2.75f, 2.5f, 2.25f, 2f, 1.75f, 1.5f, 1.25f, 1.25f, 1.5f, 1.75f, 2f,
			2.25f, 2.5f, 2.75f, 3f, 3.25f, 3.5f, 3.75f, 4f };

	// 顶点数组
	public static float[] mArray = {

	mArrayX[0], mArrayYR[0] * 2 - 1, 0f, mArrayX[1], mArrayYR[1] * 2 - 1, 0f,

	mArrayX[1], mArrayYR[1] * 2 - 1, 0f, mArrayX[2], mArrayYR[2] * 2 - 1, 0f,

	mArrayX[2], mArrayYR[2] * 2 - 1, 0f, mArrayX[3], mArrayYR[3] * 2 - 1, 0f,

	mArrayX[3], mArrayYR[3] * 2 - 1, 0f, mArrayX[4], mArrayYR[4] * 2 - 1, 0f,

	mArrayX[4], mArrayYR[4] * 2 - 1, 0f, mArrayX[5], mArrayYR[5] * 2 - 1, 0f,

	mArrayX[5], mArrayYR[5] * 2 - 1, 0f, mArrayX[6], mArrayYR[6] * 2 - 1, 0f,

	mArrayX[6], mArrayYR[6] * 2 - 1, 0f, mArrayX[7], mArrayYR[7] * 2 - 1, 0f,

	mArrayX[7], mArrayYR[7] * 2 - 1, 0f, mArrayX[8], mArrayYR[8] * 2 - 1, 0f,

	mArrayX[8], mArrayYR[8] * 2 - 1, 0f, mArrayX[9], mArrayYR[9] * 2 - 1, 0f,

	mArrayX[9], mArrayYR[9] * 2 - 1, 0f, mArrayX[10], mArrayYR[10] * 2 - 1, 0f,

	mArrayX[10], mArrayYR[10] * 2 - 1, 0f, mArrayX[11], mArrayYR[11] * 2 - 1,
			0f,

			mArrayX[12], mArrayYR[12] * 2 - 1, 0f, mArrayX[13],
			mArrayYR[13] * 2 - 1, 0f,

			mArrayX[13], mArrayYR[13] * 2 - 1, 0f, mArrayX[14],
			mArrayYR[14] * 2 - 1, 0f,

			mArrayX[14], mArrayYR[14] * 2 - 1, 0f, mArrayX[15],
			mArrayYR[15] * 2 - 1, 0f,

			mArrayX[15], mArrayYR[15] * 2 - 1, 0f, mArrayX[16],
			mArrayYR[16] * 2 - 1, 0f,

			mArrayX[16], mArrayYR[16] * 2 - 1, 0f, mArrayX[17],
			mArrayYR[17] * 2 - 1, 0f,

			mArrayX[17], mArrayYR[17] * 2 - 1, 0f, mArrayX[18],
			mArrayYR[18] * 2 - 1, 0f,

			mArrayX[18], mArrayYR[18] * 2 - 1, 0f, mArrayX[19],
			mArrayYR[19] * 2 - 1, 0f,

			mArrayX[19], mArrayYR[19] * 2 - 1, 0f, mArrayX[20],
			mArrayYR[20] * 2 - 1, 0f,

			mArrayX[20], mArrayYR[20] * 2 - 1, 0f, mArrayX[21],
			mArrayYR[21] * 2 - 1, 0f,

			mArrayX[21], mArrayYR[21] * 2 - 1, 0f, mArrayX[22],
			mArrayYR[22] * 2 - 1, 0f,

			mArrayX[22], mArrayYR[22] * 2 - 1, 0f, mArrayX[23],
			mArrayYR[23] * 2 - 1, 0f,

			// 静态区域 (手动配)
			-0.1f, 0.2f, 0f, -0.2f, -0.9f, 0f, // 左边

			-0.2f, -0.9f, 0f, 0.2f, -0.9f, 0f, // 底边

			0.2f, -0.9f, 0f, 0.1f, 0.2f, 0f, // 右边

			0.1f, 0.2f, 0f, -0.1f, 0.2f, 0f, // 上边
	};

}
