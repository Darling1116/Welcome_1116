package Demo9_27;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


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
	
	//前序遍历
	public void preorderTraversal(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
	}
	
	//前序遍历(非递归方法)
	public void preorderTraversal2(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();	
		//使用cur遍历二叉树的各节点
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				//当前结点不为空，打印，并进栈，一直走到最左边
				System.out.print(cur.val);
				stack.push(cur);
				cur = cur.left;
			}
			//当前结点为空，栈顶元素出栈，让cur指向其右孩子
			TreeNode top = stack.pop();
			cur = top.right;  
			//若当前结点的右孩子为空，就要看栈是否为空，不为空继续循环
		}
	}
	
	
	//中序遍历
    public void inorderTraversal(TreeNode root) {
    	if(root == null)
    		return;
    	inorderTraversal(root.left);
    	System.out.print(root.val);
    	inorderTraversal(root.right);
    }
    
	//中序遍历(非递归算法)
    public void inorderTraversal2(TreeNode root) {
    	if(root == null)
    		return;
    	TreeNode cur = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(cur != null || !stack.isEmpty()){
    		//当cur不为空时，进栈，一直走到最左端结点
    		while(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}
    		//当cur为空时，取栈顶元素并打印，然后让cur指向当前元素的右孩子
    		TreeNode top = stack.pop();
    		System.out.print(top.val);
    		cur = top.right;
    	}
    }
	
    //后序遍历
    public void postorderTraversal(TreeNode root) {
    	if(root == null)
    		return;
    	postorderTraversal(root.left);
    	postorderTraversal(root.right);
    	System.out.print(root.val);
    }
    
    //后序遍历(非递归算法)
    public void postorderTraversal2(TreeNode root) {
    	if(root == null)
    		return;
    	TreeNode cur = root;
    	TreeNode prev = null;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(cur != null || !stack.isEmpty()){
    		//当cur不为空时，进栈，一直走到最左端结点
    		while(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}
    		cur = stack.peek();
    		//若当前结点的右孩子为空或者是当前结点已经访问过，就访问当前结点
    		if(cur.right == null || cur.right==prev){
    			System.out.print(cur.val);
    			stack.pop();
    			prev = cur;
    			cur = null;
    		}
    		//当前结点的右孩子不为空，让当前结点指向有孩子
    		else{
    			cur = cur.right;
    		}
    	}
    }
    
    
	//判断一棵树是否为满二叉树(利用层次遍历)
	boolean isComplementTree(TreeNode root){
		//若根节点为空或者是只有一个根节点，都为满二叉树
		if(root == null)
			return true;
//		if(root.left == null && root.right == null)
//			return true;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode cur1 = queue.poll();
			//这里不能使用while语句，对于每一个出队结点，都要对其进行判断
			if(cur1 != null){
				queue.offer(cur1.left);
				queue.offer(cur1.right);
			}
			else{
				break;  //说明遇到了空结点，退出循环
			}
		}
		//如果是因为出队结点为空才返回的，就要判断队列中是否还有非空元素
		while(!queue.isEmpty()){
			TreeNode cur2 = queue.peek();
			if(cur2 != null){
				return false;
			}
			else{
				queue.poll();
			}
		}
		return true;
	}
	
	
	
	
}


public class binaryTree_2 {
	public static void main(String[] args){
		Tree binaryTree = new Tree();
		TreeNode root = binaryTree.bulidTree();
		
		System.out.println("-----先序遍历-----");
		binaryTree.preorderTraversal(root);
		System.out.println();
		System.out.println("-----先序遍历-----");
		binaryTree.preorderTraversal2(root);
		System.out.println();
		System.out.println("-----中序遍历-----");
		binaryTree.inorderTraversal(root);
		System.out.println();
		System.out.println("-----中序遍历-----");
		binaryTree.inorderTraversal2(root);
		System.out.println();
		System.out.println("-----后序遍历-----");
		binaryTree.postorderTraversal(root);
		System.out.println();
		System.out.println("-----后序遍历-----");
		binaryTree.postorderTraversal2(root);
		System.out.println();
		
		boolean ret = binaryTree.isComplementTree(root);
		System.out.println("是否为完全二叉树： "+ret);
		
	}
}
