package Test11_22;

class ThreadShare_02 implements Runnable{
	
	public static synchronized void test(){
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
	@Override
	public void run() {
		// TODO Auto-generated method stub
		test();
	}
	
}
public class Thread_exam03 {
public static void main(String[] args) {
	ThreadShare_02 ts = new ThreadShare_02();
	Thread t1 = new Thread(ts);
	Thread t2 = new Thread(ts);
	t1.start();
	t2.start();
}
}
