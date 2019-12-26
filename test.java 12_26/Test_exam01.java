package Test12_26;

public class Test_exam01 {
public static void main(String[] args) {
	System.out.println("Hello".equals("hello"));
	System.out.println("java".equals("java"));
	
	int n=0,m=0,t=100;
	try{
		m=Integer.parseInt("888");
		n=Integer.parseInt("ab8");
		t=666;
	}
	catch(NumberFormatException e){
		System.out.println("Exception="+e);
	}
	System.out.println("n="+n+" m="+m+" t="+t);
}
}
