package Demo9_18;

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
		
		 //判断是否有环：如果有环，快慢指针一定会相遇
	    public boolean hasCycle() {
	    	if(this.head == null){
	    		return false;
	    	}
	        Node fast = this.head;
	        Node slow = this.head;
	        while(fast!=null && fast.next!=null){
	        //用fast来控制链表的遍历：如果没有环，fast势必会有为空的时候
	        	fast = fast.next.next;
	        	slow = slow.next;
	        	if(fast == slow){
	        		return true;
	        	}
	        }
	        return false;
	    }
	    
	    
	    //判断链表是否有环，并返回入环的第一个结点
	    public Node detectCycle() {
	    	if(this.head == null){
	    		return null;
	    	}
	        Node fast = this.head;
	        Node slow = this.head;
	        while(fast!=null && fast.next!=null){
	        //用fast来控制链表的遍历：如果没有环，fast势必会有为空的时候
	        	fast = fast.next.next;
	        	slow = slow.next;
	        	if(fast == slow){
	        		//快慢指针相遇：有环
	        		//然后让一个指针从头开始走，另一个指针从相遇点开始走，两指针相遇的地方，就是环的入口
	        		Node cur = this.head;
	        		while(cur != slow){
	        			cur = cur.next;
	        			slow = slow.next;
	        		}
	        		return cur;
	        	}
	        }
	        //fast为空，说明肯定没环
	        return null;
	    }
	    
	    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
	    public Node getIntersectionNode(Node headA, Node headB) {
	    	if(headA==null || headB==null){
	    		return null;
	    	}
	    	Node pA = headA;
	    	Node pB = headB;
	        int lenA = 0;
	        int lenB = 0;
	        while(pA != null){
	        	lenA++;
	        	pA = pA.next;
	        }
	        while(pB != null){
	        	lenB++;
	        	pB = pB.next;
	        }
	        int k = Math.abs(lenA-lenB);
	        //让curA指向较长的链表
	        Node curA = headA;
	        Node curB = headB;
	        if(lenB > lenA){
	        	curA = headB;
	        	curB = headA;
	        }
	        while(k!=0){
	        	k--;
	        	curA = curA.next;
	        }
	        while(curA!=curB && curA!=null && curB!=null){
	        	curA = curA.next;
	        	curB = curB.next;
	        }
	        if(curA == curB){
        		return curA;
        	}
	        else{
	        	return null;
	        }
	        
	        
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
		}
	}
		
