package Test11_21;

class ThreadExample implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程休眠前的时间为 "+System.currentTimeMillis());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程休眠后的时间为 "+System.currentTimeMillis());
	}
	
}


public class Thread_exam01 {
public static void main(String[] args) {
	ThreadExample t = new ThreadExample();
	Thread t1 = new Thread(t);
	t1.start();
}
}
