package com.wd.java.design.designmode.handler;

public abstract class Handler {
	private int type;
	private Handler next;
	public Handler(int type) {
		super();
		this.type = type;
	}

	void handlerMsg(Iwomen wumen){
		if(wumen.getType()==this.type){
			response();
		}else{
			if(next!=null){
				next.handlerMsg(wumen);
			}else{
				System.out.println("没人处理，不同意");
			}
			
		}
	};
	
	void setNext(Handler handler){
		this.next=handler;
	};
	
	abstract void response();
}
