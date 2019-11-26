package Test11_21;

class Mythread extends Thread{
	public Mythread(String name,int priority) {
		super(name);
		this.setPriority(priority);
	}
	@Override
	public void run() {
		for(int i=0;i<6;i++){
			System.out.println(this.getName()+"线程第"+i+"次执行！");
			if(i%3==0){
				Thread.yield();
			}
		}
	}
}
public class Thread_exam03 {
public static void main(String[] args) {
	Mythread t1 = new Mythread("低级", 1);
	Mythread t2 = new Mythread("中级", 5);
	Mythread t3 = new Mythread("高级", 10);
	t1.start();
	t2.start();
	t3.start();
}
}
