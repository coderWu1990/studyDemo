/**
 * 
 */
package com.wd.java.algorithm.track;

import java.util.Arrays;


/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2020-12-10 下午3:22:12 <br/>
 * 
 */
public class AngleUtil {
	
	private static final int X = 276;
	private static final int Y = 387;
	
	private static int mAngle = 30;
    private static int mD = 50;  // 车尾到车后轮的距离
    private static int mL = 280;  // 车前后轮的轴距
    private static int mW = 120;  // 车的轴长
    private static int mH = 150;  // camera的高度
    private static int mA = 30;  // 当a越大，两条线越靠近，变化趋势相对平缓；a越小，两条线越远离，变化趋势相对剧烈
    private static int W = 80;  // 屏幕的宽度
	private static int gap=10000;
	private static int[] Param=new int[7];
	
	public static void startCal(){
		
		for (int i1 = 10; i1 <= 10; i1++) {
			mAngle=20+i1;
			for (int i2 = 1; i2 <= 10; i2++) {
				mD=10+10*i2;
				for (int i3 = 1; i3 <= 30; i3++) {
					mL=50+10*i3;
					for (int i4 = 1; i4 <= 20; i4++) {
						mW=10+10*i4;
						for (int i5 = 1; i5 <= 50; i5++) {
							mH=10+i5*10;
							for (int i6 = 10; i6 <= 10; i6++) {
								mA=20+i6;
								for (int i7 = 1; i7 <= 50; i7++) {
									W=10+10*i7;
									draw();
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("gap="+gap);
		System.out.println(Arrays.toString(Param));
	}
	
	public static void start() {
		mAngle = 21;
		mD = 20; // 车尾到车后轮的距离
		mL = 350; // 车前后轮的轴距
		mW = 60; // 车的轴长
		mH = 200; // camera的高度
		mA = 30; // 当a越大，两条线越靠近，变化趋势相对平缓；a越小，两条线越远离，变化趋势相对剧烈
		W = 80;
		for (int i = 0; i < OriData.Y.length; i++) {
			int temp = Y - OriData.Y[i];
			float x = ComputerXOut(mAngle, temp);
			System.out.println(OriData.XOUT[i] - X + x);
		}
	}

	public static float ComputerXOut(float angle, float y) {
        // L, D, W 已知，
        float firstStep = Square(mL * Cot(angle) + mW / 2) - Square(y + mD);
        if(firstStep<0){
        	return -1f;
        }
        float secondStep = (float) Math.pow(firstStep, 0.5);
        float x = secondStep - mL * Cot(angle);
        // 新加入第一视角，需要参数:屏幕宽W，camera的张角2a
        return (float) ((x * W) / ((Math.pow((Square(y) + Square(mH)), 0.5) * Tan(mA) * 2)));
    }

    public static float ComputerXin(float angle, float y) {
        // L, D, W 已知，
        float firstStep = Square(mL * Cot(angle) - mW / 2) - Square(y + mD);
        if(firstStep<0){
        	return -1f;
        }
        float secondStep = (float) Math.pow(firstStep, 0.5);
        float x = secondStep - mL * Cot(angle);
        // 新加入第一视角，需要参数屏幕宽W，camera的张角2a大小
        return (float) ((x * W) / ((Math.pow((Square(y) + Square(mH)), 0.5) * Tan(mA) * 2)));
    }

    // 求反切值 默认参数为弧度，需要角度转弧度。
    public static float Cot(float angle) {
        float cot = 1 / (float) Math.tan(angle * Math.PI / 180);
        return cot;
    }

    // 求平方
    public static float Square(float number) {
        return (float) Math.pow(number, 2);
    }

    // 求Tan 默认的参数为弧度，需要角度转弧度
    public static float Tan(float degreef) {
        return (float) Math.tan(Math.toRadians(degreef));
    }

    private static int count=0;
	public static void draw() {
		int tempGap1=0;
		int tempGap2=0;
		for (int i = 0; i < OriData.Y.length; i++) {
			int temp=Y-OriData.Y[i];
			float x1=ComputerXOut(mAngle, temp);
			tempGap1+=Math.abs(OriData.XOUT[i]-X+x1);
			float x2=ComputerXin(mAngle, temp);
			tempGap2+=Math.abs(OriData.XIN[i]-X+x2);
		}
		if(tempGap1+tempGap2<gap){
			gap=tempGap1+tempGap2;
			Param[0]=mAngle;
			Param[1]=mD;
			Param[2]=mL;
			Param[3]=mW;
			Param[4]=mH;
			Param[5]=mA;
			Param[6]=W;
		}
		//System.out.println((count++)+"差值："+tempGap);
	}
	
	
}
