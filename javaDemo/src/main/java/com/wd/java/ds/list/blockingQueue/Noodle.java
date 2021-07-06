package com.wd.java.ds.list.blockingQueue;

public class Noodle {

	private String name;
	private String price;
	private String productTime;
	private String productName;
	private String takeTime;
	private String takeName;
	
	public Noodle() {
		super();
	}
	
	public Noodle(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductTime() {
		return productTime;
	}

	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}

	public String getTakeName() {
		return takeName;
	}

	public void setTakeName(String takeName) {
		this.takeName = takeName;
	}

	@Override
	public String toString() {
		return "Noodle [name=" + name + ", price=" + price + ", productTime="
				+ productTime + ", productName=" + productName + ", takeTime="
				+ takeTime + ", takeName=" + takeName + "]";
	}

	

	
	
}
