package Test10_31;

class A{
	double f(int x, double y){
		return x+y;
	}
	int f(int x, int y){
		return x*y;
	}
}

public class Exam_01 {
public static void main(String[] args) {
	A a = new A();
	System.out.println(a.f(10, 10.0));
	System.out.println(a.f(10, 10));
}
}
