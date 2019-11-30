package Test11_9;

public class Procedure_Exception {
public static void main(String[] args) {
	int a=4,b=0;
	try{
		if(b==0)
			throw new ArithmeticException();
		else
			System.out.println(a+"/"+b+"="+a/b);
	}
	catch(ArithmeticException e){
		System.out.println(e+" throwed");
	}
}
}
