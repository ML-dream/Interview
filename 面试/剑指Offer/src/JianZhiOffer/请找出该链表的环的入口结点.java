package JianZhiOffer;
/*
 * 思路：
 * 		首先根据内存地址进行判断！
 * 		其次：根据指针，先找出相交的点，比如就是说第二指针比第一个指针走慢一点，然后最终会相交，那么
 * 			相交的时候，其实就是第一个指针肯定是比第二个指针多走一个环！然后第二个指针，回到起点处，开始走，
 * 			【注意：这个是推导出来的！】
 * 
 */

/*
 * public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null|| pHead.next==null|| pHead.next.next==null)return null;
        ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;
        /////先判断有没有环
        while(fast!=slow){
            if(fast.next!=null&& fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else{
                //没有环,返回
                return null;
            }
        }
        //循环出来的话就是有环，且此时fast==slow.
        fast=pHead;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
 */
public class 请找出该链表的环的入口结点 {

	public static void main(String[] args) {
		
	}
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		if(pHead==null||pHead.next==null||pHead.next.next==null) return null;
		
		ListNode qidian=pHead;
		ListNode jiaonode = lookJiaoDian(qidian);
		ListNode look = look(pHead,jiaonode);
		return look;
    }
	
	static ListNode lookJiaoDian(ListNode slow) {
		ListNode fast=slow;
		while(slow != null && fast != null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) return slow;
		}
		return null;
	} 
	static ListNode look(ListNode pHead,ListNode jiaoNode) {
		while(true) {
			pHead=pHead.next;
			jiaoNode=jiaoNode.next;
			if(pHead==jiaoNode) return pHead;
		}

		
	} 
}
