package Test11_18;

 class ThreadExample implements Runnable{
	private static int apple=1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//两个线程共享资源（对象、变量）
		//继承里要写构造函数，接口实现中不需要
		while(true){
			if(apple<11){
				System.out.println(Thread.currentThread().getName()+"...检到一个苹果---"+
						"现在一共有"+(apple++)+"个苹果");
			}
			else break;
		}
	}
	
}

public class Thread_exam02 {
public static void main(String[] args) {
	ThreadExample t = new ThreadExample();
	Thread t1 = new Thread(t);
	Thread t2 = new Thread(t);
	t1.setName("小花");
	t2.setName("哈哈");
	t1.start();
	t2.start();
}
}
