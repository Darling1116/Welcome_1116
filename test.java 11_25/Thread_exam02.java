package Test11_25;

class MyThread_2 extends Thread{
	MyThread_2(String name,int prority){
		super(name);
		setPriority(prority);
	}
	public void run()  {
		if(getName().equals("线程1")){
			for(int i=0;i<50;i++){
				System.out.println("线程1正在运行");
			}
		}
		else if(getName().equals("线程2")){
			for(int i=0;i<100;i++){
				System.out.println("线程2正在运行");
			}
		}
		}
}

public class Thread_exam02 {
public static void main(String[] args) {
	MyThread_2 t1 = new MyThread_2("线程1", 10);
	MyThread_2 t2 = new MyThread_2("线程2", 5);
	t1.start();
	t2.start();
}
}
