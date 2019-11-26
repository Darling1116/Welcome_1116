package Test10_30;

public class Exam_01 {
	public static void main(String[] args) {
		String s1 = new String("I am a good student");
		System.out.println("有字符串： "+s1);
		System.out.println("长度为"+s1.length());
		System.out.println("其第一个字符是"+s1.charAt(0));
		System.out.print("用teacher代替student后，输出为：");
		System.out.println(s1.replaceAll("student", "teacher"));
	}
}
