package Demo12_18;

//在一个 n*m的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
//输入这样的一个二维数组和一个整数，判断数组中是否含有该整数

public class Offer_04 {
	public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
		// 1.暴力解法
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
		// 2.根据该矩阵元素的规律：每行递增，每列递增
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;

		// 从第一行的最后一个数字开始找
		// 如果比当前数字小，就列数-1；如果比当前数字大，就行数+1
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (target == matrix[i][j])
				return true;
			else if (target < matrix[i][j])
				j--;
			else
				i++;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
				{ 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(findNumberIn2DArray1(arr, 13));
		System.out.println(findNumberIn2DArray2(arr, 13));
	}

}
