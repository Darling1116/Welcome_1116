package Test10_30;

public class Exam_04 {
public static void main(String[] args) {

	StringBuffer s = new StringBuffer("hello");
	s.setCharAt(1,'l');
	System.out.println(s);
	s.replace(0, 2, "mm");
	System.out.println(s);
}
}
