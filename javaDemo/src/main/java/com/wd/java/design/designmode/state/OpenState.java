package com.wd.java.design.designmode.state;

public class OpenState extends LiftState {

	@Override
	void open() {
		// TODO Auto-generated method stub
		System.out.println("电梯门开启. . . ");

	}

	@Override
	void close() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.CLOSE_STATE);
		// 动作委托为CloseState来执行
		super.context.close();

	}

	@Override
	void run() {
		// TODO Auto-generated method stub
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
	}

}
