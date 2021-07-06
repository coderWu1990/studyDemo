package com.wd.java.algorithm.reversal;

public class ReversalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		ListNode next2=new ListNode(2);
		head.next=next2;
		ListNode next3=new ListNode(3);
		next2.next=next3;
		ListNode next4=new ListNode(4);
		next3.next=next4;
		ListNode next5=new ListNode(5);
		next4.next=next5;
		ListNode next6=new ListNode(6);
		next5.next=next6;
		//next6.next=head;
		System.out.println(head);
		System.out.println(reversalList1(head));
	}
	
	static int i=0;
	public static ListNode  reversalList1(ListNode head){
		ListNode pre=null;
		while (head!=null) {
			ListNode tmp=head.next;
			head.next=pre;
			pre=head;
			head=tmp;
			i++;
//			if (i == 6) {
//				System.out.println("pre=" + pre);
//				System.out.println("tmp=" + tmp);
//				System.out.println("head="+head);
//			}
		}
		return pre;
	}
	
	private ListNode reversal(ListNode head){
		ListNode pre=null;
		while (head.next!=null) {
			ListNode tmp=head.next;
			head.next=pre;
			pre=head;
			head=tmp;
		}
		return pre;
	}
	
	
	
	

}
