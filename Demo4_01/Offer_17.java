package Demo4_01;

public class Offer_17 {
	// 输入数字 n，按顺序打印出从 1 到最大的 n位十进制数
	// 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
	public static int[] printNumbers(int n) {
		// 利用10的n次方-1来求解
		int num = (int) Math.pow(10, n) - 1;
		int[] res = new int[num]; // 初始化一个数组
		for (int i = 0; i < num; i++) {
			res[i] = i + 1; // 从1开始打印
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = printNumbers(3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
