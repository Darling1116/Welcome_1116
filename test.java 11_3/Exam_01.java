package Test11_3;

import java.util.HashMap;

public class Exam_01 {
public static void main(String[] args) {
	String[] country = {"China","India","Australia","Germany","Cuba",
			"Greece","Japan"};
	String[] captial = {"Beijing","New Delhi","Canberra","Berlin",
			"Havana","Athens","Tokyo"};
	HashMap m = new HashMap();
	for (int i=0;i<country.length;i++){
		m.put(country[i], captial[i]);
	}
	System.out.println("m.size()="+m.size());
	System.out.println(m);
	System.out.println(m.get("China"));
	m.remove("Japan");
	//System.out.println(m.get("Japan"));
	for (int i=0;i<m.size();i++){
		System.out.print(m.get((country)[i])+",");
	}
}
}
