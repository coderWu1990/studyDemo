package com.wd.java.algorithm.reversal;

public class Reversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<String> head = initLinkedList();

		//print(reversal(head));
		print(reverseKGroup(head, 3));
	}

	private static Node initLinkedList() {
		Node<String> head = new Node<String>("node0");
		Node<String> temp = head;
		for (int i = 1; i < 8; i++) {
			Node<String> node = new Node<String>("node" + i);
			temp.next = node;
			temp = node;
		}
		return head;
	}

	private static void print(Node<String> temp) {
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println("=" + temp.value);
			if (temp.next != null) {
				temp = temp.next;
			} else {
				break;
			}
		}
	}

	private static class Node<K> {
		private K value;
		private Node<K> next;
		public Node(K v) {
			value = v;
		}
	}

	private static Node reversal(Node<String> head) {
		Node<String> pre = null;
		while (head != null) {
			Node<String> temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}

	/**
	 * 以k为一组逆序
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node reverseKGroup(Node head, int k) {
		Node temp = head;
		for (int i = 1; temp != null && i % k != 0; i++) {
			temp = temp.next;
		}
		// 判断节点的数量是否能够凑成一组
		if (temp == null)
			return head;

		Node t2 = temp.next;
		temp.next = null;
		// 把当前的组进行逆序
		Node newHead = reverseList(head);
		// 把之后的节点进行分组逆序
		Node newTemp = reverseKGroup(t2, k);
		// 把两部分连接起来
		head.next = newTemp;
		return newHead;
	}

	/**
	 * 通过递归逆序链表
	 * 
	 * @param head
	 * @return
	 */
	private static Node reverseList(Node head) {
		if (head == null || head.next == null)
			return head;
		Node result = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}

}
