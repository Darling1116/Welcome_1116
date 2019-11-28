package Test11_5;

public class Exam_01 {
public static void main(String[] args) {
	Object boolobj = true;
	if(boolobj instanceof Boolean) {
		boolean b = (Boolean)boolobj;
		System.out.println(b);
		}
}
}
