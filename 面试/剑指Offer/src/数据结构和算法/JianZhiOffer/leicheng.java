package 数据结构和算法.JianZhiOffer;

/*
 * 总结：
 * 		思路分析：
 * 			使用if进行判断注意指数为0的时候，底数不能为0；
 * 			然后使用矩阵快速幂和常规的判断for循环，两种思路！
 * 		代码技巧：
 * 			if的简单化；
 * 			可以使用函数的局部变量，就是接收的变量，不需要自己定义！
 * 			三元表达式的使用
 * 			while的使用
 *          右移的使用！
 * 		注意的地方：
 * 			接收的数是double！这个记住	
 */
public class leicheng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=new leicheng().Power2(2, -10);
		double b=1/1024;;
		System.out.println(b);
	}
	
	public double Power2(double base,int n){
		int curr=n;
		double sum=1;
		if(n<0) n =-n;
		else if (n==0)  return sum=1;
		else n=n;
		while(n!=0) {
			if((n&1)==1)
				sum*=base;
			base*=base;
			n>>=1;
		}
		return curr>=0?sum:(1/sum);
	}
	
	
	/*public double Power(double base, int n) {
	    double res = 1,curr = base;
	    int exponent;
	    if(n>0){
	        exponent = n;
	    }else if(n<0){
	        if(base==0)
	            throw new RuntimeException("分母不能为0"); 
	        exponent = -n;
	    }else{// n==0
	        return 1;// 0的0次方
	    }
	    while(exponent!=0){
	        if((exponent&1)==1)
	            res*=curr;
	        curr*=curr;// 翻倍
	        exponent>>=1;// 右移一位
	    }
	    return n>=0?res:(1/res);       
	}
*/
}
