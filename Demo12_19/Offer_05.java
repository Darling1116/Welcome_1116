package Demo12_19;

public class Offer_05 {
	// 替换空格：把字符串 s 中的每个空格替换成"%20"

	public static String replaceSpace1(String s) {
		// 1.使用数组实现，先求出空格数，然后更新替换后所需要的数组空间大小
		int conut = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				conut++;
		}

		char[] arr = new char[conut * 3 + s.length() - conut];
		int index = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == ' ') {
				arr[index++] = '%';
				arr[index++] = '2';
				arr[index++] = '0';
			} else {
				arr[index++] = s.charAt(j);
			}
		}

		String res = new String(arr);
		return res;
	}

	public static String replaceSpace2(String s) {
		// 2.使用String类中的方法
		return s.replaceAll(" ", "%20");
	}

	public static void main(String[] args) {
		String s = "We are happy.";
		System.out.println(s);
		System.out.println(replaceSpace1(s));
		System.out.println(replaceSpace2(s));
	}
}
