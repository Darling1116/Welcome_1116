package Test1_4_1;
import java.text.SimpleDateFormat;
import java.util.Date;

 class A {
/*public static void main(String[] args) {
	Date d1 = new Date();
	SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss");
	System.out.println(f.format(d1));
	*/
	
		public int getNumber(int a){
			return a+5;
		}
}
	
	class Date_exam01 extends A{
		public int getNumber(int a){
			return a+200;
		}
	public static void main(String args[]){
		Date_exam01 b=new Date_exam01();
			System.out.println(b.getNumber(20));
		}
	}




