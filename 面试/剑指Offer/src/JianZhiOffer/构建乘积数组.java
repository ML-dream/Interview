package JianZhiOffer;
/*
 * 题目 :给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 		其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * 
 * 思路：由于不能使用除法，所以只能先进行顺序的相乘，
 * 				然后在进行逆顺序的相乘，然后再把他们组合起来！
 * 
 */
public class 构建乘积数组 {

	public static void main(String[] args) {
		int[] A= {1,2,3,4,5,6};
		int[] multi = multiply(A);
		System.out.println(multi.toString());
	}
	
	
	public static int[] multiply(int[] A) {
		int [] arr=new int[A.length];
		for(int i=0;i<A.length;i++) {
			int sum = 1;
			for(int j=i+1;j<A.length;j++) {
				sum*=A[j];
			}
//			arr[i]=sum;
			
			int sum2 = 1;
			for(int j=0;j<i;j++) {
				sum2*=A[j];
			}
			arr[i]=sum*sum2;
			
			
		}
		
		return arr;

    }
	
}
