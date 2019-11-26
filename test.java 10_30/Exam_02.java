package Test10_30;

public class Exam_02 {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("学习Java语言");
		System.out.println("有字符串s: "+s);
		String s1 = s.reverse().toString();
		char[] d = s1.toCharArray();
		System.out.println(d);
		System.out.println("s的长度为: "+s.length());
		System.out.println("d的长度为: "+d.length);
	}
}
