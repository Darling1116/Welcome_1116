package Demo3_29;

public class Offer_10_2 {
	// 青蛙跳台阶问题：
	// 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶
	// 求该青蛙跳上一个n级的台阶总共有多少种跳法

	public static int numWays(int n) {
		// 与斐波那契数列思想一致
		if (n == 0 || n == 1)
			return 1;
		if (n == 2)
			return 2;
		int a = 1;
		int b = 2;
		for (int i = 3; i <= n; i++) {
			int sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println(numWays(7));
	}

}
