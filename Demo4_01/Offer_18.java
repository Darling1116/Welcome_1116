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

	// 反转链表_1
	public ListNode reverseList_1() {
		ListNode newhead = null;
		ListNode cur = this.head;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = newhead;
			newhead = cur;
			cur = tmp;
		}
		return newhead;
	}

	// 反转链表_2
	public ListNode reverseList_2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newhead = reverseList_2(head.next);
		head.next.next = head;
		head.next = null;
		return newhead;
	}

	// 找链表中的倒数第k个结点
	public ListNode getKthFromEnd(int k) {
		ListNode fast = this.head;
		ListNode slow = this.head;
		while (k != 0) {
			fast = fast.next;
			k--;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}

public class Offer_18 {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addFirst(7);
		list.addFirst(5);
		list.addFirst(3);
		list.display();
		// list.deleteNode(5);
		ListNode kNode = list.getKthFromEnd(2);
		System.out.println(kNode.val);

	}
}
