package Test11_23;

import java.rmi.server.ObjID;

//线程死锁
class Thread_02 implements Runnable{
	private Object obj1;
	private Object obj2;
	public Thread_02(Object obj1,Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	public void run() {
		synchronized (obj1){
			try{
				Thread.sleep(10000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		synchronized (obj2) {
		System.out.println(obj2.toString()+"无法执行到这一步");	
		}
		
	}
}
public class Thread_exam02 {
public static void main(String[] args) {
	Object obj1 = new Object();
	Object obj2 = new Object();
	new Thread(new Thread_02(obj1, obj2)).start();
	new Thread(new Thread_02(obj2, obj1)).start();
}
}
