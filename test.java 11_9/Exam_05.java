package Test11_9;

public class Exam_05 {
public static void main(String[] args) {
	String friends[] = {"lisa","bily","kessy"};
	try{
	for(int i=0;i<5;i++){
		System.out.print(friends[i]+" ");
	}
	}
	catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e+" 被抛出");
	}
	System.out.println("this is the end.");
}
}
