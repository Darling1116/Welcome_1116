package Demo4_01;

public class Offer_14 {
	// 剪绳子：动态规划问题
	public static int cuttingRope_1(int n) {
		// ① 当所有绳段长度相等时，乘积最大
		// ② 最优的绳段长度为3,次优为2,最差为1
		// 该绳长可以表示为3*a+b
		if (n <= 3) // 绳子总长度小于等于3时为特殊情况
			return n - 1;
		int a = n / 3;
		int b = n % 3;
		if (b == 0)
			// pow(a, b)表示a的b次方，返回类型为double
			return (int) Math.pow(3, a);
		else if (b == 1)
			return (int) Math.pow(3, a - 1) * 2 * 2;
		else
			return (int) Math.pow(3, a) * 2;
	}

	public static void main(String[] args) {
		System.out.println(cuttingRope_1(10));
	}
}
