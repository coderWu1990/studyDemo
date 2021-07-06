package com.wd.java.design.designmode.decorator;

public abstract class Decorator extends Component{
	private Component component;

	public Decorator(Component component) {
		super();
		this.component = component;
	}
	
	@Override
	void operate() {
		// TODO Auto-generated method stub
		this.component.operate();
	}
	
}
