package JianZhiOffer;
/*
 * 主要：就是进行空格的判断、以及开始的是不是null，或者“ ” 或者“   ”--使用trim
 * 		是进行整体的数组的反转就哈了，比较简单
 * 		也有使用双重反转的！知道有这个思路就好了！
 * 
 */

import java.util.Arrays;

public class 反转一句话 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reverseSentence = ReverseSentence(" ");
	}

	public static String ReverseSentence(String str) {
//		!!!重要！！！空字符串一定要加trim进行比较！！！！！！
		
		if (str==null||str.trim().equals(" ")) return str;
		String[] strArr = str.split(" ");
		reverse(strArr,0,strArr.length-1);
		String aa = "";
		for(int i=0;i<strArr.length;i++) {
			
//			！！！！重要！！一定要加这个判断，因为最后会形成一个空格！
//			优化使用stringBuffer，因为如果进行重复更改显然使用StringBuffer更加简单！
			if(i>=strArr.length-1) {
				aa+=strArr[i];
				break;
			}
			aa+=strArr[i]+" ";
		};
		return aa;
	}
        
    
	
	public static void reverse(String[] arr,int low,int high){
        String temp;
//       技巧：使用while（low《high）或者在里面进行if的判断，是保证仅仅遍历一半的技巧！
        while(low<high){
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
	}
}
