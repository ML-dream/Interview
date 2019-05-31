package 数据结构和算法.JianZhiOffer;


/*
 * 注意：链表的头插法是与先出现得在后面，最后出现的是头结点！
 * 		一般情况下，都是先暂时开一个新节点，然后使用头插法一直插入，直到插完为止！
 * 
 * 头插法：新节点变为链表的第一个节点，字面意思就是在头上进行插入！！！
 * 尾插法：新节点变为链表的最后的节点，字面意思就是在尾部进行插入！！！
 * 还可以使用栈结构！！！但是比较浪费空间
 */
public class fanzhaunlianbiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//递归的版本，非常的巧妙，先从后面开始反转
	/*
	 * 
	 * //第二种方法是：递归方法 /*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
            val(x), next(NULL) {
    }
};
class Solution {
public:
    ListNode* ReverseList(ListNode* pHead) {
        //如果链表为空或者链表中只有一个元素
        if(pHead==NULL||pHead->next==NULL) return pHead;
         
        //先反转后面的链表，走到链表的末端结点
        ListNode* pReverseNode=ReverseList(pHead->next);
         
        //再将当前节点设置为后面节点的后续节点
        pHead->next->next=pHead;
        pHead->next=NULL;
         
        return pReverseNode;
         
    }
};
	 * 
	 */
	
	
	/*
	 * 	    public ListNode ReverseList(ListNode head) {
			ListNode node1 = new ListNode(111);
	    	while(head!=null) {
	    		ListNode node = new ListNode(head.val);
	    		node.next=node1.next;
	    		node1.next=node;
	    		head=head.next;	    
				
			}
	    	return node1.next;
	        
	    }
	 */
//	不带头结点的头插法！一开始使用head=null！！！！重要
	    public ListNode ReverseList(ListNode head) {
//			注意进行判断传入进来的这个head是否为空！
	    	
	    	ListNode node1 = null ;//node1存在的目的就是保存上一轮的留下的结果
	    	while(head!=null) {
	    		ListNode node = new ListNode(head.val);
//node1作用体现，就是把当前的新节点的next和上一轮的进行连接起来，此时node1就可以更改了，目的已经起到
	    		node.next=node1;
//	    		然后node1开始吧当前这一轮的数据保存下来！
	    		node1=node;
//	    		使用这个进行下一轮的遍历！
	    		head=head.next;	    
			}
	    	return node1;
	    }
//	   尾插法  就是正常的先进先出，先出现的是第一个
//	    此时为了返回第一个结点，需要提前建立两个指针，目的是为了存储第一个指针，因为后续的步骤
//	    会把这个指针一直向后迭代！
	    
//	    这个只是复制了一个链表利用的尾插法，这个题不能使用这个，因为新节点插在后面创建链表，
//	    正好是相反的！
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

 
 
        