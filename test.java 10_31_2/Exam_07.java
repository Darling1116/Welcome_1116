package Test10_31;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Exam_07 {
public static void main(String[] args) {
	/*ArrayList<String> myweekday = new ArrayList<String>();
	myweekday.add("Sunday");
	myweekday.add("Monday");
	myweekday.add("wednesday");
	myweekday.add("Friday");
	System.out.println(myweekday);
	myweekday.add("Tuesday");
	myweekday.set(4, "Thursday");
	Iterator<String> iterator = myweekday.iterator();
	while(iterator.hasNext()){
		String day = iterator.next();
		System.out.println(day);*/
		
		LinkedList<String> link = new LinkedList<String>();
		for(int i=0;i<10;i++){
			link.add(String.valueOf(i));
		}
		Iterator<String> iterator1 = link.iterator();
		while(iterator1.hasNext()){
			System.out.print(iterator1.next());
		}
		
		System.out.println();
		link.addLast(String.valueOf(10));
		link.set(0, String.valueOf(555));
		link.removeLast();
		System.out.println(link);
	}
}
//}
