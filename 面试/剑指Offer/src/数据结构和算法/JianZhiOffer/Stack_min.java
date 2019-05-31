package 数据结构和算法.JianZhiOffer;


/*一般栈的题目很多会用到辅助栈！！！！！！！
 * 注意：
 * 		题目提示的，使用栈结构
 * 		其次是思路
 * 				使用一个最小栈用来保存最小值！！！
 * 				可以每次都进行比较，当当前的数比最小栈的数小或者等于的时候，就两个同时压栈新入的数，
 * 				然后相反的时候，就就一个压入新入 的数，一个压入上一个的minNode【其实也可以不压入，但是取值的时候就得进行判断
 * 				是否取出的数是否等于最小的栈顶，如果是，最小栈的值就得也出栈！不如前面的思路好！】
 * 
 */
import java.util.Stack;

public class Stack_min {



	    public static Stack<Integer> stack= new Stack();
	    public static Stack<Integer> minStack= new Stack();
	    int minNode;
	    public void push(int node) {
	        
	    /*	if(stack.isEmpty()) minNode=node;
//	        if(node<=minStack.peek()) minNode = node;
	        minNode= node<=minStack.peek()?node:minStack.peek();
	    	stack.push(node);
        	minStack.push(minNode);*/
//此处必须使用if else。因为用双if  适合直接return返回的时候使用！  
//	    	如果是这样，不管是不是空，后面都会执行，如果是空，后面不应该执行，因为，node无法和minstack，里面是空值，会初始化为0！
	        if(stack.isEmpty()) {
	        	minNode=node;
	        	stack.push(node);
	        	minStack.push(minNode);
	        }else{
	        	if(node<=minStack.peek()) minNode = node;
	        	stack.push(node);
	        	minStack.push(minNode);
	        }
	    }
	    
	    public void pop() {
	        stack.pop();
	        minStack.pop();
	    }
	    
	    public int top() {
		
	    	return stack.peek();
	        
	    }
	    
	    public int min() {
	        return minStack.peek();
	    }
	

}
