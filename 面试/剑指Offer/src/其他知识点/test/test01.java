package 其他知识点.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class test01 {

	@Test
	public void testso(){
		int a[][]={{1,2,3},{4,5,6}};
		System.out.println(a.length);
		System.out.println(Find(2,a));
	}
    public boolean Find(int target, int [][] array) {
            for(int i = array.length-1;i>=0;i--){
                if(array[i][0]>target){
                    continue;
                }else if(array[i][0]==target){
                    
                    return true;
                }else{
                    for(int j:array[i]){ 
                        if(target==j) {
                        	return true;
                        }
                    }
                    
                }
                
            }
            return false;
        }
	public static void main(String[] args) throws Exception {
	/*	// TODO Auto-generated method stub
		
		String src = "14"; 
		String srcPattern = "HH"; 
		String outPattern = "HH:mm"; 
		String out = new SimpleDateFormat(outPattern).format(new SimpleDateFormat(srcPattern).parse(src));
		
		System.out.println(out);*/
		new test01().testso();
	}

}

class Solution {
    public boolean Find(int target, int [][] array) {		
        for(int[] arr:array){
            for(int num:arr){
                return num == target;
            }
        }
		return false;
    }
}


	


