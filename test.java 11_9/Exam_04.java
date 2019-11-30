package Test11_9;

public class Exam_04 {
public static void main(String[] args) {
	try{
		int arr[] = new int[5];
		arr[10] = 2;
	}
	catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Exception+"+e);
	}
	finally{
		System.out.println("end of main() method.");
	}
}
}
