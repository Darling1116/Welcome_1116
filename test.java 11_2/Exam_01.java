package Test11_2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exam_01 {
public static void main(String[] args) {
	int[] ai = {1,5,3,7,6,9,8};
	PriorityQueue pq = new PriorityQueue();
	for(int i=0;i<ai.length;i++){
		pq.offer(Integer.valueOf(ai[i]));
	}
	for(int x:ai){
		System.out.print(pq.poll()+" ");
	}
	
	
	PQSort pqs = new PQSort();
	PriorityQueue pq1 = new PriorityQueue(10,pqs);
	for(int x:ai){
		pq1.offer(x);
	}
	System.out.println("size="+pq1.size());
	System.out.println("peek="+pq1.peek());
	System.out.println("poll="+pq1.poll());
	System.out.println("size="+pq1.size());
	for(int i=0;i<ai.length;i++){
		System.out.print(pq1.poll()+" ");
	}
}

static class PQSort implements Comparator<Integer>{
	public int compare(Integer one,Integer two){
		return two-one;
	}
}
}
