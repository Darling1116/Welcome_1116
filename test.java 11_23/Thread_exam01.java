package Test11_23;

//wait、modify实现线程同步
class Thread_1 implements Runnable{
	public void run() {
		
		try{
			Thread.sleep(10000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		synchronized(this){
			System.out.println("执行第二步");
			notify();
			System.out.println("执行第三步");
		}
	}
}
public class Thread_exam01 {
public static void main(String[] args) {
	Thread_1 t =  new Thread_1();
	new Thread(t).start();
	
	synchronized(t){
		try{
			System.out.println("执行第一步");
			t.wait();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("执行第四步");
	}
}
}
