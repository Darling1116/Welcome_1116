package Test10_31;

class AA{
	double f(double x,double y){
		return x+y;
	}
}

class B extends AA{
	double f(int x,int y){
		return x*y;
	}
}
public class Exam_02 {
public static void main(String[] args) {
	B b = new B();
	System.out.println(b.f(3, 5));
	System.out.println(b.f(3.0, 5.0));
	
}
}
