package com.wd.java.design.designmode.mode;

public class HummerH2 extends AbsHummer{

	@Override
	protected void start() {
		// TODO Auto-generated method stub
		System. out. println( "悍马H2发动. . . " ) ;
	}

	@Override
	protected void stop() {
		// TODO Auto-generated method stub
		System. out. println( "悍马H2停车. . . " ) ;
	}

	@Override
	protected void engineBoom() {
		// TODO Auto-generated method stub
		System. out. println( "悍马H2引擎声音是这样的. . . " ) ;
	}

	@Override
	protected void alarm() {
		// TODO Auto-generated method stub
		System. out. println( "悍马H2鸣笛. . . " ) ;
	}

}
