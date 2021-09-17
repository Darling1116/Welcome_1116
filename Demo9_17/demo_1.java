package Demo9_17;


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
	
	
	//链表分割:设置两个链表，一个放小于x的，一个放大于x的
	public Node partition(int x) {
		Node a1 = null;
		Node a2 = null;
		Node b1 = null;
		Node b2 = null;
		Node cur = this.head;
		while(cur != null){
			if(cur.val < x){  //小于x的结点，放在a段
				if(a1 == null){
					a1 = cur;
					a2 = cur;
				}
				else{
					a2.next = cur;
					a2 = cur;
				}
			}
			else{  //大于x的结点，放在b段
				if(b1 == null){
					b1 = cur;
					b2 = cur;
				}
				else {
					b2.next = cur;
					b2 = cur;
				}
			}
			cur = cur.next;
		}
		if(a1 == null){ //第一段为空
			if(b1 == null){
				return null;
			}
			b2.next = null;
			return b1;
		}
		else{  
			if(b1 == null){
				a2.next = null;
			}
			else{
			a2.next = b1;
			b2.next = null;
			}
			return a1;
		}
	}
	
	
	//删除链表中的重复结点：重复结点不保留
	public Node deleteDuplication() {
		//设置一个虚拟的新头结点：用来标不重复结点组成的链表
		Node newhead = new Node(-1); 
		Node p = newhead;//用来进行新链表的尾插
		Node cur = this.head;
		if(cur == null){
			return null;
		}
		while(cur != null){
			//要保证cur,cur.next在有效范围内
			if(cur.next!=null && cur.val == cur.next.val){
				while(cur!=null && cur.next!=null && cur.val==cur.next.val){
					cur = cur.next;
				}
				cur = cur.next; //不保留重复元素，cur需要向前再走一步
			}
			else{
				Node curnext = cur.next;
				p.next = cur;
				p = cur;
				cur = curnext;
			}
		}
		p.next = null;
		return newhead.next;
    }
	
	
	//判断是否是回文结构
    public boolean chkPalindrome() {
    	//1.找中间结点：把链表分成两部分
    	Node fast = this.head;
    	Node slow = this.head;
    	while(fast!=null && fast.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;  
    		//此时，slow为中间结点，即后一段的开始结点
    	}
    	//2.翻转后面一部分链表
    	Node prev = slow;
    	Node cur = slow.next;
    	while(cur!=null){
    		//使用三指针法时，每次都要保存cur.next结点
    		Node curnext = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = curnext;
    		//此时，prev就是后一段的头结点
    	}
    	//3.从两头向中间比较
    	Node p = this.head;
    	Node q = prev;
    	while(p != q){
    		if(p.val!=q.val){
    			return false;
    		}
    		else{
    			if(p.next == q){  //链表有偶数个结点
    				return true;
    			}
    			p = p.next;
    			q = q.next;
    		}
    	}
    	return true;
    }
}


public class demo_1 {
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		list.addFirst(7);
		list.addFirst(5);
		list.addFirst(3);
		list.addFirst(3);
		list.addFirst(5);
		list.addFirst(7);
		list.display();
		
		//list.partition(6);
		//list.deleteDuplication();
		boolean res = list.chkPalindrome();
		System.out.println(res);
		//list.display();
		
		
	}
}