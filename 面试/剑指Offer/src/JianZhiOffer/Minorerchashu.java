package JianZhiOffer;
/*
 * 此题主要就是一个思路问题：
 * 			不分左右，只要保证每一个有子节点的界面左右调换就可以了！！！
 * 
 * 
 */
public class Minorerchashu {

	public static void main(String[] args) {
		
	}
	
	   public void Mirror(TreeNode root) {
		   if (root==null) return;//注意这个语句非常重要！！！！！一般出现通过50%就代表可能是边界的监测有问题
		   TreeNode temp;
		   if (root!=null) {
			   temp=root.left;
			   root.left=root.right;
			   root.right=temp;
		   }
		   if(root.left!=null)Mirror(root.left);
		   if(root.right!=null)Mirror(root.right);
	    }
}
