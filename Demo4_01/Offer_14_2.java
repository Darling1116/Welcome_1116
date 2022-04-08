package Demo4_01;

public class Offer_15 {
	// 剪绳子2：利用循环求余法，防止大数越界
	public static int cuttingRope_1(int n) {
		if (n <= 3)
			return n - 1;

		int a = n / 3;
		int b = n % 3;
		int p = 1000000007;
		int ret = 1;
		for (int i = 1; i < a; i++) {
			// 对前a-1段进行循环求余，防止越界
			ret = ret * 3 % p;
		}
		if (b == 0)
			return (int) ret * 3 % p;
		else if (b == 1)
			return (int) ret * 4 % p;
		else
			return (int) ret * 2 * 3 % p;
	}

	// 剪绳子2：利用快速幂求法，防止大数越界
	public static int cuttingRope_2(int n) {
		if (n <= 3)
			return n - 1;

		int b = n % 3;
		int p = 1000000007;
		long x = 3; // 底数
		long ret = 1;
		for (int a = n / 3 - 1; a > 0; a = a / 2) {
			if (a % 2 == 1)
				ret = ret * x % p;
			x = (x * x) % p;
		}
		if (b == 0)
			return (int) ret * 3 % p;
		else if (b == 1)
			return (int) ret * 4 % p;
		else
			return (int) ret * 2 * 3 % p;

	}

	public static void main(String[] args) {
		System.out.println(cuttingRope_1(10));
		System.out.println(cuttingRope_2(10));
	}
}
