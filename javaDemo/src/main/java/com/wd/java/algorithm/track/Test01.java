/**
 * 
 */
package com.wd.java.algorithm.track;


/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2020-12-18 下午5:02:48 <br/> 
 *
 */
public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		for (int i = 0; i < OriData.mArray.length; i++) {
//			
//			if(i%3!=2){
//				System.out.print(OriData.mArray[i]+",");
//			}else{
//				System.out.println();
//			}
//			
//		}
		//System.out.println(Arrays.toString(OriData.mArray));
		
		for (int i = 0; i < 400; i++) {
			int temp=i-200;
			float x =VisualAngleFormula.getXr(190, temp);
			float y =VisualAngleFormula.getYr(temp);
			System.out.println("temp="+temp+" "+x/y);
			
		}
	}

}
