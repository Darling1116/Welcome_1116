package Test12_26;

class SuperA{
	public int getNumber(int a){
		return a+5;
	}
}


public class Test_exam02 extends SuperA {
	
	public int getNumber(int a){
		return a+200;
	}
	
public static void main(String[] args) {
	Test_exam02 b = new Test_exam02();
	System.out.println(b.getNumber(20));
}
}
