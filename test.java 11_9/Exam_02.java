package Test11_9;

public class Exam_02 {
public static void main(String[] args) {
	try{
		int arr[] = new int[5];
		arr[10] = 2;
	}//没有匹配捕获异常的方法
	catch(ArithmeticException e){
		System.out.println("index out of bound.");
	}
	finally{
		System.out.println("this line is always executed.");
		System.out.println("end of main() method.");
	}
}
}
