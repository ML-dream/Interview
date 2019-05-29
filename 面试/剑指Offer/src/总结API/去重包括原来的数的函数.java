package 总结API;

import java.util.ArrayList;

public class 去重包括原来的数的函数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	///方法一：扩展：可以首先第一次进行遍历，然后找到重复的数，然后吧在遍历一次，吧所有的有的这个数全都删除掉，比较简单自由，而且没有任何前提，还能保证原有的顺序！
	//z找个就不写了，估计比较简单！
	//方法二、、、自己写的去重函数，包括把所有的原来的那个数一删除掉，前提是有序的的！
		
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
//						flag=false;
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
}
