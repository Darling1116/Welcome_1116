package Demo11_6;

import java.util.Stack;

public class Test_2 {
	public static void main(String[] args) {
		int[] array = { 2, 3, 4, 5, 3, 2 };
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < array.length; i++) {
			st.push(array[i]);
		}
		int j = 0;
		while (j < array.length) {
			if (array[j] != st.pop()) {
				// System.out.print("false");
				break;
			}
			j++;
		}
		System.out.print("true");
	}

}
