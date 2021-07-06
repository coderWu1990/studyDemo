package com.wd.java.ds.heap;

import com.wd.java.ds.heap.Heap;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Heap h=new Heap(10);
		h.insert(1);
		h.insert(2);
		h.insert(3);
		h.insert(4);
		h.insert(5);
		h.insert(6);
		h.insert(7);
		h.insert(8);
		h.print();
	}

}
