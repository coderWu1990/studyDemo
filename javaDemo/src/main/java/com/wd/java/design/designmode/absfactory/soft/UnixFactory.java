package com.wd.java.design.designmode.absfactory.soft;

public class UnixFactory implements SoftFactory{

	@Override
	public Soft createText() {
		// TODO Auto-generated method stub
		return new UnixTextSoft();
	}

	@Override
	public Soft createImage() {
		// TODO Auto-generated method stub
		return new UnixImageSoft();
	}

}
