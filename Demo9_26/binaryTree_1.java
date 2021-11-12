package Demo9_26;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
	char val;
	TreeNode left;
	TreeNode right;

	public TreeNode(char val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class Tree {
	// public TreeNode root;

	public TreeNode bulidTree() {
		// 手动建立固定的二叉树
		TreeNode A = new TreeNode('A');
		TreeNode B = new TreeNode('B');
		TreeNode C = new TreeNode('C');
		TreeNode D = new TreeNode('D');
		TreeNode E = new TreeNode('E');
		TreeNode F = new TreeNode('F');
		TreeNode G = new TreeNode('G');
		TreeNode H = new TreeNode('H');
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		E.right = H;
		C.left = F;
		C.right = G;
		return A; // 返回根节点
	}

	// 前序遍历
	public void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	// 中序遍历
	public void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.val);
		inorderTraversal(root.right);
	}

	// 后序遍历
	public void postorderTraversal(TreeNode root) {
		if (root == null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.val);
	}

	// 层序遍历:利用队列
	public void levelOrder(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.peek();
			System.out.print(cur.val);
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
			queue.poll();
		}
	}

	// 求结点的个数
	int getSize1(TreeNode root) {
		// 1.利用层次遍历
		int size = 0;
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.peek();
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
			queue.poll();
			size++;
		}
		return size;
	}

	int getSize2(TreeNode root) {
		// 2.利用子问题求解
		if (root == null)
			return 0;
		return getSize2(root.left) + getSize2(root.right) + 1;
	}

	// 叶子结点个数
	int getLeafSize1(TreeNode root) {
		// 1.利用层次遍历
		int size = 0;
		if (root == null)
			return 0;
		// if(root.left==null && root.right==null)
		// return 1;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.peek();
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
			if (cur.left == null && cur.right == null)
				size++;
			queue.poll();
		}
		return size;
	}

	int getLeafSize2(TreeNode root) {
		// 2.利用子问题求解
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return getLeafSize2(root.left) + getLeafSize2(root.right);
	}

	// 求第k层结点的个数(利用子问题求解)
	int getLevelSize(TreeNode root, int k) {
		if (root == null || k <= 0)
			return 0;
		if (root != null && k == 1)
			return 1;
		return getLevelSize(root.left, k - 1) + getLevelSize(root.right, k - 1);
	}

	// 获取二叉树的高度
	int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		// if(root.left == null && root.right == null)
		// return 1;
		return getHeight(root.left) > getHeight(root.right) ? getHeight(root.left) + 1
				: getHeight(root.right) + 1;

	}

	// 找二叉树中某一结点
	void find(TreeNode root, char val) {
		if (root == null) {
			System.out.print("没有找到");
			// return null;
		}
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
			if (cur.val == val) {
				// return cur;
				System.out.print(cur.val);
				return;
			}
		}
		System.out.print("没有找到");
		// return null;
	}

	// 递归找树中最大值结点结点
	int FindMaxval(TreeNode root) {
		// 只有根节点
		if (root.left == null && root.right == null)
			return root.val;
		// 左子树不为空：比较左子树和根节点
		if (root.left != null && root.right == null)
			return Math.max(root.val, FindMaxval(root.left));
		// 右子树不为空：比较右子树和根节点
		if (root.left == null && root.right != null)
			return Math.max(root.val, FindMaxval(root.right));
		// 左右子树都不为空：三者一起比较
		return Math.max(Math.max(root.val, FindMaxval(root.left)),
				FindMaxval(root.right));
	}

}

public class binaryTree_1 {
	public static void main(String[] args) {
		Tree binaryTree = new Tree();
		TreeNode root = binaryTree.bulidTree();

		System.out.println("-----先序遍历-----");
		binaryTree.preorderTraversal(root);
		System.out.println();
		System.out.println("-----中序遍历-----");
		binaryTree.inorderTraversal(root);
		System.out.println();
		System.out.println("-----后序遍历-----");
		binaryTree.postorderTraversal(root);
		System.out.println();

		System.out.println("-----层序遍历-----");
		binaryTree.levelOrder(root);
		System.out.println();
		// int size1 = binaryTree.getSize1(root);
		// System.out.println("结点个数为：" + size1);
		// int size2 = binaryTree.getSize2(root);
		// System.out.println("结点个数为：" + size2);
		// int size1 = binaryTree.getLeafSize1(root);
		// System.out.println("叶子结点个数为：" + size1);
		// int size2 = binaryTree.getLeafSize2(root);
		// System.out.println("叶子结点个数为：" + size2);

		int k_count = binaryTree.getLevelSize(root, 3);
		System.out.println("第3层的结点个数为：" + k_count);

		// int height = binaryTree.getHeight(root);
		// System.out.println("二叉树的高度为：" + height);

		char key = 'G';
		// TreeNode res = binaryTree.find(root, key);
		System.out.println();
		binaryTree.find(root, key);
		// System.out.println(res.val);

		int val = binaryTree.FindMaxval(root);
		System.out.println("二叉树结点的最大值为： " + val);
		System.out.print((int) 'H');

	}
}
