package Demo10_21;

public class Sort_8 {
	void Swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/*
	 * 简单选择排序 时间复杂度：O(n^2) 空间复杂度：O(1) 稳定性：不稳定
	 */
	void Select_sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i; // 用min记录最小元素值的位置
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j; // 更新最小元素值的位置
				}
			}
			if (min != i) {
				Swap(array, i, min); // 更新第i个位置元素的值
			}
		}
	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort_8 sort_8 = new Sort_8();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		sort_8.Select_sort(array);
		sort_8.display(array);
	}
}
