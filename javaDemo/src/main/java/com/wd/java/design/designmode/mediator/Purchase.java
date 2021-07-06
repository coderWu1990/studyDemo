package com.wd.java.design.designmode.mediator;

public class Purchase extends AbsColleague {

	public Purchase(AbsMediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	// 采购IBM电脑
	public void buyIBMcomputer(int number) {
		super.mediator.execute("purchase.buy" , number);
	}

	// 不再采购IBM电脑
	public void refuseBuyIBM() {
		System.out.println("不再采购IBM电脑");
	}

}
