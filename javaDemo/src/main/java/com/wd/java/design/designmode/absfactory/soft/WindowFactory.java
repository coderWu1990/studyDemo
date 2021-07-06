package com.wd.java.design.designmode.absfactory.soft;

public class WindowFactory implements SoftFactory{

	@Override
	public Soft createText() {
		// TODO Auto-generated method stub
		return new WindowTextSoft();
	}

	@Override
	public Soft createImage() {
		// TODO Auto-generated method stub
		return new WindowImageSoft();
	}

}
