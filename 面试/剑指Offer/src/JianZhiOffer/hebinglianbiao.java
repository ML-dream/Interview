package JianZhiOffer;


/*
 * 题目：
 * 思路：
 * 		必须使用尾插法，因为有严格的排序限制着，但是要注意有以下两个思路
 * 				递归：不需要提前定义一个指针指向第一个结点；因为如下，里面的出栈之后
 * 						还会保存着主栈的指针，很方便！
 * 					public ListNode Merge(ListNode list1,ListNode list2) {
				       if(list1 == null){
				           return list2;
				       }
				       if(list2 == null){
				           return list1;
				       }
				       if(list1.val <= list2.val){
				           list1.next = Merge(list1.next, list2);
				           return list1;
				       }else{
				           list2.next = Merge(list1, list2.next);
				           return list2;
				       }       
				   }
 * 				非递归：就是我自己的方法！
 * 						注意的是，想好所有的判定边界，而且还有提前定义好头指针
 * 			反正就是比头插法多一个指针，用于储存着第一个结点！两个指针都是指向第一个节点！【这个是没有头结点的步骤！其实可以全都按照没有头结点的步骤进行，然后最后在新建一个节点，把该节点直接连接就好了！】
 * 			赋值的关键操作就是3步骤：node.next=新建的节点；【此次循环的主要目的】
 * 									node=新建的节点；【保证后面的循环，继续连接上】
 * 									list=list.next;指向下一个节点，保证循环
 * 							头插法的话就是:
 * 									定义一个指针就好了；node=null；并赋值为空。
 * 														然后新建的节点.next=node;
 * 														node=新建的节点；
 * 														如果需要头结点，就是直接最后在赋值就好了！
 * 注意点：
 * 
 */
import JianZhiOffer.hebinglianbiao.ListNode;

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
