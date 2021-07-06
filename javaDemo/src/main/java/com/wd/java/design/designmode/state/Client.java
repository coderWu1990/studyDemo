package com.wd.java.design.designmode.state;

public class Client {

	/**
	 * 状态模式的优点 
	 * ● 结构清晰 避免了过多的switch...case或者if...else语句的使用， 避免了程序的复杂性,提高系统的可 维护性。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Context context=new Context();
		context.setLiftState(new CloseState());
		context.open();
		context.close();
		context.run();
		context.stop();
	}

}
