package Demo9_30;


public class binaryTree_6 {
	 //从后序遍历的最后一个点开始作为根结点，然后去中序遍历序列中找该结点
    public int postIndex = 0;
    
    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int inbegin, int inend){
        if(inbegin > inend)
            return null;
        
        TreeNode root = new TreeNode(postorder[postIndex]);
        int inIndex = findOfInorder(inorder, inbegin, inend, postorder[postIndex]);
        postIndex--;
        
        if(inIndex == -1)
            return null;
        
        //依次建立右子树和左子树
        root.right = buildTreeChild(inorder, postorder, inIndex+1, inend);
        root.left = buildTreeChild(inorder, postorder, inbegin, inIndex-1);
        return root;
    }

    public int findOfInorder(int[] inorder, int inbegin, int inend, int val){
        for(int i=inbegin; i<=inend; i++){
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null)
            return null;
        if(inorder.length<=0 || postorder.length<=0)
            return null;
        //给postIndex赋值
        postIndex = postorder.length-1;
        return buildTreeChild(inorder, postorder, 0, inorder.length-1);
    }
    
	public static void main(String[] args){
		Tree binaryTree = new Tree();
		int[] inorder = {3,9,20,15,7};
		int[] postorder = {9,3,15,20,7};
		binaryTree.buildTree(inorder, postorder);
	}
}
