package com.wd.java.design.designmode.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {

	/**
	 * 访问者模式 封装一些作用于某种 数据结构中的各元素的操作， 它可以在不改变数据结构的前提下定义作用于这些元素的新的操作
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 展示报表访问者
		IShowVisitor showVisitor = new ShowVisitor();
		// 汇总报表的访问者
		ITotalVisitor totalVisitor = new TotalVisitor();
		for (Employee emp : mockEmployee()) {
			emp.accept(showVisitor); // 接受展示报表访问者
			emp.accept(totalVisitor); // 接受汇总表访问者
		}
		// 展示报表
		showVisitor.report();
		// 汇总报表
		totalVisitor.totalSalary();
	}

	// 模拟出公司的人员情况， 我们可以想象这个数据是通过持久层传递过来的
	public static List<Employee> mockEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		// 产生张三这个员工
		CommonEmployee zhangSan = new CommonEmployee();
		zhangSan.setJob("编写Java程序， 绝对的蓝领、 苦工加搬运工");
		zhangSan.setName("张三");
		zhangSan.setSalary(1800);
		zhangSan.setSex("男");
		empList.add(zhangSan);
		// 产生李四这个员工
		CommonEmployee liSi = new CommonEmployee();
		liSi.setJob("页面美工， 审美素质太不流行了！ ");
		liSi.setName("李四");
		liSi.setSalary(1900);
		liSi.setSex("女");
		empList.add(liSi);
		// 再产生一个经理
		ManagerEmployee wangWu = new ManagerEmployee();
		wangWu.setName("王五");
		wangWu.setPerformance("基本上是负值， 但是我会拍马屁呀");
		wangWu.setSalary(18750);
		wangWu.setSex("男");
		empList.add(wangWu);
		return empList;

	}

}
