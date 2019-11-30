package Test11_9;

import java.util.Scanner;

public class Exam_07 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("除法运算，请输入两个数：");
	int first = in.nextInt();
	int second = in.nextInt();
	int result;
	try{
		result=first/second;
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println(first+"不可以除"+second);
	    result = 0;
	}
	finally{
		System.out.println("默认结束");
	}
	System.out.println("结束");
}
}
