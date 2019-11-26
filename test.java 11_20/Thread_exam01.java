package Test11_20;

class ThreadExam implements Runnable{
	private static int apple = 1;
	public void run(){
		System.out.println(Thread.currentThread().getName()+
				"优先级为："+Thread.currentThread().getPriority());
		while(true){
			if(apple<21){
				System.out.println(Thread.currentThread().getName()+
						"...捡到了一个苹果----现在一共"+(apple++)+"个苹果");
			}
			else break;
		}
		
	}
}


public class Thread_exam01 {
public static void main(String[] args) {
	ThreadExam t = new ThreadExam();
	Thread t1 = new Thread(t);
	Thread t2 = new Thread(t);
	Thread t3 = new Thread(t);
	t1.setName("小花");
	t1.setPriority(1);
	t1.start();
	t2.setName("欣欣");
	t2.setPriority(10);
	t2.start();
	t3.setName("红红");
	t3.setPriority(5);
	t3.start();
}
}
