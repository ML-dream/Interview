package 几种排序;

import java.util.Arrays;

public class 堆排序 {

	public static void main(String[] args) {
		
		int [] a= {10,1,9,2,3,8,3,1,7,41};
		System.out.println(Arrays.toString(buildMaxHeap(a)));
	}

	//堆排序
    public static int[] heapSort(int[] array){
        array = buildMaxHeap(array); //初始建堆，array[0]为第一趟值最大的元素
        for(int i=array.length-1;i>1;i--){  
            int temp = array[0];  //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0,i);  //整理，将剩余的元素整理成堆
        }
        return array;
    }
    
	//构建大根堆：将array看成完全二叉树的顺序存储结构
    private static int[] buildMaxHeap(int[] array){
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for(int i=(array.length)/2;i>=1;i--){ 
            adjustDownToUp(array, i,array.length);
        }
        return array;
    }
    
    //将元素array[k]自下往上逐步调整树形结构
    private static void adjustDownToUp(int[] array,int s,int length){
        int temp = array[s];   
        for(int i=2*s; i<=length; i*=2){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if(i<length && array[i]<array[i+1]){  //取节点较大的子节点的下标
                ++i;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if(temp>=array[i]){  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            }else{   //根节点 <左右子女中关键字较大者
                array[s] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                s = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[0] = temp;  //被调整的结点的值放人最终位置
    }
}
