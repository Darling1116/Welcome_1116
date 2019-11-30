package Test11_9;

public class Exam_01 {
public static void main(String[] args) {
	/*
	int arr[] = new int[5];
	arr[10] = 2;
	System.out.println(arr);
	*/
	int j = Integer.parseInt("90");
	System.out.println(j);
	
	try{
		int arr[] = new int[5];
		arr[10] = 10;
	}//有匹配捕获异常的方法
	catch(ArrayIndexOutOfBoundsException e){
		System.out.println("index out of bound.");
	}
	finally{
		System.out.println("this line is always executed.");
		System.out.println("end of main() method.");
	}
}
}
