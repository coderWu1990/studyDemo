package com.wd.java.design.designmode.memento.one;


public class Client {

	/**
	 * 在不破坏封装性的前提下， 捕获一个对象的内部状 态， 并在该对象之外保存这个状态。 这样以后就可将该对象恢复到原先保存的状态
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 定义发起人
		Originator originator = new Originator();
		// 建立初始状态
		originator.setState("初始状态. . . ");
		System.out.println("初始状态是： " + originator.getState());
		// 建立备份
		originator.createMemento();
		// 修改状态
		originator.setState("修改后的状态. . . ");
		System.out.println("修改后状态是： " + originator.getState());
		// 恢复原有状态
		originator.restoreMemento();
		System.out.println("恢复后状态是： " + originator.getState());
	}

}
