package Test11_22;

class ThreadShare_04 implements Runnable{
	
	public static void test(){
		synchronized(ThreadShare_04.class){
			for(int i=0;i<5;i++){
				try{
					Thread.sleep((int)Math.random()*10);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+": "+i);
			}
		}
	}
	public void run() {
		test();
	}
}

public class Thread_exam05 {
public static void main(String[] args) {
	ThreadShare_04 ts = new ThreadShare_04();
	Thread t1 = new Thread(ts);
	Thread t2 = new Thread(ts);
	t1.start();
	t2.start();
}
}
