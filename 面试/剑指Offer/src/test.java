
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		//待合并的数组
		int[] arr = {1,2,3,4,5,6,7,14,15,16};
		int[] brr = {8,9,10,11,12,13,66};	
		//合并的数组
		int[] crr = new int[arr.length+brr.length];
		//将合并数组放入map
		Map<Integer,int[]> map = new HashMap<>();
		Integer key =  1;
		map.put(key, arr);
		map.put(++key, brr);	
		System.out.println("请输入首行数字n");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();	
		shuchu(n,map,crr);
	}
	
	public static void shuchu(int n,Map<Integer,int[]> map,int[] crr) {
		int flag = 0;
		for(int k=0;k<4;k++) {
			for(Integer i : map.keySet()) {
				int[] drr = map.get(i);
				for(int j=0;j<n;j++) {
					if(k*n+j<drr.length) {
						crr[flag] = drr[k*n+j];
						flag++;
					}				
				}
			}
				
		}
		for(int a : crr) {
			System.out.print(a+",");
		}
	}
	
}

