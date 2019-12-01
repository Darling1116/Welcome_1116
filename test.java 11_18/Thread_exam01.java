package Test11_18;

class NewThread extends Thread{
	public NewThread(String s) {
		setName(s);
		// TODO Auto-generated constructor stub
	}
	public void run(){
		for(int i=0;i<=5;i++){
			System.out.println("第"+i+"次调用"+getName());
		}
	}
}

public class Thread_exam01 {
public static void main(String[] args) {
	NewThread t1 = new NewThread("线程1");
	NewThread t2 = new NewThread("线程2");
	NewThread t3 = new NewThread("线程3");
	t1.start();
	t2.start();
	t3.start();
}
}
