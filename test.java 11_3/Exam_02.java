package Test11_3;

import java.util.*;

public class Exam_02 {
public static void main(String[] args) {
	String str = "no pains,no gains,well begun is half done," +
			"where there is a will,there is a way.";
	String[] words=null;
	TreeMap<String,Integer> m=new TreeMap<String,Integer>();
	words = str.split("[,. ]");
	
	for(int i=0;i<words.length;i++){
		Integer freg = m.get(words[i]);
		if(freg==null){
			m.put(words[i], 1);
		}
		else
			m.put(words[i], freg+1);
	}
	System.out.println(m.size());
	System.out.println(m);
	
}
}
