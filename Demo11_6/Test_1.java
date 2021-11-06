package Demo11_6;

import java.util.Stack;

class Node {
	public int val;
	public Node next;

	public Node(int val) {
		this.val = val;
		this.next = null;
	}
}

// 构造单链表,属性为head,方法如下：
class MyLinkedList {
	public Node head;

	// 头插法
	public void addFirst(int data) {
		Node newnode = new Node(data);
		if (this.head == null) {
			this.head = newnode;
		} else {
			newnode.next = this.head;
			this.head = newnode;
		}
	}

	public void display() {
		Node cur = this.head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// 判断是否是回文结构
	public boolean chkPalindrome() {
		Stack<Integer> st = new Stack<Integer>();
		Node p = this.head;
		while (p != null) {
			st.push(p.val);
			p = p.next;
		}
		Node cur = this.head;
		int data;
		while (!st.isEmpty()) {
			data = st.pop();
			if (data != cur.val) {
				return false;
			}
			cur = cur.next;
		}
		return true;

	}

}

public class Test_1 {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addFirst(7);
		list.addFirst(5);
		list.addFirst(3);
		list.addFirst(5);
		list.addFirst(5);
		list.addFirst(7);
		list.display();

		boolean res = list.chkPalindrome();
		System.out.print(res);
	}
}
