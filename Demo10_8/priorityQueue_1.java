package Demo10_8;

import java.util.PriorityQueue;
import java.util.Random;

public class priorityQueue_1 {
	public static void main(String[] args){
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[] array = new int[20];
		//使用Random（）函数
		Random random = new Random(1);
		for(int i=0; i<20; i++){
			//用nextInt()随机生成int型
			array[i] = random.nextInt(100);
			pq.offer(array[i]);
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("取前10位：");
		for(int i=0; i<10; i++){
			System.out.print(pq.poll()+" ");
		}
		
		
	}
}
