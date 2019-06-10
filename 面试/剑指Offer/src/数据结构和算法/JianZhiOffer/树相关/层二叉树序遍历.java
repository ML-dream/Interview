package 数据结构和算法.JianZhiOffer.树相关;
/*
 * 就是广度优先遍历==层序遍历
 * 
 * 思路
 * 			利用一个list实现节点的保存，就是保存每一层的节点，然后遍历这一层的节点的时候，同时把这一层的所有的节点按照循环的方式
 * 		把下一层的所有节点进行保存！
 * 				技巧：利用arrayList.remove（0）可以返回左边第一个元素，然后并删除，正好可以在这个地方进行使用！！！！
 * 			我自己原来的思路是使用的是递归，但是感觉递归行不通或者说递归不可能，要采用递归首先应该得有很清晰的相同的操作的思路才可以；
 * 		我自己这样试是不太可能实现的！---这时候应该尽快想其他的办法！
 */
import java.util.ArrayList;

public class 层二叉树序遍历 {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(2);
		ArrayList<Integer> list = PrintFromTopToBottom(node);
//		System.out.println(list.toString());
		
		ArrayList<ArrayList<Integer>> arrayList = new 查找二叉树的路径().FindPath(node, 3);
		System.out.println(arrayList.toString());
	}

		 public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		        ArrayList<Integer> list = new ArrayList<>();
		        ArrayList<TreeNode> queue = new ArrayList<>();
		        if (root == null) {
		            return list;
		        }
		        queue.add(root);
		        while (queue.size() != 0) {
		            TreeNode temp = queue.remove(0);
		            if (temp.left != null){
		                queue.add(temp.left);
		            }
		            if (temp.right != null) {
		                queue.add(temp.right);
		            }
		            list.add(temp.val);
		        }
		        return list;
		    }

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		ArrayList<Integer> list = PrintFromTopToBottom(node);
		System.out.println(list.toString());
	}
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		int high = 1;
		while(root.left!=null) {
			high++;
			root=root.left;
		}
		for(int j=1;j<=high;j++) {
			printZi(j,root,array,high);
			
		}
		return array;
	        
	    }
	
	static void printZi(int h,TreeNode root,ArrayList<Integer> array,int high){
		if(root==null) return;
	    int hh=0;
		while(hh!=h) {
				hh++;
				printZi(hh,root.left,array,high);
				printZi(hh,root.right,array,high);
			}
		System.err.println(root.val);
		 array.add(root.val);
	}
	
	*/
	}





  