package Test11_25;

class MyThread_1 extends Thread{
	MyThread_1(String name){
		super(name);
	}
	public void run() {
		try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName()+" 通过收费站");
	}
	
}

public class Thread_exam01 {
public static void main(String[] args) {
	MyThread_1 t1 = new MyThread_1("1号车");
	MyThread_1 t2 = new MyThread_1("2号车");
	MyThread_1 t3 = new MyThread_1("3号车");
	MyThread_1 t4 = new MyThread_1("4号车");
	MyThread_1 t5 = new MyThread_1("5号车");
	MyThread_1 t6 = new MyThread_1("6号车");
	MyThread_1 t7 = new MyThread_1("7号车");
	MyThread_1 t8 = new MyThread_1("8号车");
	MyThread_1 t9 = new MyThread_1("9号车");
	MyThread_1 t10 = new MyThread_1("10号车");
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	t6.start();
	t7.start();
	t8.start();
	t9.start();
	t10.start();
}
}
