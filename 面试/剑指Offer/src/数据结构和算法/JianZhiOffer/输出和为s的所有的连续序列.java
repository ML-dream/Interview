package 数据结构和算法.JianZhiOffer;
/*
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的
 * 找出所有和为S的连续正数序列? Good Luck!
 * 
 */
import java.util.ArrayList;

public class 输出和为s的所有的连续序列 {

	public static void main(String[] args) {
		FindContinuousSequence(1);
	}
	
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int i = 1;
		int j = 1;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(sum==1) return list;
		
				while(true) {
			if(isSum(i,j)<sum) {
				j++;
			}
			if(isSum(i,j)>sum) {
				i++;
			}
			if(isSum(i,j)==sum) {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				for(int n=i;n<=j;n++) {
					list2.add(n);
				}
				i++;
				list.add(list2);
			}
			if(i>=sum||j>=sum||i==j) {
				break;
			}
			
		}
		return list;
	     
		
    }
	
	static int isSum(int i,int j) {
		int sum=0;
		for(int n=i;n<=j;n++) {
			sum+=n;
		}
		return sum;
		
	}
	
}
