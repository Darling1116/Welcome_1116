package Test11_18;


class Tthread extends Thread{
	private int ticket = 6;
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(ticket>0){
				System.out.println(this.getName()+"卖了"+(ticket--)+"张票");
			}
		}
	}
}
public class Thread_exam03 {
public static void main(String[] args) {
	Tthread t1 = new Tthread();
	Tthread t2 = new Tthread();
	Tthread t3 = new Tthread();
	t1.start();
	t2.start();
	t3.start();
}
}
