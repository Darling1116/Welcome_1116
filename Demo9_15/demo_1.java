package Demo9_15;

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
		
	
	//删除所有值为key的结点:最后考虑头结点（防止前面几个数权威key）
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
		this.head = null;
		//可以直接把head置空，因为当head后面的结点没有被引用时，就会自动被回收。
	}
	
	//单链表逆置（两种方法）
//	public MyLinkedList reverse(){
//		
//	}
	
	//找中间结点
//	public Node middleNode(){
//		
//	}
	
	//找倒数第k个结点
//	public Node lastkNode(){
//		
//	}
	
	
}
	
	
	
	
public class demo_1 {
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		list.addFirst(1);
		list.addFirst(3);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(2);
		list.addFirst(2);
		list.addLast(66);
		list.display();
//		list.addIndex(3, 11);
//		list.remove(1);
		list.removeAllkey(2);
		list.display();
		
		int size = list.size();
		System.out.println(size);
		
//		Node prev = list.searchPrev(3);
//		System.out.println(prev.val);
		
//		boolean res = list.contains(3);
//		System.out.println(res);
	}
}

