package com.wd.java.design.designmode.absfactory.soft;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SoftFactory window=new WindowFactory();
		Soft tex=window.createText();
		tex.platform();
		tex.name();
		Soft img=window.createImage();
		img.platform();
		img.name();
		
	}

}
