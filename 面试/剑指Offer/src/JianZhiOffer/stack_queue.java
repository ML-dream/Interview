package JianZhiOffer;

import java.util.Stack;
/*
 * 题目描述：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 此题是利用的是stack实现的，
 * 但是需要注意的是：
 * 			第一个栈出栈之后，需要在还原之前的栈；
 * 			还有stack2全部出栈，否者影响下一个；
 * 可以得到的：
 * 			首先这也是实现队列的一个方式；
 * 			另外一个就是使用数组就可以了；
 * 			使用链表实现！【需要一直遍历，直到没有下一个值】
 */
public class stack_queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()) {
    		Integer pop = stack1.pop();
    		stack2.push(pop);
    	}
    	if(stack2.isEmpty()) return 0;	
		int a=stack2.pop();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return a;
    }
    
    public static void main(String[] args) {
		stack_queue main02 = new stack_queue();
		main02.push(2);
		main02.push(3);
		System.out.println(main02.pop());
		
	}
}