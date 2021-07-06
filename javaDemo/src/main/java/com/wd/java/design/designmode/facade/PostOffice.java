package com.wd.java.design.designmode.facade;

public class PostOffice {

	private Letter letter=new LetterImpl();
	private Police police=new Police();
	
	public void sendLetter(String context,String addr){
		letter.writeContext(context);
		letter.fillEnvelope(addr);
		police.checkLetter(letter);
		letter.letterInotoEnvelope();
		letter.sendLetter();
	}
}
