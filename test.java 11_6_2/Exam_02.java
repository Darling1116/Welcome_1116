package Test11_6;

import java.util.Hashtable;

public class Exam_02 {
public static void main(String[] args) {
	Hashtable ht = new Hashtable();
	ht.put("张飞", "267899");
	ht.put("李亚", "145678");
	ht.put("刘楠", "123456");
	System.out.println(ht);
	System.out.println(ht.get("张飞"));
	System.out.println(ht.get("花花"));
	ht.remove("张飞");
	System.out.println(ht);
	
}
}
