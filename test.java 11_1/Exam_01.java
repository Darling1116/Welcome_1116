package Test11_1;

import java.util.*;

public class Exam_01 {
public static void main(String[] args) {
	int time = Integer.parseInt("10");//给一个特定的数
	Queue queue = new LinkedList();
	for(int i=time;i>=0;i--){
		queue.add(Integer.valueOf(i));
	}
	while(!queue.isEmpty()){
		System.out.println(queue.remove()+" ");
	
	try{
		Thread.sleep(1000);
	}
	catch(InterruptedException e){
		e.printStackTrace();
	}
	}
	
	
	
	
	
	
	
	System.out.println(queue);
}
}
