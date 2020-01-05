package Test1_5;

class A{
	A(){
		System.out.println("Animal ");
	}
}

public class exam01 extends A{
	exam01(){
		System.out.println("Dog ");
	}
public static void main(String[] args) {
	exam01 e = new exam01();
}
}
