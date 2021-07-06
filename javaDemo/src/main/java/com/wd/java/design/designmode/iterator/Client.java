package com.wd.java.design.designmode.iterator;

public class Client {

	/**
	 * 它提供一种方法访问一个容器对象中各个元素， 而又不需暴露该 对象的内部细节。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 定义一个List， 存放所有的项目 对象
		IProject project = new Project();
		// 增加星球大战项目
		project.add("星球大战项目 ddddd", 10, 100000);
		// 增加扭转时空项目
		project.add("扭转时空项目 ", 100, 10000000);
		// 增加超人改造项目
		project.add("超人改造项目 ", 10000, 1000000000);
		// 这边100个项目
		for (int i = 4; i < 14; i++) {
			project.add("第" + i + "个项目 ", i * 5, i * 1000000);
		}
		// 遍历一下ArrayList， 把所有的数据都取出
		IProjectIterator projectIterator = project.iterator();
		while (projectIterator.hasNext()) {
			IProject p = (IProject) projectIterator.next();
			System.out.println(p.getProjectInfo());
		}
	}

}
