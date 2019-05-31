package 数据结构和算法.JianZhiOffer;

/*
 * 题目描述
		输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
		如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：
 * 		判断一个树的后序遍历是否，可最后一个数肯定是根节点，也就是分界线：
 * 	去掉根节点的序列可以分成两部分，第一部分是小于根节点的；后面一部分是大于根节点！
 * 
 * 然后进行递归！
 * 
 * 
 * 
 * 思路拓展：可能会有相应的判断前序，都是一样的思路，不过就是要找根节点的值，一个在最前面，一个在后面
 * 				对于中序来说的话，就是一定是按照从小到大的顺序进行排序的！
 */
public class 判断是不是后序遍历的序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean VerifySquenceOfBST(int [] sequence) {
	     if(sequence.length == 0) return false;
	      int length = sequence.length;
	    	int num= sequence[length-1];
	    	return isSeq(sequence, 0, length-1);
	    }
	    
	    boolean isSeq(int [] seq, int start,int end){
	    	if(end<=start) return true;
	    	int i=start;
	    	int j;
	    	while(seq[i]<seq[end]) {
	    		i++;
	    	}
	    	j=i;//此处要保留下来i的值！！！！
	    	while(seq[i]>seq[end]) {
	    		i++;
	    	}
//	    	注意此处是小于end -1
	    	if(i<end-1) return false;
	    	return isSeq(seq,start,j-1)&&isSeq(seq,j,end-1);//注意传进去的数字是end-1！！！！非常重要！因为每此比较，最后那个根数字只在当前有效，下一轮就不是他了
	    }        
}
