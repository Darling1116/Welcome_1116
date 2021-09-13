package Test9_13;

public class Singleton {
	//构造函数为私有的
	private Singleton(){
		
	}
	
	//为了使我们能够实例化一个对象，
	//需要在类中定义一个静态的方法去获取它的构造函数
	private static Singleton instance = new Singleton();
	

	public static Singleton getInstance(){
		return instance;
	}
	
    public void singletonTest(){       
    	System.out.println("singletonTest is called.");
    }
	
	public static void main(String[] args){
		//Singleton s = new Singleton();
		Singleton s;
		s = Singleton.getInstance();
		s.singletonTest();
		//System.out.println(s.getInstance());
		
	}
	
	
	
}




