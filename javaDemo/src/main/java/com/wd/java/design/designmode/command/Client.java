package com.wd.java.design.designmode.command;

/**
 * 类间解耦 调用者角色与接收者角色之间没有任何依赖关系， 调用者实现功能时只需调用Command 抽象类的execute方法就可以，
 * 不需要了解到底是哪个接收者执行。 
 * ● 可扩展性 Command的子类可以非常容易地扩展， 而调用者Invoker和高层次的模块Client不产生严
 * 重的代码耦合。 
 * ● 命令模式结合其他模式会更优秀 命令模式可以结合责任链模式， 实现命令族解析任务； 结合模板方法模式， 则可以减少
 * Command子类的膨胀问题。
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		Invoker zs = new Invoker();
		zs.setCommand(new DeleteCommand());
		zs.action();
	}

}
