package Demo10_19;

import java.util.Random;

import Demo10_18.Sort_1;

public class Sort_2 {
	/*
	 * 时间复杂度：
	 * 最坏情况：O(n^2)   最好情况(有序时):O(n)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定
	 */
	void Binary_sort(int[] array){
		//折半插入排序：先比较再移动
		//先利用折半查找的方式找到待插入元素的位置，再进行直接插入
		int i, j;
		for(i=1; i<array.length; i++){
			int left = 0;
			int right = i;
			int tmp = array[i];
			//先在当前范围内查找待插入元素的位置
			while(left < right){
				int mid = (left+right)/2;
				//左闭右开
				if(tmp < array[mid]){
					right = mid-1;
				}
				else{
					left = mid+1;
				}
			}
			//搬移：移动待插入位置之后的元素
			for(j=i; j>right; j--){
				array[j] = array[j-1];
			}
			//插入
			array[right] = tmp;
		}
	}
	
	/*
	 * 时间复杂度：
	 * 最坏情况：O(n^1.3)   最好情况(有序时):O(n)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定
	 */
	void Shell(int[] array, int gap){
		//从第一个间隔gap的元素开始
		for(int i=gap; i<array.length; i++){
			int tmp = array[i];
			//对gap位置的元素进行直接插入排序
			int j;
			for(j=i-gap; j>=0; j-=gap){
				if(tmp < array[j]){
					array[j+gap] = array[j];
				}
				else{
					break;
				}
			}
			//因为在循环中，j-=gap后判断条件不合适才停止因此待插入元素的下标为j+gap
			array[j+gap] = tmp;
		}
	}
	
	void Shell_sort(int[] array){
		//希尔排序：对直接插入排序的优化。先分组，组内进行直接插入排序；基本有序时再整体排序
		//随着增量的增大，排序速度越来越快
		int[] gap = {5,3,1};
		for(int i=0; i<gap.length; i++){
			Shell(array, gap[i]);
		}
	}

	void display(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
	
	
	public static void main1(String[] args){
		Sort_2 sort_2 = new Sort_2();
		int[] array = new int[100000];
		
		//有序时
		for(int i=0; i<array.length; i++){
			array[i] = i;
		}
		
		//无序时
//		Random random = new Random();
//		for(int i=0; i<array.length; i++){
//			array[i] = random.nextInt(100000);
//		}
//		
		long start = System.currentTimeMillis();
		sort_2.Binary_sort(array);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
	
	
	public static void main(String[] args){
		Sort_2 sort_2 = new Sort_2();
		int array[] = {5, 8, 9, 0, 1, 5, 4};
		sort_2.Binary_sort(array);
		//sort_2.Shell_sort(array);
		sort_2.display(array);
	}
}
