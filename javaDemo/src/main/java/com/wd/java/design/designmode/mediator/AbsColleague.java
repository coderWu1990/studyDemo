package com.wd.java.design.designmode.mediator;

public abstract class AbsColleague {

	protected AbsMediator mediator=null;
	
	public AbsColleague(AbsMediator mediator) {
		this.mediator=mediator;
	}
}
