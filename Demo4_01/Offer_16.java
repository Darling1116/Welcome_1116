package Demo4_01;

public class Offer_16 {
	// 求数值的整数次方：x、n可以为负数
	public static double myPow(double x, int n) {
		// 快速幂解析法:将十进制的n转换为二进制形式
		// 从右向左，每一位都多乘一个x
		if (x == 0) // 0的n次方还为0
			return 0;
		if (x == 1)
			return 1;
		double res = 1.0;
		if (n < 0) {
			n = -n;
			x = 1 / x; // n为负数时，x的n次方就是1/x的正数n次方
		}
		while (n > 0) {
			if ((n & 1) == 1)
				res = res * x;
			x = x * x;
			n = n >> 1;
		}
		return res;

	}

	public static void main(String[] args) {
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2.0, -2));
	}

}
