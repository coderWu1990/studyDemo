package com.wd.java.design.designmode.iterator;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ProjectIterator implements IProjectIterator {

	// 所有的项目 都放在ArrayList中
	private ArrayList<IProject> projectList = new ArrayList<IProject>();
	private int currentItem = 0;

	// 构造函数传入proj ectList
	public ProjectIterator(ArrayList<IProject> projectList) {
		this.projectList = projectList;
	}

	// 判断是否还有元素， 必须实现
	@Override
	public boolean hasNext() {
		// 定义一个返回值
		boolean b = true;
		if (this.currentItem >= projectList.size()) {
			b = false;
		}
		return b;
	}

	// 取得下一个值
	public IProject next() {
		return (IProject) this.projectList.get(this.currentItem++);
	}

	// 删除一个对象
	public void remove() {
		// 暂时没有使用到
	}

	@Override
	public void forEachRemaining(Consumer arg0) {
		// TODO Auto-generated method stub
	}

}
