package Test11_5;
import java.awt.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Vector;

public class Exam_05 {
	public static void main(String[] args) {
		
	
	String[] s1 = {"one","two","three","four","five"};
	Vector vc1 = new Vector(Arrays.asList(s1));
	System.out.println(vc1);
	vc1.add(String.valueOf("six"));
	vc1.add("seven");
	System.out.println(vc1);
	
	System.out.println(vc1.get(1));
	
	vc1.set(0, "hello");
	System.out.println(vc1);
	
	vc1.remove(0);
	System.out.println(vc1);
	
	Vector teamList = new Vector();
	teamList.add("Zhang Wei");
	teamList.add("Li Hong");
	teamList.add("Yu Hongshu");
	System.out.println(teamList);
	Vector yourList = new Vector();
	yourList.add("Yu Hongshu");
	yourList.add("He Li"); 
	yourList.add("Zhang Wei"); 
	System.out.println(yourList);
//	teamList.removeAll(yourList);
	System.out.println(teamList);
	System.out.println(teamList.containsAll(yourList));

	
	}
}
