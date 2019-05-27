package JianZhiOffer;

/*
 * 判断是不是丑数的话：进行不断的循环，是否能够被2和3及其5整除
 * 
 * 
 */
public class 输出第n个丑数 {
	
	
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(10));
	}
	
    public static int GetUglyNumber_Solution(int index) {
     
   if(index<=0)
            return 0;
        int[] result = new int[index];
        int count = 0;
//       这三个指针维护着当前这三个队列目前的最小值！就是当前指针乘5 或者乘3，及其乘2的时候！
//       然后没次循环都把每一次的选出的最小值放到上面！知道达到最小的值！
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
 
        result[0] = 1;
        int tmp = 0;
        while (count < index-1) {
            tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            if(tmp==result[i2] * 2) i2++;//三条if防止值是一样的，不要改成else的
            if(tmp==result[i3] * 3) i3++;
            if(tmp==result[i5]*5) i5++;
            result[++count]=tmp;
        }
        return result[index - 1];
    }
 
    private static int min(int a, int b) {
        return (a > b) ? b : a;
    }
}