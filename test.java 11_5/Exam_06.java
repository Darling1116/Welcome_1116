package Test11_5;

import java.util.Vector;

public class Exam_06 {
public static void main(String[] args) {
	Vector rateVector = new Vector(); 
	double[] rates = {36.25, 25.4, 18.34, 35.7,23.78}; 
	for (int i=0; i<rates.length; i++){
		rateVector.add(Double.valueOf(rates[i]));
	}
	System.out.println(rateVector);	
	
	double sum = 0.0; 
	for (int i=0; i<rateVector.size();i++){
		sum += ((Double)rateVector.get(i)).doubleValue();
	}
    System.out.println(sum);
}
}
