package Demo3_29;

import java.util.Stack;

//用栈实现队列
class CQueue {
	public Stack<Integer> st1;
	public Stack<Integer> st2;

	public CQueue() { // 构造函数:要实例化出对象
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}

	public void appendTail(int value) {
		// 直接st1中插入
		st1.push(value);
	}

	public int deleteHead() {
		if (!st2.isEmpty()) { // st2不为空
			return st2.pop();
		} else { // st2为空
			if (!st1.isEmpty()) {
				while (!st1.isEmpty()) {
					st2.push(st1.pop());
				}
				return st2.pop();
			} else {
				return -1;
			}

		}
	}
}

public class Offer_07 {
	public static void main(String[] args) {
		CQueue cq = new CQueue();
		cq.appendTail(1);
		cq.deleteHead();

	}
}
