package Test11_22;


class ShareData{
	public static String data="";
}

class ThreadShare extends Thread{
	private ShareData share;
	public ThreadShare(String name,ShareData share) {
		super(name);
		this.share = share;
	}
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			if(this.getName().equals("Thread1")){
			share.data="这是第一个线程";
			try{
				Thread.sleep((int)Math.random()*100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(this.getName()+": "+share.data);
			}
			
			else  if(this.getName().equals("Thread2")){
				share.data="这是第二个线程";
			}
			try{
				Thread.sleep((int)Math.random()*100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(this.getName()+": "+share.data);
		}
	}
	
}
public class Thread_exam01 {
public static void main(String[] args) {
	ShareData share = new ShareData();
	ThreadShare th1 = new ThreadShare("Thread1", share);
	ThreadShare th2 = new ThreadShare("Thread2", share);
	th1.start();
	th2.start();
	
}
}
