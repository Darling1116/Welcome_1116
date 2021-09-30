package Demo9_30;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class Tree{
	//首先，分析该问题的子问题
	public int preIndex = 0;  //从先序序列的第一个结点开始找起作为根结点
	public  TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin, int inend){
		if(inbegin > inend)
			return null;
		
		//取先序遍历序列的第一个结点作为根结点
		TreeNode root = new TreeNode(preorder[preIndex]);
		//去中序遍历序列中找该结点
		int rootIndex = findInInorder(inorder, inbegin, inend, preorder[preIndex]);
		//要更新preIndex的值
		preIndex++;
		if(rootIndex == -1)
			return null;
		//依次构建左子树和右子树
		root.left = buildTreeChild(preorder, inorder, inbegin, rootIndex-1);
		root.right = buildTreeChild(preorder, inorder, rootIndex+1, inend);
		return root;
	}
	
	
	public int findInInorder(int[] inorder, int inbegin, int inend, int val){
		for(int i=inbegin; i<=inend; i++){
			if(inorder[i] == val)
				return i;
		}
		return -1;
	}
	
	//给定一棵树的前序遍历 preorder与中序遍历 inorder,构造二叉树并返回其根节点。
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null || inorder==null)
			return null;
		if(preorder.length<=0 || inorder.length<=0)
			return null;
		return buildTreeChild(preorder, inorder, 0, inorder.length-1);
	}
	
	public void display(TreeNode root){
		if(root == null)
			return;
		TreeNode cur = root;
		while(cur != null){
			System.out.print(cur.val+' ');
		}
	}
	
}
public class binaryTree_5 {
	public static void main(String[] args){
		Tree binaryTree = new Tree();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		binaryTree.buildTree(preorder, inorder);


	}
}
