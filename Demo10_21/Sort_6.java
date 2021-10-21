package Demo10_21;

import java.util.Stack;

public class Sort_6 {

	void Swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	// 快排的非递归实现：利用栈
	// 在一次划分的基础上，把被划分两边的左、右元素分别入栈
	// 如果基准值两边的左、右两部分的元素只有一个，则不需要入栈
	// 非空时，栈顶的两个元素出栈(先出的为right)，作为下一次待排序的区间，然后找基准值
	void Quick_sort(int[] array, int left, int right) {
		Stack<Integer> stack = new Stack<Integer>();

		int partition = Partition(array, left, right);
		// 基准值两边的左、右两部分的元素不是只有一个
		if (left + 1 < partition) {
			// 被划分左边序列的最左、最右元素下标依次入栈
			stack.push(left);
			stack.push(partition - 1);
		}
		if (partition + 1 > right) {
			// 被划分右边序列的最左、最右元素下标依次入栈
			stack.push(partition + 1);
			stack.push(right);
		}

		while (!stack.isEmpty()) {
			// 非空时，栈顶的两个元素出栈(依次为right、left)
			right = stack.pop();
			left = stack.pop();
			// 新的left、right值作为下一次待排序的区间，然后找基准值，重复上述步骤，直到栈为空
			partition = Partition(array, left, right);
			if (left + 1 < partition) {
				// 被划分左边序列的最左、最右元素下标依次入栈
				stack.push(left);
				stack.push(partition - 1);
			}
			if (partition + 1 > right) {
				// 被划分右边序列的最左、最右元素下标依次入栈
				stack.push(partition + 1);
				stack.push(right);
			}
		}

		// 77递归实现
		// if (left < right) {
		// int partition = Partition(array, left, right);
		// Quick_sort(array, left, partition - 1);
		// Quick_sort(array, partition + 1, right);
		// }
	}

	int Partition(int[] array, int left, int right) {
		int pivot = array[left];
		while (left < right) {
			while (left < right && array[right] >= pivot) {
				right--;
			}
			Swap(array, left, right);
			while (left < right && array[left] < pivot) {
				left++;
			}
			Swap(array, left, right);
		}
		array[left] = pivot;
		return left;
	}

	void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort_6 sort_6 = new Sort_6();
		int[] array = { 4, 7, 0, 2, 5, 1, 7 };
		sort_6.Quick_sort(array, 0, array.length - 1);
		sort_6.display(array);
	}
}
