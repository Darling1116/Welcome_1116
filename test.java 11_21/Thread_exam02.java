package Test11_21;

class ThreadOne extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ThreadOne 开始.....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadOne 结束.....");
	}
	
}

class ThreadTwo extends Thread{
	private ThreadOne t1;
	ThreadTwo(ThreadOne t){
		this.t1 = t;
		
	}
	public void run() {
		System.out.println("ThreadTwo 开始.....");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThraedTwo 结束.....");
	}
}

public class Thread_exam02 {
public static void main(String[] args) {
	ThreadOne t1 = new ThreadOne();
	ThreadTwo t2 = new ThreadTwo(t1);
	t2.start();
}
}
