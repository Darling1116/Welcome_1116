package Demo10_20;

import java.util.Random;

public class Sort_4 {
	void Swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/*
	 * 快速排序时间复杂度： 最坏情况：O(n^2) 最好情况(有序时):O(nlogn) 空间复杂度： 最坏情况：O(n)
	 * 最好情况(有序时):O(nlogn) 稳定性：不稳定
	 */

	// 基于分治的思想
	int Partition_1(int[] array, int left, int right) {
		int pivot = array[left];
		while (left < right) {
			while (left < right && array[right] >= pivot) {
				right--;
			}
			// 找到了比pivot小的数，交换，放到前面
			Swap(array, right, left);
			while (left < right && array[left] < pivot) {
				left++;
			}
			// 找到了比pivot大的数，交换，放到后面
			Swap(array, left, right);
		}
		// 找到了pivot的最终位置
		array[left] = pivot;
		return left;
	}

	void Quick_sort1(int[] array, int left, int right) {
		if (left >= right)
			return;
		// 先在待排序列中任取一个元素作为pivot基准值
		// 通过一趟排序把待排序列分成两个部分:
		// 前一部分元素都小于基准值，后一部分元素都大于基准值
		// 此时，pivot就被放到了最终位置上
		// 然后分别对两个字表重复上述步骤，直到每一个部分只有一个元素或者为空
		if (left < right) {
			int partition = Partition_1(array, left, right);
			// 依次对左右两个字表进行递归排序
			Quick_sort1(array, left, partition - 1);
			Quick_sort1(array, partition + 1, right);
		}

	}

	void Insert_sort(int[] array, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int tmp = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (tmp < array[j]) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = tmp;
		}
	}

	void Quick_sort2(int[] array, int left, int right) {
		if (left >= right)
			return;

		// 快排的优化:在right-left+1<=100范围里，使用直接插入排序
		if (right - left + 1 <= 100) {
			Insert_sort(array, left, right);
		}

		if (left < right) {
			int partition = Partition_1(array, left, right);
			Quick_sort2(array, left, partition - 1);
			Quick_sort2(array, partition + 1, right);
		}
	}

	// 利用三数取中法，找基准值：把中间的元素换到最左边(相当于传统划分方法中的第一个位置充当基准值的元素)
	// mid下标的为中间元素，使其放到第一个位置，作为基准值
	// 就要实现array[mid]<=array[left]<=array[right]
	void three_num_mid(int[] array, int left, int right) {
		int mid = (left + right) / 2;
		if (array[mid] > array[left]) {
			Swap(array, mid, left);
		}
		if (array[mid] > array[right]) {
			Swap(array, mid, right);
		}
		if (array[left] > array[right]) {
			Swap(array, left, right);
		}
	}

	void Quick_sort3(int[] array, int left, int right) {
		if (left >= right)
			return;
		if (right - left + 1 <= 100) {
			Insert_sort(array, left, right);
		}
		three_num_mid(array, left, right);
		int partition = Partition_1(array, left, right);
		Quick_sort3(array, left, partition - 1);
		Quick_sort3(array, partition + 1, right);
	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main1(String[] args) {
		Sort_4 sort_4 = new Sort_4();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		sort_4.Insert_sort(array, 0, array.length - 1);
		sort_4.display(array);
	}

	public static void main(String[] args) {
		Sort_4 sort_4 = new Sort_4();
		int[] array = new int[100000];

		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100000);
		}

		System.out.print("优化前：");
		long start = System.currentTimeMillis();
		sort_4.Quick_sort1(array, 0, array.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		int[] array2 = new int[100000];
		Random random2 = new Random();
		for (int i = 0; i < array2.length; i++) {
			array2[i] = random2.nextInt(100000);
		}
		System.out.print("直接插入法方式优化后：");
		long start2 = System.currentTimeMillis();
		sort_4.Quick_sort1(array2, 0, array2.length - 1);
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);

		int[] array3 = new int[100000];
		Random random3 = new Random();
		for (int i = 0; i < array3.length; i++) {
			array3[i] = random3.nextInt(100000);
		}
		System.out.print("三数取中法方式优化后：");
		long start3 = System.currentTimeMillis();
		sort_4.Quick_sort1(array3, 0, array3.length - 1);
		long end3 = System.currentTimeMillis();
		System.out.println(end3 - start3);

	}
}
