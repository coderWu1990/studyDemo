package com.wd.java.algorithm.track;

/**
 * 视角公式 https://blog.csdn.net/weixin_38140931/article/details/89214903
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class VisualAngleFormula {

	/**
	 * α： camera的张角的二分之一（ 假设camera的张角为2α）
	 *  h： 摄像头距离地面 
	 *  β：摄像头中心线同水平面的夹角 
	 *  H: 输出屏幕的高度
	 *  W： 输出屏幕的宽度
	 */
	private static float A=(float) Math.toRadians(60);
	private static float H=80;
	private static float B=(float) Math.toRadians(20);
	private static float HEIGHT=700f;
	private static float WIDTH=600f;
	
	public static float getYr(float y) {
		float d1=(float) (Math.sin(A+B-Math.atan2(H,y))/Math.cos(B-Math.atan2(H,y)));
		float d2=(float) (HEIGHT/2*Math.sin(A));
		return d1*d2; 
	}
	
	public static float getXr(float x,float y){
		float d1=(float) (x/(Math.sqrt(H*H+y*y)*Math.tan(A)));
		float d2=WIDTH/2;
		return d1*d2;
	}
}
