package com.wd.java.design.designmode.state;

public class RunState extends LiftState {

	@Override
	void open() {
		// TODO Auto-generated method stub

	}

	@Override
	void close() {
		// TODO Auto-generated method stub

	}

	@Override
	void run() {
		// TODO Auto-generated method stub
		System.out.println("电梯上下运行. . . ");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.STOP_STATE);
		super.context.stop();
	}
}
