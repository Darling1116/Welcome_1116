package Test11_5;

import java.util.ArrayList;
import java.util.Iterator;

class Cat {
	String name;
	Cat(String m){
		this.name = m;
	}
	void show(){
		System.out.println(name);
	}
}


public class CatTest{
	public static void main(String[] args) {
		Cat ca1 = new Cat("小花");
	//	ca1.show();
		Cat ca2 = new Cat("天天");
	//	ca2.show();		
		Cat ca3 = new Cat("乐乐");
	//	ca3.show();		
		ArrayList al = new ArrayList();
		al.add(ca1);
		al.add(ca2);
		al.add(ca3);
		for(int i=0;i<al.size();i++){
			Cat c = (Cat)al.get(i);
			c.show();
		}
	}
}

