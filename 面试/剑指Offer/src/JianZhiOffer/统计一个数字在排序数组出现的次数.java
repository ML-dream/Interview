package JianZhiOffer;

/*
 * 考察知识点：看见有序---就使用的是二分查找！
 * 二分查找的几种写法：
 * 			1、递归
 * 			2、循环
 * 
 */
public class 统计一个数字在排序数组出现的次数 {

	public static void main(String[] args) {
		int [] arr = {1,2,3,5,5,5,5,6,7};
		int len =arr.length-1;
//		System.out.println(GetNumberOfK(arr, 9));
//		System.out.println(binarySearch(arr, 0, arr.length-1, 5));
		System.out.println(binarySearch2(arr, 0, arr.length-1, 3.5));
		System.out.println( binarySearch3(arr,0,len,5+0.5)-binarySearch3(arr,0,len,5-0.5));
		   
	}
	
//	方法一：普通的查找方法！
	public static int GetNumberOfK(int [] array , int k) {
		int len=array.length;
		if (array==null||len==0) return 0;
		int num=0;
		for(int i =0; i<len; i++) {
			if(array[i]==k) {
				num++;
//				此处不是你太懂，为什么必须注释掉这个才可以！！！！
//				if (array[i+1]!=k) break;
				}
		}
		return num;
    }
	
//	方法二：写一个二分查找！
	public  static int  binarySearch(int [] array,int begin,int end,int key){
//		注意要写这判定！！！！！停止条件
		if(begin > end){
            return -1;
        }
//		注意下面 的每次递归都是return!
		int mid =(begin+end)/2; 
		if(array[mid]<key) return binarySearch(array, mid+1, end, key);
		else if(array[mid]>key) return binarySearch(array, 0, mid-1, key);
		else {return array[mid];}
	}
//	这个是循环的递归
	public  static int  binarySearch2(int [] array,int begin,int end,double key){
//		注意要写这判定！！！！！停止条件
		int mid = 0;
		while(begin<=end) {
			mid= (begin+end)/2;
			if (array[mid]>key) end=mid-1;
			if (array[mid]<key) begin=mid+1;
			if (array[mid]==key) return mid;
		}
//		System.out.println(begin); //这个是返回的是插入的值起始的地方！！！！如果查这个，直接返回这个begin
		return -1;
	}
//	这个是用来返回插入值的地方的！！！
	public  static int  binarySearch3(int [] array,int begin,int end,double key){
//		注意要写这判定！！！！！停止条件
		int mid = 0;
		while(begin<=end) {
			mid= (begin+end)/2;
			if (array[mid]>key) end=mid-1;
			if (array[mid]<key) begin=mid+1;
			if (array[mid]==key) return mid;
		}
//		System.out.println(begin); //这个是返回的是插入的值起始的地方！！！！如果查这个，直接返回这个begin
		return begin;
	}
	
/*
 * 然后在把二分查找的算法应用到这个题目中！
 * 
 */
	
//	方法三：获得第一次出现的下标以及最后一次出现的下标，其实就是返回start还是end，不要把==这个选项单独出来就好了！
	//获得第一次	，注意划分的两种的if 和else	
	public  int getLower(int[] arr,int k){
		        int start = 0,end = arr.length-1;
		        int mid = (start + end)/2;
		         
		        while(start <= end){
		            if(arr[mid] < k){
		                start = mid + 1;
		            }else{
		                end = mid - 1;
		            }
		            mid = (start + end)/2;
		        }
		        return start;
		    }
		public  int getUpper(int[] arr,int k){
			int start = 0,end = arr.length-1;
			int mid = (start + end)/2;
			
			while(start <= end){
				if(arr[mid] > k){
					end = mid -1;
				}else{
					start = mid+1;
				}
				mid = (start + end)/2;
			}
			return end;
		}
}
