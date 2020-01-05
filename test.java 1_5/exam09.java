package Test1_5;

class exam{
	private static int num=0;
	exam(double r){
		num++;
	}
	public static void count(){
		System.out.println("num="+num);
	}
}

public class exam09 {
public static void main(String[] args) {
	exam.count();
	exam c1 = new exam(2.0);
	exam.count();
	exam c2 = new exam(1.0);
	exam.count();
	
}
}
