package Demo9_28;

import java.util.Scanner;

class TreeNode{
	char val;
	TreeNode left;
	TreeNode right;
	public TreeNode(char val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class Tree{
	public TreeNode bulidTree(){
		//手动建立固定的二叉树
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
		return A;  //返回根节点
	}
	

	//二叉树遍历：编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树。 
	//例如先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格。
	//建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果
	public static int i = 0;
	public TreeNode bulidTree2(String str){
		TreeNode root = null;
		if(str.charAt(i)!='#'){
			root = new TreeNode(str.charAt(i));
			i++;
			root.left = bulidTree2(str);
			root.right = bulidTree2(str);
		}
		else{
			i++;
		}
		return root;
	}
	
	//中序遍历
	public void inOrderTravelsal(TreeNode root){
		if(root == null)
			return;
		inOrderTravelsal(root.left);
		System.out.print(root.val);
		inOrderTravelsal(root.right);
	}
	
	//找树中两个指定节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return null;
        if(root==p || root==q)
        	return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null)
        	return root;
        else if(left != null)
        	return left;
        else if(right != null)
        	return right;
        else 
        	return null;
    }
	
}
	
public class binaryTree_3 {
	public static void main(String[] args){
		Tree binaryTree = new Tree();
		TreeNode root = binaryTree.bulidTree();
		System.out.println("-----中序遍历-----");
		binaryTree.inOrderTravelsal(root);
		System.out.println();
		
//		Scanner scan = new Scanner(System.in);
//		String str = scan.nextLine();
//		TreeNode root2 = binaryTree.bulidTree2(str);
//		binaryTree.inOrderTravelsal(root2);
		
	

	}
}
