package Demo9_16;

import java.util.Currency;

class Node{
	public int val;
	public Node next;
	
	public Node(int val){
		this.val = val;	
		this.next = null;
	}
}


//构造单链表,属性为head,方法如下：
class MyLinkedList{
	public Node head;
	
	
	//头插法
	public void addFirst(int data){
		Node newnode = new Node(data);
		if(this.head == null){
			this.head = newnode;
		}
		else{
			newnode.next = this.head;
			this.head = newnode;
		}
	}
		
	
	//尾插法
	public void addLast(int data){
		Node newnode = new Node(data);
		if(this.head == null){
			this.head = newnode;
		}
		else{
			Node cur = this.head;
			while(cur.next != null){
				cur = cur.next;
			}
			cur.next = newnode;
		}
	}
		
	
	//任意位置插入，第一个数据的下标为0
	public void addIndex(int index, int data){
		Node newnode = new Node(data);
		if(index == 0){
			newnode.next = this.head;
			this.head = newnode;
		}
		else{
			Node cur = this.head;
			Node prev = null;
			while(index != 0){
				--index;
				prev = cur;
				cur = cur.next;
			}
			newnode.next = cur;
			prev.next = newnode;
		}
	}
		
	
	//查找关键字key是否在单链表中
	public boolean contains(int key){
		Node cur = this.head;
		while(cur != null){
			if(cur.val == key){
				return true;
			}
			else{
				cur = cur.next;
			}
		}
		return false;
	}
	
	
	//删除第一次出现关键字key的结点:先找前驱
	public Node searchPrev(int key){
		Node cur = this.head;
		Node prev = null;
		while(cur.val != key){
			prev = cur;
			cur = cur.next;
		}
		return prev;
	}
	
	public void remove(int key){
		if(this.head.val == key){
			this.head = this.head.next;
		}
		Node prev = searchPrev(key);
		prev.next = prev.next.next;
	}
		
	
	//删除所有值为key的结点:最后考虑头结点（防止前面几个数全为key）
	public void removeAllkey(int key){
		Node cur = this.head.next;
		Node prev = this.head;
		while(cur != null){
			if(cur.val == key){
				cur = cur.next;
				prev.next = cur;
			}
			else{
				prev = cur;
				cur = cur.next;
			}
		}
		if(this.head.val == key){
			this.head = this.head.next;
		}
	}
		
	
	//得到单链表的长度
	public int size(){
		Node cur = this.head;
		int size = 0;
		while (cur != null){
			size++;
			cur = cur.next;
		}
		return size;
	}
		
	public void display(){
		Node cur = this.head;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
	}
		
	
	public void clear(){
		//可以直接把head置空，因为当head后面的结点没有被引用时，就会自动被回收。
		this.head = null;
	}
	
	
	//单链表逆置（两种方法）
	public Node reverseList(){
		Node cur = this.head;
		Node prev = null;
		Node newhead = null;
		//三指针法(cur,prev,newhead)：把第一个元素当做新的头结点，新的头结点是原链表的最后一个结点
		while(cur != null){
			Node curNext = cur.next;  //每次循环进来，标记当前结点的下一个结点
			if(cur.next == null){  //说明此时cur为原链表的最后一个结点
				newhead = cur;
			}
			cur.next = prev;
			prev = cur;
			cur = curNext;
		}
		return newhead;
	}
	
	
	public Node reverseList2(){
		//头插法:先把原头结点的next置空，从第二个元素开始进行头插
		Node cur = this.head.next;
		this.head.next = null;
		while(cur != null){
			Node curNext = cur.next;
			cur.next = this.head;
			this.head = cur;
			cur = curNext;
			
		}
		return this.head;
	}
	
	public void display2(Node newhead){
		Node cur = newhead;
		while(cur != null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	//找中间结点：快慢指针法
	public Node middleNode(){
		Node fast = this.head;
		Node slow = this.head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	//找倒数第k个结点:先让快指针先走k-1步，然后快慢指针同时走
	public Node lastkNode(int k){
		Node fast = this.head;
		Node slow = this.head;
		while(k>1){
			--k;
			fast = fast.next;
		}
		while(fast.next!=null && fast!=null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
}
	
	
public class demo_1 {
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(6);
		//list.addFirst(6);
		list.display();
//		Node newhead = list.reverseList();
//		list.display2(newhead);
		
//		Node newlist = list.reverseList2();
//		list.display2(newlist);
		
//		Node retNode = list.middleNode();
//		System.out.println(retNode.val);
		
		Node retNode2 = list.lastkNode(5);
		System.out.println(retNode2.val);
	}
	
}
