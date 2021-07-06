package com.wd.java.design.designmode.memento;

public class Client {

	/**
	 * 备忘录模式是我们设计上“月 光宝盒”， 可以让我们回到需要的年代
	 * 在不破坏封装性的前提下， 捕获一个对象的内部状 态， 并在该对象之外保存这个状态。 这样以后就可将该对象恢复到原先保存的状态
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 定义出发起人
		Originator ori = new Originator();
		CareTaker taker = new CareTaker();
		// 初始化
		ori.setState1("中国");
		ori.setState2("强盛");
		ori.setState3("繁荣");
		System.out.println(" ===初始化状态===\n" + ori);
		// 创建一个备忘录
		taker.setMemento("1", ori.createMemento());
		// 修改状态值
		ori.setState1("软件");
		ori.setState2("架构");
		ori.setState3("优秀");
		taker.setMemento("2", ori.createMemento());
		System.out.println(" \n===修改后状态===\n" + ori);
		// 恢复一个备忘录
		ori.restoreMemento(taker.getMemento("1"));
		System.out.println(" \n===恢复后状态===\n" + ori);
		// 恢复2个备忘录
		ori.restoreMemento(taker.getMemento("2"));
		System.out.println(" \n===恢复后状态===\n" + ori);
	}

}
