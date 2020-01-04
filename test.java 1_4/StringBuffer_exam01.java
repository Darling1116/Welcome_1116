package Test1_4_1;

public class StringBuffer_exam01 {
public static void main(String[] args) {
	StringBuffer sb1 = new StringBuffer("hello");
	sb1.setCharAt(0, 'a');
	System.out.println(sb1);
	sb1.append("aaa");
	System.out.println(sb1);
	
	Integer i = 129;
	Integer j = 129;
	System.out.println(i==j);
	int m = i.intValue();
	double n = 123.89;
	System.out.println(Math.ceil(n));
	System.out.println(Math.floor(n));
}
}
