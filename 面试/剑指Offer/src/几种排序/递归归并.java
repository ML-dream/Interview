package 几种排序;
import java.util.Arrays;
/*
 * 递归de 
 * 
 */

class 递归归并 {
	public static void main(String[] args) {
		 int []arr = {9,8,7,6,5,4,3,2,1};
	        sort(arr);
	        System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 基本的思路
	 * ···就是通过一步步拆分，直到不能拆分为主，也就是都拆分成一个单位，此时就可以说都是有序的！
	 * ···然后在进行比较，左右进行比较！
	 * ···最后得到一个归并的序列！
	 */
	
//	然后自己写一个
	/**
	 * 这个是用来开始的地方！
	 */
	static void sort( int [] arr){
		 int [] temp = new int[arr.length];
		 msort(0,temp.length-1,arr,temp);
	}
	
	/**
	 * 这个是用来进行划分数据段的！进行小的分类
	 */
	static void msort(int left,int right,int [] arr ,int [] temp) {
		if(left<right) {
			int mid=(left+right)/2;
			msort(left,mid,arr,temp);
			msort(mid+1,right,arr,temp);
			merge(left,mid,right,arr,temp);
		}
	}
	
	/**
	 * 这个是每个数据段进行合并的地方！
	 */
	static void merge(int left,int mid,int right,int [] arr,int [] temp) {
		int i=left;
		int j=mid+1;
		int t = 0;
//		假设不重复！
		while(i<=mid && j<=right) {
			if(arr[i]<arr[j]) {
				temp[t++]=arr[i++];
			}else {
				temp[t++]=arr[j++];
			}
		}
//			然后还要把没有比较的剩下的都放在temp最后边
			while(i<=mid) {
				temp[t++]=arr[i++];
			}
			while(j<=right) {
				temp[t++]=arr[j++];
			}
//			然后这些值重新在放回原来的位置
			t=0;
			while(left <= right) {
				arr[left++] = temp[t++];
			}
		
	}
}


/*class MergeSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}*/