package Test11_6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class student{
	int id;
	String name;
	student(int id,String name){
		this.id=id;
		this.name=name;
	}
   /* public int hashCode()
    { return id*name.hashCode();
    }
            
    public boolean equals(Object o)
    {       Student s=(Student)o;
            return id==s.id && name.equals(s.name);
    }*/
   public String toString()
    {      return id+":"+name;
    }
	
}

public class TestHashMap {
	public static void printElement(Collection c,HashMap hm){
		Iterator it = c.iterator();
		while(it.hasNext()){
			Object key1=it.next();
			System.out.println(key1+"="+hm.get(key1));
		}
	}
public static void main(String[] args) {
	HashMap hm = new HashMap();
	student s1 = new student(1,"zhang3");
	student s2 = new student(2,"li4");
	student s3 = new student(3,"wang5");
	student s4 = new student(4,"zhang3");
	
	hm.put(s1, "123");
	hm.put(s2, "456");
	hm.put(s3, "789");
	hm.put(s4, "321");
	Set keys=hm.keySet();
	System.out.println("Key:");
	printElement(keys,hm);
	
}
}
