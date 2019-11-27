package Test10_31;
class A1{
public int getNumber(int a){
	return a+1;
}
}
public class Exam_05 extends A1 {
	public int getNumber(int a)
	{
		return a+100;
	}

public static void main(String[] args) {
	Exam_05 b = new Exam_05();
	System.out.println(b.getNumber(10));
}
}
