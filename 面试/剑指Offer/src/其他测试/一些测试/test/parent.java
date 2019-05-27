package test;


class parent {
	public static void main(String args[]) throws Exception {
	
	int aa = test2.a;

	/* Class  cla=Class.forName("test.test1");//进行com.TestOne类加载，返回一个Class对象  
     System.out.println("********jiazai");  */
  //   test1 one=(test1)cla.newInstance();//产生这个Class类对象的一个实例，调用该类无参的构造方法，作用等同于new TestOne()  
	}
}

class test2{
	static  int a =1; 	
	static {
		System.out.println("daimakuai ^^^^");
		
	}
	
	 test2() {		
		System.out.println("test1初始化………………");		
	}	
}