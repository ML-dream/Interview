package 其他知识点.其他;

/**
 * @author auduser
 *主要是用来测试初始化 的执行顺序的
 *
 */
public class test01 {
	
	public static void main(String[] args) {
        // 创建第1个主类对象
        
		final int[] a = {1,2,3};
		a[0]=3;
		System.out.println(a[0]);
		/*System.out.println("第1个主类对象：");
        InitialOrderWithoutExtend ts = new InitialOrderWithoutExtend();

        // 创建第2个主类对象
        System.out.println("第2个主类对象：");
        InitialOrderWithoutExtend ts2 = new InitialOrderWithoutExtend();

        // 查看两个主类对象的静态成员：
        System.out.println("2个主类对象的静态对象：");
        System.out.println("第1个主类对象, 静态成员sam.s: " + ts.sam);
        System.out.println("第2个主类对象, 静态成员sam.s: " + ts2.sam);*/
    }
}
	 class InitialOrderWithoutExtend {
	    static SampleClass sam = new SampleClass("静态成员sam初始化");
	    SampleClass sam1 = new SampleClass("普通成员sam1初始化");
	    
	    static {
	        System.out.println("static块执行");
	        if (sam == null)
	            System.out.println("sam is null");
	        sam = new SampleClass("静态块内初始化sam成员变量");
	    }

	    SampleClass sam2 = new SampleClass("普通成员sam2初始化");

	    InitialOrderWithoutExtend() {
	        System.out.println("InitialOrderWithoutExtend默认构造函数被调用");
	    }
	    
	    static void testFuncition() {
	    	
	    	System.out.println("静态函数执行");
	    }

	    
	}

	class SampleClass {
	/*	final int a=1;*/
		
		/*String a = "ABCabc";
		
		a = "123456";*/

	    // SampleClass 不能包含任何主类InitialOrderWithoutExtend的成员变量
	    // 否则导致循环引用，循环初始化，调用栈深度过大
	    // 抛出 StackOverFlow 异常
	    // static InitialOrderWithoutExtend iniClass1 = new InitialOrderWithoutExtend("静态成员iniClass1初始化");
	    // InitialOrderWithoutExtend iniClass2 = new InitialOrderWithoutExtend("普通成员成员iniClass2初始化");

	    String s;
	    
	    SampleClass(String s) {
	        this.s = s;
	        System.out.println(s);
	    }

	    SampleClass() {
	        System.out.println("SampleClass默认构造函数被调用");
	    }

	    @Override
	    public String toString() {
			
			String s = "ABCabc";
			System.out.println("s = " + s);
			
			s = "123456";
			System.out.println("s = " + s);
			
			final int[] a = {1,2,3};
			a[0]=3;
	    	return this.s;
	    }
	}


/*
 * 	这个演示当main函数所在的类中有静态成员的时候，实现
	public class test01 {
	    
		 
		 public static void main(String[] args) {
		        // 创建第1个主类对象
		        System.out.println("第1个主类对象：");
		        test01 ts = new test01();

		        // 创建第2个主类对象
		        System.out.println("第2个主类对象：");
		        test01 ts2 = new test01();

		        // 查看两个主类对象的静态成员：
		        System.out.println("2个主类对象的静态对象：");
		        System.out.println("第1个主类对象, 静态成员sam.s: " + ts.sam);
		        System.out.println("第2个主类对象, 静态成员sam.s: " + ts2.sam);
		    }
		 
		static SampleClass sam = new SampleClass("静态成员sam初始化");
	    SampleClass sam1 = new SampleClass("普通成员sam1初始化");
	    static {
	        System.out.println("static块执行");
	        if (sam == null)
	            System.out.println("sam is null");
	        sam = new SampleClass("静态块内初始化sam成员变量");
	    }

	    SampleClass sam2 = new SampleClass("普通成员sam2初始化");

	    test01() {
	        System.out.println("InitialOrderWithoutExtend默认构造函数被调用");
	    }

	    
	}

	class SampleClass {
	    // SampleClass 不能包含任何主类InitialOrderWithoutExtend的成员变量
	    // 否则导致循环引用，循环初始化，调用栈深度过大
	    // 抛出 StackOverFlow 异常
	    // static InitialOrderWithoutExtend iniClass1 = new InitialOrderWithoutExtend("静态成员iniClass1初始化");
	    // InitialOrderWithoutExtend iniClass2 = new InitialOrderWithoutExtend("普通成员成员iniClass2初始化");

	    String s;

	    SampleClass(String s) {
	        this.s = s;
	        System.out.println(s);
	    }

	    SampleClass() {
	        System.out.println("SampleClass默认构造函数被调用");
	    }

	    @Override
	    public String toString() {
	        return this.s;
	    }
	}



 * 
 * */
