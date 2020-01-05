package Test1_5;

class BB{
	public int getNum(int a){
		return a+1;
	}
}

public class exam10 extends BB{
	public int getNum(int a){
		return a+100;
	}
public static void main(String[] args) {
	exam10 b = new exam10();
	System.out.println(b.getNum(10));
}
}
