package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;




public class Main01 {
/*	ListNode node;*/
	
	
/*	ListNode InitNode() {  //初始化节点
		node=new ListNode(111);
		node.next=null;
		return node;
		}*/
	
	public static void main(String[] args) {
		new Main01().createListNode();
	}
	
    public  void createListNode(){
		ListNode node1=new ListNode(111);
    	for(int i=100;i>=1;i--) {
//    		采用头插法！要保证每次都是产生一个新的节点！
    		ListNode node2=new ListNode(i);
    		node2.next=node1.next;
    		node1.next=node2;
    		
    	}
    	System.out.println(printListFromTailToHead(node1));
    	
    }
    
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
      
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		while(listNode.next!=null) {
			arrayList.add(listNode.val);
			listNode=listNode.next;
			
		}
		System.out.println(arrayList.size());
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		for(int i=arrayList.size()-1;i>=0;i--) {
			arrayList2.add(arrayList.get(i));
		}
	
		Collections.reverse(arrayList2);
		return arrayList2;
        
    
    }
}

class ListNode {
    int val;
    ListNode next = null;

     ListNode(int val) {
         this.val = val;
    }
 }
