package com.wd.java.design.old.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * // 继承Cloneable类 相当于prototype接口。wordDocument相当于ConcreteProttype拥有赋值调用 原型模式
 * 
 * @author ZH-SW-Wudi
 * 
 */

public class WordDocument implements Cloneable {

	// 文字
	private String mText = "";
	// 图片
	private List<String> mImages = new ArrayList<String>();

	public String getText() {
		return mText;
	}

	public void setText(String mText) {
		this.mText = mText;
	}

	public List<String> getImages() {
		return mImages;
	}

	public void setImages(List<String> mImages) {
		this.mImages = mImages;
	}

	public void addImage(String img) {
		this.mImages.add(img);
	}

	/**
	 * 打印文档内容
	 */
	public void showDocument() {
		System.out.println("----------- Word Content Start -----------");
		System.out.println("Text : " + mText);
		System.out.println("Images List: ");
		for (String imgName : mImages) {
			System.out.println("image name : " + imgName);
		}
		System.out.println("----------- Word Content End -----------");
	}

	// 在类中添加clone 进行浅拷贝
//	@Override
//	protected WordDocument clone() {
//		try {
//			WordDocument doc = (WordDocument) super.clone();
//			doc.mText = this.mText;
//			doc.mImages = this.mImages;
//			return doc;
//		} catch (Exception e) {
//		}
//		return null;
//	}

	@Override
	protected WordDocument clone() {
		try {
			WordDocument doc = (WordDocument) super.clone();
			doc.mText = this.mText;
			// 对mImages调用clone进行深度拷贝
			doc.mImages = ((List<String>) ((ArrayList<String>) this.mImages)
					.clone());
			return doc;
		} catch (Exception e) {
		}
		return null;
	}

}
