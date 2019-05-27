package JianZhiOffer;
/**
 * 题目描述
 *	输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来
 *的所有字符串abc,acb,bac,bca,cab和cba.
 * 
 * 思路就是：保证全排列！！！就是N!的那种，然后就是全排列的思路就是保证，第一遍历就是保证第一个数字和后面每个数字都
 * 进行互换一次，然后在进行每一次的互换的时候，在进行递归，保证每次在前面已经互换的前提下，后面的也是这么执行下去
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 字典序打印出所有字符串序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(new String("AAA")==new String("AAA"));//通过new 对象地址是不相等的！
	//也就是通过valueOf进行比较是相等的！是同一个对象；所以判断重复的时候，可以通过contrains这个判断，也能通过set去重
	System.out.println(String.valueOf("AAA")==String.valueOf("AAA"));
	}
	
	private List array=new ArrayList();
	public ArrayList<String> Permutation(String str) {
		char[] charArr = str.toCharArray();
		if (charArr.length==0) return (ArrayList<String>) array ;
		PermutationHelper(charArr, 0, array);
		Collections.sort(array);
		return (ArrayList<String>) array;
	       
    }
	 public void PermutationHelper(char[] cs, int i, List<String> list) {
//		 因为通过率只有10%，所以需要进行边界检测
		 if(!list.contains(String.valueOf(cs))) list.add(String.valueOf(cs));
		 for(int j=i;j<cs.length;j++) {
			 
			 swap(cs,i,j);
//			 此处这个i是表示的是深度，所以每次都是在之前的基础上进行+1，然后上面得j是表的广度，每一层的广度！
			 PermutationHelper(cs, i+1, list);
			
			 swap(cs,i,j);//因为是引用传递，所以可以需要在换回来，以此完成递归的栈退出的操作！！！
		 }
	 }
	 public void swap(char[] cs, int i, int j) {
	        char temp = cs[i];
	        cs[i] = cs[j];
	        cs[j] = temp;
	    }
}
