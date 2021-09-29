package Demo9_29;

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

		
	//读入输入的一串先序遍历字符串，根据此字符串建立一个二叉树
	//其中“#”表示的是空格，空格字符代表空树
	//建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果
	public int i = 0;  //i要设为全局的变量，方便在函数体中随循环一起被使用
	public TreeNode bulidTree2(String str){
		//首先，定义一个根节点
		TreeNode root = null;
		if(str.charAt(i)!='#'){
			//先建立根节点，再去分别建立左子树和右子树
			root = new TreeNode(str.charAt(i));
			i++;
			root.left = bulidTree2(str);
			root.right = bulidTree2(str);
		}
		else{
			i++;  //i为#，表示为空，向后走，找有值的
		}
		return root;
	}
	
	void inOrderTravelsal(TreeNode root){
		if(root == null)
			return;
		inOrderTravelsal(root.left);
		System.out.print(root.val);
		inOrderTravelsal(root.right);
	}
	
	
	//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
	public TreeNode convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null)
			return null;
		convertChild(pRootOfTree);
		//找二叉树的最多端结点，即双向链表的第一个结点
		TreeNode head = pRootOfTree;
		while(head.left != null){
			head = head.left;
		}
		return head;
	}
	
	//采用子问题求解的方法：利用中序遍历，可得到有序结点
	public TreeNode prev = null;
	public void convertChild(TreeNode proot){
		if(proot == null)
			return;
		
		convertChild(proot.left);
		proot.left = prev;
		if(prev != null){
			prev.right = proot;
		}
		prev = proot;  //更新prev
		convertChild(proot.right);
	}
	
}
	
public class binaryTree_4 {
	public static void main(String[] args){
		Tree binaryTree = new Tree();
		TreeNode root = binaryTree.bulidTree();
		System.out.println("-----中序遍历-----");
		binaryTree.inOrderTravelsal(root);
		System.out.println();
		
		Tree binaryTree2 = new Tree();
		String str = "abc##de#g##f###";
		TreeNode root2 = binaryTree2.bulidTree2(str);
		System.out.println("-----中序遍历-----");
		binaryTree.inOrderTravelsal(root2);
		System.out.println();
	
	}
}
