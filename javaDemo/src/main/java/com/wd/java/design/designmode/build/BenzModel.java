package com.wd.java.design.designmode.build;

public class BenzModel extends CarModel{

	@Override
	protected void start() {
		// TODO Auto-generated method stub
		System. out. println( "奔驰车的喇叭声音是这个样子的. . . " ) ;
	}

	@Override
	protected void stop() {
		// TODO Auto-generated method stub
		System. out. println( "奔驰车应该这样停车. . . " ) ;
	}

	@Override
	protected void engineBoom() {
		// TODO Auto-generated method stub
		System. out. println( "奔驰车的引擎是这个声音的. . . " ) ;
	}

	@Override
	protected void alarm() {
		// TODO Auto-generated method stub
		System. out. println( "奔驰车的喇叭声音是这个样子的. . . " ) ;
	}

}
