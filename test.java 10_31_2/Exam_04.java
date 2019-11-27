package Test10_31;

class CCircle{
	private static int num=0;
	public CCircle(double r){
		num++;
	}
	
	public static void count(){
		System.out.println("num="+num);
	}
}

public class Exam_04 {
public static void main(String[] args) {
	CCircle.count();
	CCircle cir1 = new CCircle(2.0);
	CCircle.count();
	CCircle cir2 = new CCircle(3.0);
	CCircle.count();

}
}
