package com.wd.java.design.designmode.command;

public class DeleteCommand extends Command{

	@Override
	void exec() {
		// TODO Auto-generated method stub
		rqGroup.find();
		pageGroup.delete();
		codeGroup.delete();
		rqGroup.plan();
	}

}
