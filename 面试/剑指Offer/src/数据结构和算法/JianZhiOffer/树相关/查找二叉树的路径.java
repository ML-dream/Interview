package 数据结构和算法.JianZhiOffer.树相关;
/*
 * 技巧：1、【很重要啊】
 * 		一个值传递，可以做到递归的时候，只保留自己的方法栈帧的值，但是一个引用传递无法做到，
 * 因为引用传递，在递归中不断改变的！
 * 		要想引用传递做到递归时仅仅保留自己栈帧的时候数据，那么每次调用返回的时候都把当前这
 * 一次方法调用内做的改变全都消除掉！！！就可以了！
 * 		2、注意实现comparator和comparable的区别！
 * 后者是用来对自定义的的类实现该接口，使得我们可以通过collection.sort和array.sort工具类进行排序！	
 * 前者是比较的时候当比较的元素时系统定义的，我们无法对内部进行comparable进行实现，于是就出现了comparator
 *      3、自己一直在想arrayList的深度克隆怎么实现，不用clone，直接new ArrayList（list）；就好了
 */



import java.util.ArrayList;

public class 查找二叉树的路径 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left=new TreeNode(2);
		node.left.left=new TreeNode(3);
		node.left.right=new TreeNode(3);
		node.right=new TreeNode(2);
		node.right.left=new TreeNode(3);
		node.right.right=new TreeNode(3);
		node.right.right.left=new TreeNode(3);
		
		ArrayList<ArrayList<Integer>> arrayList = FindPath(node, 9);
		System.out.println(arrayList.toString());
	}
    
	static class Comp implements java.util.Comparator<ArrayList<Integer>>{
		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			// TODO Auto-generated method stub
			return o2.size()-o1.size();
		}
	}
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> l2 = new ArrayList<Integer>();
    	int sum=0;
    	ArrayList<ArrayList<Integer>> find = Find(root,target,sum,list,l2);
    	find.sort(new Comp());
    	return list;
    }

    public static ArrayList<ArrayList<Integer>> Find(TreeNode root,int target,int sum,
    		ArrayList li,ArrayList list) {
    	
    	list.add(root.val);
    	sum+=root.val;
    	if(root.left==null&&root.right==null) {
    	if(sum==target) {
    		ArrayList arrayList = new ArrayList();
//    		自己一直在想arrayList的深度克隆怎么实现，不用clone，直接new ArrayList（list）；就好了
    		for(int i=0;i<list.size();i++) {
    			arrayList.add(list.get(i));
    		}
    		/*	while(!list.isEmpty()) {
    				arrayList.add(list.remove(0));
    			} */ 
    			li.add(arrayList);
//    	,如果不是空
    	}
    	list.remove(list.size()-1);
    	return li;
    }
    	if(root.left!=null) Find(root.left, target, sum,li,list);
    	if(root.right!=null) Find(root.right,target,sum,li,list);
    	list.remove(list.size()-1);
		return li;
    }
    
}
