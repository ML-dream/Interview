package JianZhiOffer;
/*
 * 
 * https://www.cnblogs.com/fxplove/articles/2500898.html
 * 所有的出栈序列求解
 * 
 * 掌握判断的规律！！！
 */
import java.util.Stack;

public class isOutOrderStack {

	public static void main(String[] args) {

		
		
	}
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		int j=0,i=0;
		Stack<Integer> stack = new Stack<Integer>();
		for(i=0;i<pushA.length;i++) {
			stack.push(pushA[i]);
			while(!stack.empty() && stack.peek() == popA[j]) {
				stack.pop();
				j++;
			}
		}
		
		return stack.empty();
	      
    }

}
