package Test11_25;

//产品类
class Product{
	private int productId = 0;
	public Product(int productId){
		this.productId = productId;
	}
	public int getId(){
		return productId;
	}
	public void setId(int productId){
		this.productId = productId;
	}
	public String toString(){
		return "产品编号："+productId;
	}
}

//仓库类
class Store{
	private int index = 0;
	private Product[] products = new Product[8];
	
	public synchronized void push(Product product){
		//仓库已满
		try{
			while(index==products.length){
				System.out.println("仓库已满，正在等待消费...");
				this.wait();
			}
			
			this.notify();
		}
		catch(InterruptedException e){
			System.out.println("stop push product.");
		}
		
		//仓库未满
		products[index] = product;
		index++;
		System.out.println("生产了："+product+" 现在共"+index+"件商品");
	}
	
	
	public synchronized Product pop(){
		try{
			while(index==0){
				System.out.println("仓库是空的，不能消费...");
				this.wait();
			}
			this.notify();
		}
		catch(InterruptedException e){
			System.out.println("stop pop product.");
		}
		
		index--;
		System.out.println("消费了：---"+products[index]+"现在还剩"+index+"件商品");
		return products[index];
	}
}

class Maker implements Runnable{
	private String makerName;
	private Store store;
	Maker(String makerName,Store store){
		this.makerName = makerName;
		this.store = store;
	}
	public void setName(String makerName){
		this.makerName = makerName;
	}
	public String getName(){
		return makerName;
	}
	private void func(){
		for(int i=0;i<20;i++){
			Product pro = new Product(i);
			store.push(pro);
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
	public void run() {
		func();
	}
}


//消费者类
class Buyer implements Runnable{
	private String buyerName = null;
	private Store store = null;
	public Buyer(String buyerName,Store store){
		this.buyerName = buyerName;
		this.store = store;
	}
	public void setName(String buyerName){
		this.buyerName = buyerName;
	}
	public String getName(){
		return buyerName;
	}
    public void func(){
    	for(int i=0;i<20;i++){
    		Product pro = store.pop();
    		try{
    			Thread.sleep(3000);
    		}
    		catch(InterruptedException e){
    			return;
    		}
    	}
    }
	
	public void run() {
		func();
	}
}

public class Producer_consumer_Thread {
public static void main(String[] args) {
	Store store = new Store();
	Maker m = new Maker("生产者", store);
	Buyer b = new Buyer("消费者", store);
	Thread t1 = new Thread(m);
	Thread t2 = new Thread(b);
	t1.start();
	t2.start();
}
}
