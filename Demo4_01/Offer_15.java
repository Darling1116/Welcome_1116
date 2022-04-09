package Demo4_01;

public class Offer_15 {
	// 求一个无符号整型二进制中1的个数
	public static int hammingWeight_1(int n) {
		// 1.利用二进制的每一位与1按位与
		int ret = 0;
		for (int i = 0; i < 32; i++) { // 整型为32位
			if ((n & (1 << i)) != 0) // 第i位的数字为1
				ret++;
		}
		return ret;
	}

	public static int hammingWeight_2(int n) {
		// 2.利用n&(n−1):把n的二进制位中的最低位的1变为0之后的结果
		int ret = 0;
		while (n != 0) { // 有1存在
			n = n & (n - 1);
			ret++;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(hammingWeight_1(11));
		System.out.println(hammingWeight_2(11));
	}
}
