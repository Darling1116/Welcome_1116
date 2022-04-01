package Demo4_01;

public class Offer_12 {
	// 给定一个 m x n二维字符网格 board和一个字符串单词 word
	// 如果 word存在于网格中,返回 true;否则返回 false
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (DFS(board, word, i, j, 0))
					return true;
			}
		}
		return false;

	}

	// 深度优先搜索(DFS):先从一个方向搜索到底，再回溯至上一个节点，沿另一个方向搜索
	// +
	// 剪枝:遇到不匹配或者已经访问过的节点，立刻返回
	public static boolean DFS(char[][] board, String word, int i, int j, int k) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] != word.charAt(k))
			return false;
		if (k == word.length() - 1)
			return true;

		board[i][j] = '\0'; // 当前结点等于word[k]，把该结点标记为已读，去匹配下一个结点

		// 在上下左右四个方向上去找下一个结点，有一个符合条件，就表示找到了
		boolean res = DFS(board, word, i, j + 1, k + 1)
				|| DFS(board, word, i, j - 1, k + 1)
				|| DFS(board, word, i + 1, j, k + 1)
				|| DFS(board, word, i - 1, j, k + 1);

		board[i][j] = word.charAt(k); // 把刚刚标记的结点的值还原
		return res;
	}

	public static void main(String[] args) {
		char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
		String word = "abcd";
		System.out.println(exist(board, word));
	}
}
