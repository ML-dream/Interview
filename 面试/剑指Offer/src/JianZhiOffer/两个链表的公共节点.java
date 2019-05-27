package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

import org.omg.Messaging.SyncScopeHelper;

/**
 * @author auduser
 *牵扯到的知识点：
 *		1、比较两个对象是否相同：使用==比较，看的是内存地址！
 *		2、至于比较equals：
 *				1、如果没有重写这个方法，那么默认比较的也是==，也就是内存地址；
 *				2、String就重写了这个方法，于是比较的是字符串的内容
 *		3、关于hashCode：
 *				返回的对象的的哈希索引值，通常用于进行进行散列存储的时候使用，和equals和配合使用！
 *				但是，注意的是：两个不同的对象又可能会哈希值相同，比如在hashset的哈希桶+链表中，
 *				链表就是用来存储哈希值相同的对象！
 *      方法三：使用hashMap的特性，
 *      大神的解法
 *			如果有相同的节点，那么一定有公共的尾部！！！！只不过两者的长度不一样导致的如何遍历的问题
 *			方法一：先算出两者 的长度差，开始进行遍历
 *			方法二：链接：https://www.nowcoder.com/questionTerminal/6ab1d9a29e88450685099d45c9e31e46
					来源：牛客网
					
					class Solution {
					public:
					    ListNode* FindFirstCommonNode( ListNode *pHead1, ListNode *pHead2) {
					        ListNode *p1 = pHead1;
					        ListNode *p2 = pHead2;
					        while(p1!=p2){
					            p1 = (p1==NULL ? pHead2 : p1->next);
					            p2 = (p2==NULL ? pHead1 : p2->next);
					        }
					        return p1;
					    }
					};
 */	
public class 两个链表的公共节点 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node11 = new ListNode(1);
		System.out.println(node1==node11);
		System.out.println(node1.equals(node11));
		System.out.println(node1.hashCode());
		System.out.println(node11.hashCode());
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next=node3;
		node3.next=node5;
		node2.next=node4;
		node4.next=node5;
		System.out.println(node5.toString());
		System.out.println(FindFirstCommonNode(node1,node2).toString());
		System.out.println(node5.toString());
	}
//	放到一个数据结构里面，进行遍历查找！
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null) return null;
		ArrayList<String> list = new ArrayList<String>();
		list.add(pHead1.toString());
		System.out.println(pHead1.val);
		while(pHead1.next!=null){
			list.add(pHead1.next.toString());
			System.out.println(pHead1.next.val);
			pHead1=pHead1.next;
		}
/*	for(String a:list) {
		System.out.println(a);
	}*/
//		String [] array = (String[])list.toArray(new String[0]);
//		System.out.println(array.toString());
		if(list.contains(pHead2.toString())) return pHead2;
		
		while(pHead2.next!=null) {
			if(list.contains(pHead2.next.toString())) {
//				System.out.println(pHead2.next.toString());
				return pHead2.next;
				}
			pHead2=pHead2.next;
		}
		return null;
    }
	
//方法二：使用是二分查找！！！但是适用于元素比较多的情况！！！
/*	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null) return null;
		ArrayList<String> list = new ArrayList<String>();
		list.add(pHead1.toString());
		System.out.println(pHead1.val);
		while(pHead1.next!=null){
			list.add(pHead1.next.toString());
			System.out.println(pHead1.next.val);
			pHead1=pHead1.next;
		}
	for(String a:list) {
		System.out.println(a);
	}
		String [] array = (String[])list.toArray(new String[0]);
//		System.out.println(array.toString());
		Arrays.sort(array);
		if(Arrays.binarySearch(array, pHead2.toString())>=0) return pHead2;
		
		while(pHead2.next!=null) {
			if(Arrays.binarySearch(array, pHead2.next.toString())>=0) {
//				System.out.println(pHead2.next.toString());
				return pHead2.next;
				}
			
			pHead2=pHead2.next;
		}
		return null;
    }*/
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}

