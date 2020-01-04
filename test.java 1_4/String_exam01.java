package Test1_4_1;

public class String_exam01 {
public static void main(String[] args) {
	String s = new String("Hello");
	String s1 = "hello";
	s1 = "l";
	System.out.println(s);
	System.out.println(s1);
	System.out.println(s.charAt(0));
	
	
	char[] arr = {'a','b','c'};
	String s2 = new String(arr);
	System.out.println(s2);
	String s3 = new String(arr,1,2);
	System.out.println(s3);
	
	String s5 = new String("Java语言");
	System.out.println(s5.charAt(0));
	System.out.println(s5.substring(0, 6));
	System.out.println(s5.lastIndexOf('a'));
	
	String s6 = new String("Java语言");
	System.out.println(s5.equals(s6));
	System.out.println(s5==s6);
	
	System.out.println(s6.replace('a', 'b'));
	System.out.println(s6);
	
	String s8 = "story";
	System.out.println(s+="books");
	System.out.println(s=s+100);
	

}
}
