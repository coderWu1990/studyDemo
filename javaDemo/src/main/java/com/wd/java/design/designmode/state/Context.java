package com.wd.java.design.designmode.state;

public class Context {

	public static final OpenState OPEN_STATE = new OpenState();
	public static final CloseState CLOSE_STATE = new CloseState();
	public static final RunState RUN_STATE = new RunState();
	public static final StopState STOP_STATE = new StopState();

	private LiftState liftState;

	public LiftState getLiftState() {
		return liftState;
	}

	public void setLiftState(LiftState liftState) {
		this.liftState = liftState;
		// 把当前的环境通知到各个实现类中
		this.liftState.setContext(this);
	}

	public void open() {
		this.liftState.open();
	};

	public void close() {
		this.liftState.close();
	};

	public void run() {
		this.liftState.run();
	};

	public void stop() {
		this.liftState.stop();
	};

}
