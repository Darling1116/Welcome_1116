package Demo10_22;

public class Sort_9 {

	// 创建大根堆：从最后一个非叶子结点开始，做向下调整
	void Create_heap(int[] array) {
		for (int i = ((array.length - 1) - 1) / 2; i >= 0; i--) {
			AdjustDown(array, i, array.length);
		}
	}

	// 向下调整算法：从某一根节点开始，把较大值的元素换到父结点
	void AdjustDown(int[] array, int root, int len) {
		int parent = root;
		int child = 2 * parent + 1; // 左孩子的下标为2*parent+1
		// 保证有左孩子
		while (child < len) {
			// 在有右孩子的情况下，如果右孩子的值大于左孩子的值，就把child++
			if (child + 1 < len && array[child] < array[child + 1]) {
				child++;
			}
			// 如果当前孩子的值大于父结点的值，就交换
			if (array[parent] < array[child]) {
				int tmp = array[parent];
				array[parent] = array[child];
				array[child] = tmp;
				// 更新父节点和孩子结点的下标
				parent = child;
				child = 2 * parent + 1;
			} else {
				break;
			}

		}
	}

	/*
	 * 堆排序 时间复杂度：O(nlogn) 空间复杂度：O(1) 稳定性：不稳定
	 */
	// 堆排序：先创建大根堆
	// 然后让最后一个数与第一个数交换，此时最后一个数为最大值元素，然后进行向下调整
	// 再重复上述步骤，直到只剩下一个元素
	void Heap_sort(int[] array) {
		Create_heap(array);
		int end = array.length - 1; // 最后一个待排序列元素的下标
		while (end > 0) {
			// 交换首尾两个元素
			int tmp = array[end];
			array[end] = array[0];
			array[0] = tmp;
			AdjustDown(array, 0, end--);
		}

	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort_9 sort_9 = new Sort_9();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		sort_9.Heap_sort(array);
		sort_9.display(array);
	}
}
