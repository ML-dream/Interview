package JianZhiOffer;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 题目描述
 * 	在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *  思路：
 *  	1、使用一个hahset来确保是不是重复，过程就是一直放入，然后当有重复的时候，删除这个节点，然后把将指针指到下一个节点，
 *  		此种思路不可以：因为要求是去掉所有的重复的，包括原来的点，haskset最后保留只是去重后的点，而且只能删除重复一次的，对于重复两次的一点作用也么有！
 *  	2、	使用网上牛客的做法，进行递归！！仔细根据西路划出调用的路线的，返回的路线，才能搞清楚原理！
 *  	3、保存下所有的不重复的数字，然后重新创建，但是不科学！但是保存的时候，需要注意：不能用hashSet保存，最后我发删除重复的原来的数字，所以需要使用list，，然后在把所有重复全部删除。
 *  	删除的时候可以先排序，然后在删除，此时使用双层遍历；或者递归？？？就和牛客的提供的思路一样的；一会回来可以实现以下！！顺便回顾下，链表的遍历！
 *  
 *  总结：这个算法我已经自己写好了一遍递归的写法，以及自己写的先去重【但是此处还有另外的方法，自己的去重比较麻烦，可以利用空间换简单思路的方法，下面有思路】，自己在重新创建的方法，
 *  	但是还有非递归的思路，可以看看怎么实现的？
 *  	及其排序的算法；
 *  	整理自己的所有的算法！链表相关的！
 */
public class 删除重复链表节点 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(1);
		node1.next=node2;
		node1.next.next=node3;
		node1.next.next.next=new ListNode(1);
		node1.next.next.next.next=node4;
		node1.next.next.next.next.next=new ListNode(1);
		node1.next.next.next.next.next.next=node5;
		ListNode node = deleteDuplication(node1);
		ArrayList list= new ArrayList();
		
		while(node.next!=null) {
			System.out.println(node.val);
			node=node.next;
		}
		System.out.println(node.val);
	}
	
	/*
	 * 这个之所以是错的，是因为，删除的时候我只是删除重复本身的那个数字，应该直接删除掉全部的这个
	 * public static ListNode deleteDuplication(ListNode pHead)
    {
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode qishi=pHead;

		while(true){
			ListNode backUp=null;
			if(pHead.next==null) break;
			
			if(!isEqual(set,pHead.next.val)) {
				backUp=pHead.next;
				pHead.next=pHead.next.next;
//				backUp.next=null;
				pHead=pHead.next;
			}else {
				set.add(pHead.val);
				if(!isEqual(set,pHead.next.val)) continue;
				pHead=pHead.next;
			}
		}
		return qishi;
    }*/
	
	
//	方法二 、、、下面自己写一个关于list的实现！顺便可以实现一个链表的遍历和创建！
	public static ListNode deleteDuplication(ListNode pHead) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(pHead!=null) {
			list.add(pHead.val);
			pHead=pHead.next;
		}
		//经过验证已经是排好序的的了
		/*for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i));
		}*/
//		接下来我自己排序的算法！--一会在同一回顾一下把，有关所有的排序的算法！
		//接下来开始进行去重！---这个方法的前提是有序，但是可以有不用有序的方法！
		System.out.println();
		ArrayList<Integer> list2 = quChong(list);
		
	/*	for(int i=0;i<list2.size();i++) {
			System.out.print(list2.get(i));
		}*/
		if(list2.isEmpty()) return null;
//		开始构建相应的链表
		ListNode node = new ListNode(list2.get(0));
		
		ListNode node1=node;
		for(int i=1;i<list2.size();i++) {
			node1.next=new ListNode(list2.get(i));
			node1=node1.next;
		}
		return node;
		
	}
	
	
	
	//工具方法：自己写的去重函数，包括把所有的原来的那个数一删除掉，前提是有序的的！
	//扩展：可以首先第一次进行遍历，然后找到重复的数，然后吧在遍历一次，吧所有的有的这个数全都删除掉，比较简单自由，而且没有任何前提，还能保证原有的顺序！
	public static ArrayList<Integer> quChong(ArrayList<Integer> list ) {
		//双重遍历
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int val1=list.get(i);
			boolean flag=true;
			if(i==list.size()-1) list2.add(list.get(list.size()-1));
			for(int j=i+1;j<list.size();j++) {
				
				if(flag&&list.get(j)!=list.get(i)) {
					list2.add(list.get(i));
//					flag=false;
					break;
				}else if(list.get(j)==list.get(i)) {
					flag=false;
					i++;
					continue;
				}
			}
			
		}
		
		return list2;
	}
	
	
	
	
//	方法一---递归实现！！！！这时自己写的有关的递归实现的！
			public static ListNode deleteDuplication1(ListNode pHead) {
				if(pHead==null||pHead.next==null) return pHead;
				//				就是判断有没有重复的节点！
				if(pHead.val==pHead.next.val) {
					ListNode pNode=pHead.next;
					while(pNode!=null&&pNode.val==pHead.val) {
						pNode=pNode.next;
					}
					return deleteDuplication(pNode);
//此处返回的肯定是要不就是下一次判断else的得出pHead，要不然就是上面的得出的null或者不为空的pHead
				}else {
					pHead.next=deleteDuplication(pHead.next);
//					因为从pHead开始就是不重复的，所以要返回pHead；
					return pHead;
				}
			}
//使用的是递归，一会必须自己写一遍！理清思路。
		
		   /* public static ListNode deleteDuplication(ListNode pHead) {
		        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
		            return pHead;
		        }
		        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
		            ListNode pNode = pHead.next;
		            while (pNode != null && pNode.val == pHead.val) {
		                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
		                pNode = pNode.next;
		            }
		            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
		        } else { // 当前结点不是重复结点
		            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
		            return pHead;
		        }
		    }*/
	
//	方法三：非递归实现！！！！主要是理清逻辑什么时候进行修改
		//其实和递归不只是下面那两句话的差别，其实是:将遍历循环分成了两种可能，当直接可以确定的
		//的情况下，直接就走else的路线，当中间有重复的情况下，走if的路线，每次都会执行到不相等
			//时候，然后直接
			public static ListNode deleteDuplication3(ListNode pHead) {
				if (pHead==null || pHead.next==null){return pHead;}
				ListNode Head = new ListNode(0);
				Head.next = pHead;
				ListNode pre  = Head;
				ListNode last = Head.next;
				while (last!=null){
				    if(last.next!=null && last.val == last.next.val){
				        // 找到最后的一个相同节点
				        while (last.next!=null && last.val == last.next.val){
				            last = last.next;
				        }
//				        pre.next = last.next;
				        last = last.next;//这一步就是和递归的区别！！！
				    }else{
				    	pre.next=last.next;
				        pre= pre.next;
				        last = last.next;//zhe一步就是和递归的区别
				    }
				}
				return Head.next;
			}
	public static boolean isEqual(HashSet<Integer> set ,int a) {
		for(Integer value:set) {
			if(value==a) return false;
		}
		return true;
	}

}
