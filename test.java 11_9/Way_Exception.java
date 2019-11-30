package Test11_9;

public class Way_Exception {
	public static void divide(int a,int b)throws ArithmeticException{
		int c;
		c=a/b;
	}
public static void main(String[] args) {
	try{
		divide(4,0);
	}
	catch(ArithmeticException e){
		System.out.println(e+" throwed");
	}
}
}
