package 数据结构和算法.JianZhiOffer.树相关;


/*
 * 几种方法：
 * 		1、首先是自己写的遍历；
 * 		2、牛客写的特别精简的遍历；
 * 		3、非递归：使用层次遍历；
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
/*
 *   输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class 求树的深度_也就是最大路径 {
	
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		node1.left=new TreeNode(2);
		node1.right=new TreeNode(3);
		node1.left.left=new TreeNode(4);
		node1.left.right=new TreeNode(5);
		node1.left.right.left=new TreeNode(7);
		node1.right.right=new TreeNode(6);
		System.out.println(TreeDepth(node1));
	}
	
	public static int TreeDepth(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer maxDepth=0;
		Integer depth=0;
		if(root==null) return depth;
		lookTreeDepth(root,list,depth+1);
		return (Collections.max(list));
    }
	
	private static void lookTreeDepth(TreeNode root, ArrayList<Integer> list,int depth) {
		if(root.left!=null)  {
			depth++;
			TreeNode root1=root.left;
			lookTreeDepth(root1,list,depth);
			depth--;
		}else {
			list.add(depth);
			
			} 
		if(root.right!=null)  {
			depth++;
			TreeNode root2=root.right;
			lookTreeDepth(root2,list,depth);
			depth--;
		}else {
			list.add(depth);
			return;
			} 
	}
	/*
	 * 原来的代码如下：存在引用传递的时候，存在混乱，因为root是引用传递，不是值传递，所以容易导致进行递归传递的时候，出栈的时候；
	 * root的修改没有改回来！
	 * 所以需要使用新建一个值进行传递，保证每一层调用的时候，从方法签名获得的引用传递没有被改变！
	 * 
	 *  所以使用递归：
	 *  	保证每一层进行递归调用的时候，传递的值如果是引用传递，那就重新传递一个新值；如果值传递，就直接传递就好！
	 *  	
	 * 
	 * private static void lookTreeDepth(TreeNode root, ArrayList<Integer> list,int depth) {
		
		if(root.left!=null)  {
			depth++;
			root=root.left;
			lookTreeDepth(root,list,depth);
			depth--;
		}else {
			list.add(depth);
			
			} 
		if(root.right!=null)  {
			depth++;
			root=root.right;
			lookTreeDepth(root,list,depth);
			depth--;
		}else {
			list.add(depth);
			return;
			} 
	}*/

	void lookTreeDepth(TreeNode root,Integer maxDepth,int depth){
		maxDepth++;
	}

}


