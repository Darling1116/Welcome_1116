package Test1_5;

class son extends exam04{
	int a = 0;
	public void plus(){
		a++;
	}
	public int getA(){
		return super.a;
	}
}

public class exam04 {
	int a = 100;
	public void miner(){
		a--;
	}
	
public static void main(String[] args) {
	exam04 a = new exam04();
	son y = new son();
	System.out.println(y.a);
	System.out.println(y.getA());
	y.miner();
	System.out.println(y.a);
	System.out.println(y.getA());
}
}
