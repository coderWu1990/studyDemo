package com.wd.java.design.designmode.command;

public abstract class Command {

	protected CodeGroup codeGroup=new CodeGroup();
	protected PageGroup pageGroup=new PageGroup();
	protected RequirementGroup rqGroup=new RequirementGroup();
	
	abstract void exec();
	
}
