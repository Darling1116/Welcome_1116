package Demo3_29;

public class Offer_08 {
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int a = 0, b = 1;
		for (int i = 2; i <= n; i++) {
			int sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return b;

	}

	public static void main(String[] args) {
		System.out.println(fib(10));
	}
}
