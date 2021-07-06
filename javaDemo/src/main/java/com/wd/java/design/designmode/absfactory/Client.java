package com.wd.java.design.designmode.absfactory;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//第一条生产线， 男性生产线
		HumanFactory maleFactory=new MaleHumanFactory();
		//第二条生产线， 女性生产线
		HumanFactory femaleFactory=new FemaleHumanFactory();
		//生产线建立完毕， 开始生产人了:
		Human femaleYellowHuman=femaleFactory.createYellowHuman();
		System. out. println( " ---生产一个黄色女性---" ) ;
		femaleYellowHuman. getColor( ) ;
		femaleYellowHuman. getSex( ) ;
		femaleYellowHuman. say( ) ;
		
		Human maleYellowHuman=maleFactory.createYellowHuman();
		System. out. println( " \n---生产一个黄色男性---" ) ;
		maleYellowHuman. getColor( ) ;
		maleYellowHuman. getSex( ) ;
		maleYellowHuman. say( ) ;
		
	}

}
