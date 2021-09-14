package Demo9_14;

class Animals{
	String name;
	int age;
	//private int age;
	
	public Animals(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		System.out.println("Animals");
	}
	
	void eat(){
		System.out.println("Animals:eat()");
	}
	
}

class Cat extends Animals{
	String color;
	final String sex = "女";
	
	public Cat(String name) {
		// TODO Auto-generated constructor stub
		super(name);//显示调用
		System.out.println("Cat");
	}
	
	void eat(){
		System.out.println("Cat:eat()");
	}
}


class Bird extends Animals{
	String color;
	
	public Bird(String name) {
		// TODO Auto-generated constructor stub
		super(name);//显示调用
		System.out.println("Bird");
	}
	
	void fly(){
		System.out.println("Bird:fly()");
	}
}


public class demo_1 {

	public static void main(String[] args){
		Cat cat = new Cat("xixi");
		cat.eat();
		Animals animals = new Animals("xixi");
		animals.eat();
	}
	
	public static void main3(String[] args){
		Animals animals = new Cat("仔仔");
		if(animals instanceof Bird){
			Bird bird = (Bird)animals;
			bird.fly();
		}
		else{
			System.out.println("false!!!");
		}
	}
	
	
	public static Animals func2() {
		Cat cat = new Cat("豆豆");
		return cat;
	}

	public static void main2(String[] args){
		Animals animals = func2();
		animals.eat();
	}
	
		
		
	public static void func1(Animals animal){
			animal.eat();
	}
		
	public static void main1(String[] args){
		Cat cat = new Cat("豆豆");
		func1(cat);
	}
	
	
	public static void main0(String[] args){
//		Cat cat = new Cat("咪咪");
//		//cat.name = "咪咪";
//		cat.age = 2;
//		//cat.sex = "女";
//		System.out.println("cat.name:"+cat.name+" ,cat.age:"+cat.age);
		
		//Animals animal = new cat("球球");

		Animals animal = new Cat(" ");
		//animal.color = "gray"; // 不能被调用
		animal.name = "球球";
		animal.age = 1;
		animal.eat();
		System.out.println("cat.name:"+animal.name+" ,cat.age:"+animal.age);
	}
}


