package Demo10_23;

public class Sort_10 {

	/*
	 * 归并排序 时间复杂度：O(nlogn) 空间复杂度：O(n) 稳定性：稳定
	 */

	// 归并排序：先分解再合并
	void Merge_sort(int[] array, int left, int right) {
		if (left >= right)
			return;
		// 1.分解
		int mid = (left + right) / 2; // 从中间划分成两个待排子序列
		Merge_sort(array, left, mid); // 对左侧序列进行递归排序left~mid
		Merge_sort(array, mid + 1, right); // 对右侧序列进行递归排序(mid+1)~right
		// 2.合并
		Merge(array, left, mid, right); // 把左右两边的子序列合并在一起
	}

	// 合并
	void Merge(int[] array, int left, int mid, int right) {
		// 分别用s1、s2标记两个待排子序列的起始下标位置
		int s1 = left;
		int s2 = mid + 1;

		// 用len表示array数组的长度
		int len = right - left + 1;

		// 设置一个临时数组，存放排好的序列
		int[] ret = new int[len];
		int i = 0; // i表示ret数组的下标

		// 两边子序列都有元素时
		while (s1 <= mid && s2 <= right) {
			if (array[s1] <= array[s2]) {
				// 左边序列元素的值小于右边的，就把左边元素的值放到ret中，并更新i和s1
				ret[i++] = array[s1++];
			} else {
				// 反之，就把右边元素的值放到ret中，并更新i和s2
				ret[i++] = array[s2++];
			}
		}
		// 处理剩下有元素的待排子序列
		while (s1 <= mid) {
			ret[i++] = array[s1++];
		}
		while (s2 <= right) {
			ret[i++] = array[s2++];
		}
		// 把排好的序列放回到原数组中
		for (int j = 0; j < ret.length; j++) {
			array[left + j] = ret[j]; // array数组的起始下标为left
		}
	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort_10 sort_10 = new Sort_10();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		// int mid = (0+array.length-1)/2;
		sort_10.Merge_sort(array, 0, array.length - 1);
		sort_10.display(array);
	}
}
