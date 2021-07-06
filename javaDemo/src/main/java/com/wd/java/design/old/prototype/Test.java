package com.wd.java.design.old.prototype;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	private static void test1(){
		WordDocument document=new WordDocument();
		document.setText("原始文档");
		document.addImage("图片1");
		document.addImage("图片2");
		document.addImage("图片3");
		document.showDocument();
		WordDocument document2=document;
		document2.setText("变化的文档");
		document2.getImages().remove(0);
		document2.showDocument();
		document.showDocument();
	}
	
	private static void test2(){
		WordDocument document=new WordDocument();
		document.setText("原始文档");
		document.addImage("图片1");
		document.addImage("图片2");
		document.addImage("图片3");
		document.showDocument();
		WordDocument document2=document.clone();
		document2.setText("变化的文档");
		document2.getImages().remove(0);
		document2.showDocument();
		document.showDocument();
	}

}
