package test;
public class Test
{
	public static void main(String[] args)
	{
		Test1 ss = new Test1();
	}
}
/*总结一下
 使用动态代理分为三种情况：静态代理：需要代理类和被代理类都要实现接口，僵硬的提前写好相应的类
 动态代理【动态的过程生成代理类】：
 JDK代理：作用：实现扩展、实现拦截；特点：不需要代理类实现接口，但是被代理仍然需要，因为动态过程需要根据接口知道他的方法及其需要这个接口对构造的代理类
 进行接收。
 cglib代理：可以代理任何类，不需要被代理实现接口。

 动态代理的应用：拦截器的功能，配置在web.xml中，对特定的请求进行过滤，然后调用到相应的方法中，生成相应的动态代理，动态的扩展这个类的方法，比如增加相应的编码设置，有一个好处，
 可以对所有的请求进行不同的代理生成，动态，减少了代码量，否者，每个请求都进行写一个相应的代理类，显然很麻烦；另外，如果是被代理是有接口的，就使用JDK代理；如果没有接口，就使用cglib代理
 * 
 * 
 * 
 * 
 * */
class Test1{
	//private static Test1 t = new Test1();	 
	public static String a = "1"; 
	static 
	{
		System.out.println(Test1.a);
		Test1.a = "2";
		
		
		/*System.out.println(Test1.a);
		System.out.println(Test1.b);
		Test1.b = "4";
		System.out.println(Test1.b);*/
	
	}
	//这个过程就是：channel--readbuffer--直接到--socketBuffer--再到channel
	//说明：buffer是有limit参数的和其他标识
	//		channel，就是一个双向的通道，可以进行信息的交换！
	//      channel必须注册到selector中，进行选择的
	
	/*private static String b = "3";
	static 
	{
		System.out.println(Test1.b);
	}*/
	

	Test1()
	{
		System.out.println("Constructor");
		System.out.println(Test1.a);
		//System.out.println(Test1.b);
	}
}
