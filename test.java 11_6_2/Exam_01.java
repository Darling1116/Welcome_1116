package Test11_6;

import java.util.Stack;

public class Exam_01 {
public static void main(String[] args) {
	Stack st1 = new Stack();
	st1.add("i");
	st1.push("am");
	st1.push("a");
	st1.push("student");
	System.out.println(st1.peek());
	//System.out.println(st1.pop());
	System.out.println(st1);
	
	int a = st1.search("a");
	System.out.println(a);
	System.out.println(st1.search("a"));
}
}
