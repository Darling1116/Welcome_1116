package Demo3_30;

public class Offer_11 {
	// 旋转数组的最小数字：
	// 给一个可能存在重复元素值的数组 numbers
	// 它原来是一个升序排列的数组，进行了一次旋转(现在整体无序)
	// 请返回旋转数组的最小元素
	public static int minArray(int[] numbers) {
		// 基于二分查找的思想
		int low = 0; // 记录最小值元素的数组下标
		int hight = numbers.length - 1;
		while (low < hight) {
			int pivot = low + (hight - low) / 2;
			if (numbers[pivot] < numbers[hight])
				hight = pivot;
			else if (numbers[pivot] > numbers[hight])
				low = pivot + 1;
			else
				// numbers[pivot] == numbers[hight]
				hight = hight - 1;
		}
		return numbers[low];
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 2, 2, 0, 1 };
		System.out.println(minArray(numbers));
	}
}
