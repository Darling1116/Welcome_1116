package Demo12_16;

import java.util.HashSet;
import java.util.Set;

public class Offer_03 {
	// 找出数组中重复的数字

	public static int findRepeatNumber1(int[] nums) {
		// 1.利用计数器
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
			if (arr[nums[i]] > 1)
				return nums[i];
		}
		return -1;
	}

	public static int findRepeatNumber2(int[] nums) {
		// 2.利用HashSet<Object>:相同元素只允许存放一个
		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			// contains()判断set中是否有该元素
			if (hs.contains(nums[i]))
				return nums[i];
			else
				hs.add(nums[i]);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 0, 2, 5, 3 };
		int res1 = findRepeatNumber1(arr);
		System.out.println(res1);
		int res2 = findRepeatNumber2(arr);
		System.out.println(res2);
	}

}
