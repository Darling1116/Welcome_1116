package Demo10_18;

import java.util.Random;


public class Sort_1 {
	/*
	 * 时间复杂度：
	 * 最坏情况：O(n^2)   最好情况(有序时):O(n)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定
	 */
	void Insert_sort(int[] array){
		//直接插入排序：把第一个元素当做已排好的元素，从第二个元素开始进行插入
		int tmp = array[0];
		for(int i=1; i<array.length; i++){
			tmp = array[i]; 
			int j;
			for(j=i-1; j>=0; j--){
				if(tmp < array[j]){
					array[j+1] = array[j];
				}
				else {
					break;
				}
			}
			array[j+1] = tmp;
		}
	}
	
	
	void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	//测试排序所需时间
	public static void main(String[] args){
		Sort_1 sort_1 = new Sort_1();
		int[] array = new int[100000];
		
		//有序时
//		for(int i=0; i<array.length; i++){
//			array[i] = i;
//		}
		
		//无序时
		Random random = new Random();
		for(int i=0; i<array.length; i++){
			array[i] = random.nextInt(100000);
		}
		
		long start = System.currentTimeMillis();
		sort_1.Insert_sort(array);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
	
	
	public static void main1(String[] args){
		Sort_1 sort_1 = new Sort_1();
		int array[] = {5, 8, 9, 0, 1, 5, 4};
		sort_1.Insert_sort(array);
		sort_1.display(array);
		
		
	}
}
