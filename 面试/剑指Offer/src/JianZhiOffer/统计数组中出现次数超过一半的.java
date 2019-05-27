package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 题目描述
 *		数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *		例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}.由于数字2在数组中出现了5次，
 *		超过数组长度的一半，因此输出2.如果不存在则输出0.
 *
 * 牵扯到的知识点：
 * 		1、hashMap JDK8 的更新的知识点
 * 			compute函数的使用！挺有用的！
 * 		2、hashMap遍历的四种方法，尤其是不可以使用直接for循环遍历
 * 		3、还有关于如何创建的相应的匿名内部类
 * 		4、还有关于map.entry{}这种的定义，因为这个就是map内的数据结构，相当字典！！！
 * 	所以创建相应的comparator实现类的时候，需要传入这个，但是不能直接比较map类的，
 * 必须先把map转换成相应的list，因为比较的内部使用的是for循环的数组比较的，可能不是使用的迭代器，
 * 需要需要的排序的话应该使用的相应的TreeMap！	
 * 		
 */
public class 统计数组中出现次数超过一半的 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] aaa={1,2,3,2,2,2,5,4,2};
		MoreThanHalfNum_Solution(aaa);
	}

	public static int MoreThanHalfNum_Solution(int [] array) {
		HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0;i<array.length;i++) {
			if(hashMap.containsKey(array[i])) {
				hashMap.compute(array[i],(k, v) -> ++v);
			}else {
				hashMap.put(array[i], 1);
				
			}
		}
		 List<Entry<Integer, Integer>> list = 
				 new ArrayList<Map.Entry<Integer,Integer>>(hashMap.entrySet());
		Collections.sort(list,new Comparator<HashMap.Entry<Integer,Integer>>() {
            //升序排序
  /*          public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }*/

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
            
        });
//		数组的遍历
		System.out.println(list.iterator().next().getKey());
		if(list.iterator().next().getValue()>array.length/2) {
		return list.iterator().next().getKey();
		}else {
			return 0;
		}
    }
	/*private static Object getFirstOrNull(HashMap<Integer,Integer> hashMap) {
    	Object obj = null;
        for (Entry<String, Object> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }*/

	
//	思路二：非常简单的，非常的巧妙，首先进行排序，利用sort先进性排序，collection.sort底层
//	               实际还是调用的array.sort,然后以前使用的是归并排序，不过，不过现在是使用的timsort
//	数组排序后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
//	这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优；
	public int MoreThanHalfNum_Solution1(int [] array) {
        int len=array.length;
        if(len<1){
            return 0;
        }
        int count=0;
//        此处的排序有一定的时间复杂度
        Arrays.sort(array);
        int num=array[len/2];
        for(int i=0;i<len;i++){
            if(num==array[i])
                count++;
        }
        if(count<=(len/2)){
            num=0;
        }
        return num;
    }
/**
 * 思路三：采用用户‘分形叶’思路（注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，
 * 		     到最后剩下的一个数就是该数字。如果剩下两个，那么这两个也是一样的，就是结果），在其
 * 		    基础上把最后剩下的一个数字或者两个回到原来数组中，将数组遍历一遍统计一下数字出现次数
 *        进行最终判断。
 * 
 * 思路四：【复杂度只有O（n）】很不错的思路！！！！
		采用阵地攻守的思想：
		第一个数字作为第一个士兵，守阵地；count = 1；
		遇到相同元素，count++;
		遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，
		又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
		再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 */
}
