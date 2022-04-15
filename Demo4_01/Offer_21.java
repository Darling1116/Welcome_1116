package Demo4_01;

public class Offer_21 {
	// 调整数组顺序使奇数位于偶数之前
	public static int[] exchange(int[] nums) {
		int begin = 0;
		int end = nums.length - 1;
		while (begin < end) {
			while (begin < end && nums[begin] % 2 != 0)
				begin++;
			while (begin < end && nums[end] % 2 == 0)
				end--;
			if (begin < end) {
				int tmp = nums[begin];
				nums[begin] = nums[end];
				nums[end] = tmp;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
