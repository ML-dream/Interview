package 数据结构和算法.JianZhiOffer;

public class hebinglianbiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
		public ListNode Merge(ListNode list1,ListNode list2) {
			
			if (list1==null) return list2;
			if (list2==null) return list1;
			
			ListNode node = null;
			ListNode firNode=null;
			
			if(list1.val<=list2.val) {
				firNode=new ListNode(list1.val);
				node=firNode;
				list1=list1.next;
			}else {
				firNode=new ListNode(list2.val);
				node=firNode;
				list2=list2.next;
			}
			while(list1!=null||list2!=null) {
				if(list2!=null&&list1!=null&&list1.val>=list2.val) {
					ListNode node2 = new ListNode(list2.val);
					node.next=node2;
					node=node2;
					list2=list2.next;
				}else if(list2!=null&&list1!=null&&list1.val<list2.val) {
					ListNode node2 = new ListNode(list1.val);
					node.next=node2;
					node=node2;
					list1=list1.next;
				}else if(list2==null) {
					node.next=list1;   //注意，我是用的这个思路之后，反而时间的复杂度高了
					break;
					/*ListNode node2 = new ListNode(list1.val);
					node.next=node2;
					node=node2;
					list1=list1.next;*/
				}else{
					node.next=list2;
					break;
				/*	ListNode node2 = new ListNode(list2.val);
					node.next=node2;
					node=node2;
					list2=list2.next;*/
				}
			}
			return firNode;
		}
	
	
		class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
