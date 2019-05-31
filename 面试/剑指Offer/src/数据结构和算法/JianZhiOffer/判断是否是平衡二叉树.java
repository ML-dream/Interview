package 数据结构和算法.JianZhiOffer;

/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 */

/*
 * 	方法一：其实就是结合上面的求树的深度在加一个遍历二叉树的过程！只不过每个遍历都有两种思路：
 * 			首先是递归，其次是非递归【类似层序遍历的方法】。就看怎么组合！最简洁及其容易理解的写法就是使递归！
 * 			public classSolution {
			    public boolean IsBalanced_Solution(TreeNode root) {
			        if(root == null) {
			            return true;
			        }
			        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
			            IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
			    }
			      
			    private int maxDepth(TreeNode root) {
			        if(root == null) {
			            return 0;
			        }
			        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
			    }
			}
			
	方法二：因位判断AVL只需要判断每个节点的的左右子树的深度【就是最大长度！】没必要进行重复判断！
			public class Solution {
			    //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
			    private boolean isBalanced=true;
			    public boolean IsBalanced_Solution(TreeNode root) {
			        getDepth(root);
			        return isBalanced;
			    }
			    public int getDepth(TreeNode root){
			        if(root==null)
			            return 0;
			        int left=getDepth(root.left);
			        int right=getDepth(root.right);
			         
			        if(Math.abs(left-right)>1){
			            isBalanced=false;
			        }
			        return right>left ?right+1:left+1;
			         
			    }
			}
 * 
 */
public class 判断是否是平衡二叉树 {

	public static void main(String[] args) {
		
	}
	private boolean isBalanced=true;
	public boolean IsBalanced_Solution(TreeNode root) {
	        getDepth(root);
	        return isBalanced;
	    }
	private int  getDepth(TreeNode root) {
		
		if(root==null) return 0;
		int left=getDepth(root.left);
        int right=getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;
	
		
	}
	
}
