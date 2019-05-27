package JianZhiOffer;
/*
 * 思考方式是一样的 ，就是假设一开始的方法，然后进行下面的:
 * 假设先摆一个或者先摆两个，然后进行下面的；
 * 就是f(n)=f(n-1)+f(n-2);
 * 但是要把一开始的成立的那些默认值先写出来，比如n=0和n=1和n=2时
 * 
 */
public class _91juxing {
	public int RectCover(int target) {
		if(target==0) return 0;
		if(target==1) return 1;
		if(target==2) return 2;
		int num= RectCover(target-1)+RectCover(target-2);
	        return num;
	    }
	}
