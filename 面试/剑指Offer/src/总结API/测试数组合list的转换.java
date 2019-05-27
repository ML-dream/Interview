package 总结API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;   
public class 测试数组合list的转换 {  
    public static void main(String[] args) {  
        String[] array=new String[3];  
        array[0]="a";  
        array[1]="b";  
        array[2]="c";  
//        对数组进行排序
        Arrays.sort(array);
//        使用二分查找对数组进行进行查找
        int search = Arrays.binarySearch(array, 'b');
//        将数组转为list
        List<String> list = Arrays.asList(array);
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));
//        对list进行排序，注意实现自己定义相应的comparator就好！
        list.sort(null);
//		将list转为数组，注意只能是Object的数组，无法强转，默认的
        Object[] array2 = list.toArray();
//        将list转为相应的数据，使用如下！！！！
        String [] array3 = (String[])list.toArray(new String[0]);
        
//        遍历list，使用for循环，foreach实际上使用的itretor，不太适合，因为不能使用非itertor的方法进行修改
        for(int i=0;i<arrayList.size();i++){  
            System.out.println(arrayList.get(i));  
        }
    }  
}
