package Test10_30;

class Mycalss{
	public static int mumber=1;
	public static int getmumber(){
		return mumber;
	}
}

public class Exam_05 {
public static void main(String[] args) {
	Mycalss mi = new Mycalss();
	System.out.println(mi.mumber);
	System.out.println(mi.getmumber());
}
}
