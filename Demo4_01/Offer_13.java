package Demo4_01;

public class Offer_13 {
	public static int movingCount_1(int m, int n, int k) {
		// 有局限性
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (getSum(i) + getSum(j) <= k) {
					++count;
				}
			}
		}
		return count;
	}

	// 求一个数的各个位数的数字之和
	public static int getSum(int val) {
		int sum = 0;
		while (val != 0) {
			sum += val % 10;
			val = val / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// System.out.println(getSum(26));
		System.out.println(movingCount_1(3, 2, 1));
	}
}
