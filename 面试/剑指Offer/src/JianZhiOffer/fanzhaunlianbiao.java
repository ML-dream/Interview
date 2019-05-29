package JianZhiOffer;


/*
 * 注意：链表的头插法是与先出现得在后面，最后出现的是头结点！
 * 		一般情况下，都是先暂时开一个新节点，然后使用头插法一直插入，直到插完为止！
 * 
 * 
 */
public class fanzhaunlianbiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	不带头结点的头插法！一开始使用head=null！！！！重要
	    public ListNode ReverseList(ListNode head) {
//			注意进行判断传入进来的这个head是否为空！
	    	
	    	ListNode node1 = null ;
	    	while(head!=null) {
	    		ListNode node = new ListNode(head.val);
	    		node.next=node1;
	    		node1=node;
	    		head=head.next;	    
				
			}
	    	return node1.next;
	        
	    }
//	   尾插法  就是正常的先进先出，先出现的是第一个
//	    此时为了返回第一个结点，需要提前建立两个指针，目的是为了存储第一个指针，因为后续的步骤
//	    会把这个指针一直向后迭代！
	    public ListNode CreateList(ListNode head){
	    	
	    	ListNode listNode2 = new ListNode(head.val);
			ListNode node1=listNode2;
			ListNode node2=listNode2;
			head=head.next;
			
			while(head!=null) {
				
				ListNode listNode = new ListNode(head.val);
				node1.next=listNode;
				node1=listNode;
				head=head.next;
			}
//	    	就是为了存储这个节点！
	    	return node2;
	    	
	    	
	    }
}

 
 
        