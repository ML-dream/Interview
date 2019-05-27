package JianZhiOffer;

import org.junit.jupiter.api.Test;
/*
 * 1、递归【内存使用太大！】
 * 2、for循环[比较好，因为没有太空空间浪费]
 * 3、暴力
 * 
 */

//下面这个是用循环来做



public class feibonaqi {
     public int Fibonacci(int n) {
	    int a=1,b=1,c=0;	
	    
	    if(n==0||n==1||n==2) {
	    	return n==0?0:1;
	    }else{
	    	for(int i=3;i<=n;i++ ) {
	    		c=a+b;
	    		a=b;
	    		b=c;
	    		
	    	}
	    	return c;
	    }
     }
}
  
/*
 * 自己写的这个真的是醉了，因为，输入的是n，我自己反而写了个循环！！！！！！！醉了
 * public class feibonaqi {

	public  int Fibonacci(int n) {
           	int i;
           	for(i=0;i<39;i++) {
                return Fbi(i);
            }
           	return Fbi(i);
        }
    static int Fbi(int i) {
		if(i<2) {
			return i ==0?0:1;
		}
		return Fbi(i-1)+Fbi(i-2);
	}
}*/




/*public class feibonaqi {
    public int Fibonacci(int n) {
        
        if(n<=0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }

        return Fibonacci(n-2)+Fibonacci(n-1);
        
    }
}*/

/*
 * 这个相当于上面的那个精简版！
 *
public class feibonaqi {
    public int Fibonacci(int n) {
        
       if(n<2) {
			return n ==0?0:1;
		}
		return Fibonacci(n-1)+Fibonacci(n-2);
}
}*/