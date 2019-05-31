package 数据结构测试;

import java.util.ArrayList;
import java.util.Arrays;

public class 链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] aa= {1,2,3,4};
		System.out.println(Arrays.toString(aa));
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list.size());
		list.remove(2);
		System.out.println(list.toString());
		System.out.println(list.size());
		
		ArrayList list2 = new ArrayList(list);//深拷贝！
		list2.remove(2);
		System.out.println(list.toString());
		System.out.println(list2.toString());
	}

}
