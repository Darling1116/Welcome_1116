package Test10_31;

import java.util.HashSet;
import java.util.TreeSet;

public class Exam_08 {
public static void main(String[] args) {
	TreeSet<String> ts = new TreeSet<String>();
	ts.add(String.valueOf(5));
	ts.add(String.valueOf(6));
	ts.add(String.valueOf(3));
	ts.add(String.valueOf(4));
	ts.add(String.valueOf(5));
	ts.add(String.valueOf(6));
	ts.remove(String.valueOf(1));
	System.out.println(ts);
	
	
	HashSet<String> hs = new HashSet<String>();
	hs.add(String.valueOf(1));
	hs.add(String.valueOf(1));
	hs.add(String.valueOf(3));
	hs.add(String.valueOf(5));
	hs.add(String.valueOf(6));
	System.out.println(hs);
	hs.remove(String.valueOf(1));
	System.out.println(hs);
	hs.add(null);
	System.out.println(hs);
}
}
