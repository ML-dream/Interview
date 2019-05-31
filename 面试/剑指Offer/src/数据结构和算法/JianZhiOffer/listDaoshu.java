package 数据结构和算法.JianZhiOffer;

/*
 * 题目描述
输入一个链表，输出该链表中倒数第k个结点
注意：
 		1、边界，倒数第k个，注意整个链表有没有k个？
 		2、注意对于一些边界的判断，暂时想不太清楚，可以使用尝试，多尝试几遍，然后
 		就对了！这个技巧不错！！！
 */
public class listDaoshu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode FindKthToTail(ListNode head,int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}
		