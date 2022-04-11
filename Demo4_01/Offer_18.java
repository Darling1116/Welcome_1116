package Demo4_01;

class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

// 构造单链表,属性为head,方法如下：
class MyLinkedList {
	public ListNode head;

	public void addFirst(int data) {
		ListNode newnode = new ListNode(data);
		if (this.head == null) {
			this.head = newnode;
		} else {
			newnode.next = this.head;
			this.head = newnode;
		}
	}

	public void display() {
		ListNode cur = this.head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// 删除单链表的某一个结点
	public ListNode deleteNode(int val) {
		if (this.head.val == val)
			return this.head.next;
		ListNode prev = head;
		ListNode cur = this.head.next;
		while (cur != null) {
			if (cur.val == val) {
				prev.next = cur.next;
				break;
			}
			prev = cur;
			cur = cur.next;
		}
		return this.head;
	}

}

public class Offer_18 {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addFirst(7);
		list.addFirst(5);
		list.addFirst(3);
		list.display();
		list.deleteNode(5);
		list.display();

	}
}
