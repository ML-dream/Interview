package JianZhiOffer;

public class TreeZJieGou {

	public static void main(String[] args) {
		
		
	}
//	首先思路是使用递归，因为牵扯到树的话，一般都是使用递归才能进行深度遍历
//	想到二叉树的建立【拓展二叉数】【利用前序和中序遍历的结果进行建立】
//	想到二叉树的遍历：三种方式，还有层序遍历【暂时不知道如何写】。
	
	
//总体思路：两层遍历嵌套循环！！！！
	/*
	 * 注意：使用result，不直接在if（）里面进行判断，有利于减少执行步骤！
	 * 		最常规的就是使用result作为一个检查标记，标识是否向下进行！！！前面的边界
	 * 检测可以直接判断并返回【注意返回意味着后面的程序不再执行！】
	 * 
	 * 如果仅需精简的话，可以使用好短路的特性，就是每一行都是返回的，一旦返回就不用继续执行，可以减少result的使用！
	 */
	    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
//			第一步进行边界检测
	    	boolean result = false ;
//	    	if(root2==null) return true;
//	    	if(root1==null) return false;   //注意顺序不能调换！
	    	if(root2 != null && root1 != null) {
		    	if(root1.val==root2.val) result=doesTree1HaveTree2(root1,root2);
		    	if(!result) result= HasSubtree(root1.left, root2); 
		    	if(!result) result= HasSubtree(root1.right, root2);
		    	}
	    	
	        return result;
	    }
	    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
	    	if(root2==null)return true;
	    	if(root1==null)return false; 
	    	if(root1.val!=root2.val) return false;//注意顺序不能调换！
	    	return doesTree1HaveTree2(root1.left, root2.left)&&doesTree1HaveTree2(root1.right, root2.right);
	    	
}
		class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        public TreeNode(int val) {
	            this.val = val;

	        }
	    }
}
