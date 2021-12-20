package Demo12_20;

class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

class MyLinkedList {
	public ListNode head;

	// 头插法
	public void addFirst(int data) {
		ListNode newnode = new ListNode(data);
		if (this.head == null) {
			this.head = newnode;
		} else {
			newnode.next = this.head;
			this.head = newnode;
		}
	}
}

public class Offer_06 {
	// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
	public static int[] reversePrint(ListNode head) {
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}

		int[] res = new int[count];
		ListNode p = head;
		int i = count - 1;
		while (p != null) {
			res[i--] = p.val;
			p = p.next;
		}
		return res;
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addFirst(1);
		list.addFirst(5);
		list.addFirst(3);
		list.addFirst(6);
		list.addFirst(8);
		list.addFirst(9);
		int[] arr = reversePrint(list.head);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
