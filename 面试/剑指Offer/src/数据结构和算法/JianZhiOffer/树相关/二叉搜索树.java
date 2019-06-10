package 数据结构和算法.JianZhiOffer.树相关;
/**
 * 
 *     要学会使用类的实例变量，并不一定非得是使用的局部变量！！！使用局部变量需要每次传入，因为不能方法间共享，
 * 所以牵扯到方法的共享话，就会非常麻烦！
 * 
 * 
 * @author auduser
 *
 */
public class 二叉搜索树 {

	public static void main(String[] args) {
		
	}
	TreeNode head;
	TreeNode realHead;
	public TreeNode Convert(TreeNode pRootOfTree) {
		zhongOrder(pRootOfTree);
		
		return realHead;
	        
	    }
	
	void zhongOrder(TreeNode node){
		if(node==null)return;
		zhongOrder(node.left);
		
		if(head==null) {
			head=node;
			realHead=node;
		}else {
			head.right=node;
			node.left=head;
			head=node;
		}
		zhongOrder(node.right);
	}
}

