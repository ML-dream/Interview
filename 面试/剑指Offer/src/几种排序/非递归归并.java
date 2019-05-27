package 几种排序;

import java.util.Arrays;

/**
 * 归并的作用：可以用于查找逆序对的数量！
 *
 */


/*
 * 非递归版的归并排序，省略了中间的栈空间，直接申请一段O(n)的地址空间即可，因此空间复杂度为O(n),时间复杂度为O(nlogn);
算法思想：
　　开始以间隔为1的进行归并，也就是说，第一个元素跟第二个进行归并。第三个与第四个进行归并；
　　然后，再以间隔为2的进行归并，1-4进行归并，5-8进行归并；
　　再以2*2的间隔，同理，知道2*k超过数组长度为止。
*
*/



public class 非递归归并 {
    public void mergeSort(int[] arr) {
        if(arr==null || arr.length<=0)
            return;
        int width = 1;
        while(width<arr.length) {
            mergePass(arr,width);
            width*=2;
        }
    }
     
    private void mergePass(int[] arr,int width) {
        int start=0;
        while(start+2*width-1<arr.length) {
            int mid=start+width-1;
            int end=start+2*width-1;
            merge(arr,start,mid,end);
            start=start+2*width;
        }
        //剩余无法构成完整的两组也要进行处理
//        此处很是巧妙，利用的是前面只是处理能够构成完整的两组的，如果构不成的两组的，但是能够构成一组到两组之间的，
//        就进行下面的过程；
//        但是如果一组都构不成的,直接过去就好了,因为了没有merge的意义啊!!!!
        if(start+width-1<arr.length)
            merge(arr, start, start+width-1, arr.length-1);
    }
//     此处的merge,和之前的递归基本一样!
    private void merge(int[] arr, int start, int mid, int end) {
        int i=start;
        int j=mid+1;
        int[] temp = new int[end-start+1];
        int index=0;
        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j])
                temp[index++]=arr[i++];
            else
                temp[index++]=arr[j++];
        }
        while(i<=mid)
            temp[index++]=arr[i++];
        while(j<=end)
            temp[index++]=arr[j++];
         
        for(int k=start;k<=end;k++)
            arr[k]=temp[k-start];
    }
     
    //==========测试代码=================
    public void test5() {
        int[] a ={9,8,7,6,5,4,3,2,1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
     
    public static void main(String[] args) {
        	非递归 demo =new 非递归();
        	demo.test5();
    }
}	