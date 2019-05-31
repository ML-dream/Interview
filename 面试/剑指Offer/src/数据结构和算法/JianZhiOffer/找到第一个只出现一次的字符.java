package 数据结构和算法.JianZhiOffer;

import java.util.Arrays;
/*
 * 
 * 
 */
public class 找到第一个只出现一次的字符 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FirstNotRepeatingChar("shsyjhhhhhhsjllgggp"));
	}
	
	public static int FirstNotRepeatingChar(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        System.out.println(new String (array));
        for(int i=0;i<array.length-1;i++) {
        	if(array[i]!=array[i+1]) return str.indexOf(array[i]);
        	char flag=array[i];
        	int j=i;
        	while(array[j+1]==flag) {
        		j++;
        		if(j+1>=array.length-1) break;
        	}
        	i=j;
        
        	/*if(array[i]!=array[i+1]) return str.indexOf(array[i]);
        	if(array[i]==array[i+1]) i++;*/
        }
		return -1;
    }

    /*    public boolean FirstNot(char[] array,char ch) {
			for() {
				
			}
        	
        	return false;
        }*/
       

}
