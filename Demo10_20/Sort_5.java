package Demo10_20;

public class Sort_5 {
	void Swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	// 挖坑法
	int Partition1(int[] array, int left, int right) {
		int pivot = array[left]; // 取第一个元素作为坑
		while (left < right) {
			// 从尾开始找比pivot小的数，找到以后，放在坑里，该指针所在的位置作为新的坑
			while (array[right] >= pivot && left < right) {
				right--;
			}
			array[left] = array[right];
			// 从头开始找比pivot大的数，找到以后，放在坑里，该指针所在的位置作为新的坑
			while (array[left] < pivot && left < right) {
				left++;
			}
			array[right] = array[left];
		}
		// 把第一个数据放在最后一个坑里
		array[left] = pivot;
		return left;
	}

	// 前后指针法
	int Partition2(int[] array, int left, int right) {
		// 取第一个元素为pivot，让prev指向第一个数据，让cur指向第二个数据
		int pivot = array[left];
		int prev = left;
		int cur = left + 1;
		// 让cur依次遍历每一个元素
		while (cur <= right) {
			if (array[cur] <= pivot && prev++ != cur) {
				Swap(array, cur, prev);
			}
			++cur;
		}
		Swap(array, prev, left);
		return prev;

	}

	void Quick_sort(int[] array, int left, int right) {
		if (left < right) {
			int partition = Partition2(array, left, right);
			Quick_sort(array, left, partition - 1);
			Quick_sort(array, partition + 1, right);
		}
	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort_5 sort_5 = new Sort_5();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		sort_5.Quick_sort(array, 0, array.length - 1);
		sort_5.display(array);
	}
}
