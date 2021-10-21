package Demo10_21;

public class Sort_7 {
	void Swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	void Bubble_sort(int[] array, int left, int right) {
		// 奇数趟把元素值最大的放在序列的最后面
		// 偶数趟把元素值最小的放在序列的最前面
		int i = 0;
		boolean flag = true; // 用来标记一趟冒泡排序是否发生，初始为true
		while (left < right && flag == true) {
			flag = false;
			for (i = left; i < right; i++) {
				if (array[i] > array[i + 1]) { // 前一个元素的值大于后一个元素的值
					Swap(array, i, i + 1);
					flag = true; // 发生了元素交换，flag置为true
				}
			}
			right--; // 更新上界
			for (i = right; i > left; i--) {
				if (array[i] < array[i - 1]) { // 后一个元素的值小于前一个元素的值
					Swap(array, i, i - 1);
					flag = true; // 发生了元素交换，flag置为true
				}
			}
			left++; // 更新下界
		}
	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort_7 sort_7 = new Sort_7();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		sort_7.Bubble_sort(array, 0, array.length - 1);
		sort_7.display(array);
	}
}
