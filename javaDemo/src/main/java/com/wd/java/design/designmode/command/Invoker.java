package com.wd.java.design.designmode.command;

public class Invoker {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void action(){
		command.exec();
	}
}
