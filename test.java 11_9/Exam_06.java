package Test11_9;

public class Exam_06 {
public static void main(String[] args) throws Exception{
	division(30,3);
	division(30,0);
	System.out.println("程序结束");
}

public static void division(int sum,int number){
	System.out.println("计算除法");
	try
	{
	int average = sum/number;
	System.out.println("结果："+average);
	}
	catch(Exception e){
		System.out.println(e+"被抛出");
	}
	
}
}
