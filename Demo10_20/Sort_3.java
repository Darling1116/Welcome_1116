package Demo10_20;


public class Sort_3 {
	/*
	 * 冒泡排序时间复杂度：
	 * 最坏情况：O(n^2)   最好情况(有序时):O(n)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定
	 */
	void Swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	void Bubble_sort(int[] array){
		for(int i=0; i<array.length; i++){
			boolean flag = false; //设置一个是否发生元素的标志
			//一趟冒泡排序：从后往前，相邻两个元素进行两两比较
			//如果后面的元素小于前面的元素，就交换
			//一趟冒泡排序下来，最小的元素就会被放到最前面
			for(int j=array.length-1; j>i; j--){
				if(array[j]<array[j-1]){
					Swap(array, j, j-1);
					flag = true;
				}
			}
			if(flag==false) //该趟没有发生元素交换，表明该数组已经有序，直接返回
				return;
		}
	}
	
	void display(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		Sort_3 sort_3 = new Sort_3();
		int array1[] = {5, 8, 9, 0, 1, 5, 4};
		long start1 = System.currentTimeMillis();
		sort_3.Bubble_sort(array1);
		sort_3.display(array1);
		long end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
		
		int array2[] = {1, 2, 3, 4, 5, 6, 7};
		long start2 = System.currentTimeMillis();
		sort_3.Bubble_sort(array2);
		sort_3.display(array2);
		long end2 = System.currentTimeMillis();
		System.out.println(end2-start2);
	}
}
