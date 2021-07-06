package com.wd.java.design.designmode.state;

public class CloseState extends LiftState {

	@Override
	void open() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.OPEN_STATE);
		super.context.open();

	}

	@Override
	void close() {
		// TODO Auto-generated method stub
		System.out.println("电梯门关闭. . . ");
	}

	@Override
	void run() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.RUN_STATE);
		super.context.run();
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.STOP_STATE);
		super.context.stop();
	}

}
