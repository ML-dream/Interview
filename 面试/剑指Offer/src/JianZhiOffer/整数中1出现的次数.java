package JianZhiOffer;

/*
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13
 * 中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你
 * 们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出
 * 现的次数）。
 * 思路一：直接进行n次遍历，然后对每个数进行相应的位运算找到是否有1
 * 思路二：如果进行贪婪算的的感觉，先找高位，然后进行如果---并不是使用这个思路，这个我思考的不清晰！
 * 	重要思路三：利用总结归纳：分别归纳个数数、十位数、百位出现的次数等等
 * 			
 */
public class 整数中1出现的次数 {

//	思路一：实现1
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution3(100));
	}
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		if(n<=0) return 0;
		for(int i=1;i<=n;i++) {
			String num = String.valueOf(i);
			char[] array = num.toCharArray();
			int len = array.length;
			for(int j=0;j<len;j++) {
				if(array[j]=='1') {
					count++;
//					break;//题目要求是出现1的次数，而不是哪怕个位数和十位数已经重复
				}
			}
		}
		return count;
	    
    }
//	思路二：实现二
	public static int NumberOf1Between1AndN_Solution2(int n) {
        int count=0;
        while(n>0){
            String str=String.valueOf(n);
            char [] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1')
                    count++;
            }
            n--;
        }
        return count;
    }
//	思路三：
	
    public static int NumberOf1Between1AndN_Solution3(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;          
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
       }
        return count;
    }

}
