package 数据结构和算法.JianZhiOffer.树相关;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * 
 */

public class Main04 {

	
	public static void main(String[] args) {
		
		int pre[]= {1,2,4,7,3,5,6,8};
		int in[] = {4,7,2,1,5,3,8,6};
		TreeNode node = new Main04().reConstructBinaryTree(pre,in);
		new Main04().preOrder(node);
		System.out.println("dddddddddddddddd");
		new Main04().inOrder(node);
		
//		System.out.println(node.val);
	}
	
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		TreeNode node = new TreeNode(pre[0]);
		int length=pre.length;

		if(length==0) {
			return null;
		}
//	此处是进行查找的，但是还是不够速度，因为此处是进行暴力查找，可以使用
//		二分查找等等
//		另外：此处的可以和下面结合一下，比如直接去掉break，然后直接递归调用方法
			int i;
			for(i=0;i<pre.length;i++) {
				if(node.val==in[i])
					break;
			}
			
//			构建左子树
//用于判断是否有左子树，就是根据中序遍历中左边是否有值！	
//			优化：可以去掉二重数组的使用，只要能记住起始就好了！
			if(i>0){
			int[] pr=new int[i];   
			int[] ino=new int[i];   
			for(int j=0;j<i;j++){    
				pr[j]=pre[j+1];   
				}   
			for(int j=0;j<i;j++){    
				ino[j]=in[j];   
				}   
			node.left=reConstructBinaryTree(pr,ino);
			}else {
				node.left=null;
			}

//			构建右子树
//用于判断右边是否有右子树，就是根据中序遍历中右边是否有值！
			if(length-i-1>0) {  
			int[] pr=new int[length-i-1];   
			int[] ino=new int[length-i-1];   
//			这个是用来 通过上面确定的分离值，然后把前序的左子树部分分离出来；
//          但是以下来看,属于相同的,所以可以合并!
			for(int j=i+1;j<length;j++){    
				pr[j-i-1]=pre[j];   
				}   
//			这个是通过上面的分离值，把中序的左子树的部分分离出来！
			for(int j=i+1;j<length;j++){    
				ino[j-i-1]=in[j];   
				}   
			node.right=reConstructBinaryTree(pr,ino);
			}else {
				node.right=null;
			}
	return node;
	}
	
	 /**
	 * 前序遍历
	 */
	void preOrder(TreeNode node){
		if(node!=null) {
		System.out.print(node.val+" ");
		preOrder(node.left);
		preOrder(node.right);
		}
	}
	
	void inOrder(TreeNode node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.print(node.val+" ");
			
			inOrder(node.right);
			}
			
		}
}

	

    class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) {
    		val = x; 
    		}
    }
	
	
