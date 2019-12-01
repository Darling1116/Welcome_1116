package Test11_18;


class MyThread implements Runnable{
	private int ticket = 6;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"卖票"+
						"还剩下"+(ticket--)+"张票");
			}
		}
	}
	
}
public class Thread_exam04 {
public static void main(String[] args) {
	MyThread t = new MyThread();
	Thread t1 = new Thread(t);
	Thread t2 = new Thread(t);
	Thread t3 = new Thread(t);
	t1.start();
	t2.start();
	t3.start();
	
}
}
