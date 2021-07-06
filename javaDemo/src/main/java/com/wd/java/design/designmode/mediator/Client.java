package com.wd.java.design.designmode.mediator;

/**
 * 中介者模式的优点就是减少类间的依赖， 把原有的一对多的依赖变成了一对一的依赖， 同事类只依赖中介者， 减少了依赖， 当然同时也降低了类间的耦合
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mediator mediator=new Mediator();
		Purchase purchase=new Purchase(mediator);
		Sale sale=new Sale(mediator);
		Stock stock=new Stock(mediator);
		mediator.setPurchase(purchase);
		mediator.setSale(sale);
		mediator.setStock(stock);
		
		purchase.buyIBMcomputer(100);
		sale.sellIBMComputer(1);
		stock.clearStock();
	}

}
