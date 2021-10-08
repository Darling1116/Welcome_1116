package Demo10_8;

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
	public TreeNode bulidTree(){
		//手动建立固定的二叉树
		TreeNode A = new TreeNode(1);
		TreeNode B = new TreeNode(2);
		TreeNode C = new TreeNode(3);
		TreeNode D = new TreeNode(4);
		A.left = B;
		A.right = C;
		B.left = D;
		return A;  //返回根节点
	}
	
	//采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串
	public void tree2strChild(TreeNode root, StringBuffer sb){
		if(root==null)
			return;
		TreeNode p = root;
		//1.根不为空，先打印根节点
		sb.append(p.val);
		//2.左边为空：右为空，返回；右不为空，加（）
		if(p.left==null){
			if(p.right==null){
				return;
			}
			else{
				sb.append("()");
			}
		}
		//3.左边不为空，加（ ---递归左子树---加 ）
		else{
			sb.append("(");
			tree2strChild(p.left, sb);
			sb.append(")");
		}
		//4.右为空，返回
		if(p.right==null){
			return;
		}
		//5.右边不为空，加（ ---递归右子树---加 ）
		else{
			sb.append("(");
			tree2strChild(p.right, sb);
			sb.append(")");
		}
	}
	
	public String tree2str(TreeNode root){
		StringBuffer sb = new StringBuffer();
		tree2strChild(root, sb);
		//返回String类型
		return sb.toString();
	}
	
}

public class binaryTree_7 {
	public static void main(String[] args){
		Tree binaryTree = new Tree();
		TreeNode root = binaryTree.bulidTree();
		System.out.println(binaryTree.tree2str(root));
	}
}
