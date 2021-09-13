package Test9_13;

class Cellphone{
	String brand;
	double price;
	
	public Cellphone(String brand, double price){
		this.brand = brand;
		this.price = price;
	}
	
	public boolean equals(Object obj){
		//instanceof 严格来说是Java中的一个双目运算符
		//用来测试一个对象是否为一个类的实例
		//其中 obj 为一个对象，Class 表示一个类或者一个接口
		//当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，
		//结果result都返回 true，否则返回false。
		if(obj instanceof Cellphone){
			Cellphone other = (Cellphone)obj;
			return other.brand.equals(brand) && other.price == price;
		}
		return false;
	}
	
	
	public int hashCode(){
		//根据哈希算法算出来的一个值，这个值跟地址值有关，但不是实际地址值
		return brand.hashCode()+ (int)price;
	}
	
	public String toString(){
		return "Cellphone(brand=" + brand +", price=" + price+")";
	}
	
	public static void main(String[] args){
		Cellphone c1 = new Cellphone("小米", 3600.00);
		Cellphone c2 = new Cellphone("华为", 3600.00);
//		boolean res = c1.equals(c2);
//		System.out.println(res);
		
//		int h1 = c1.hashCode();
//		int h2 = c2.hashCode();
//		System.out.println(h1);
//		System.out.println(h2);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
	}
}
