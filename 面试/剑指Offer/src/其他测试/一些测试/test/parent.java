package 其他测试.一些测试.test;

class parent {
	public static void main(String args[]) throws Exception {
	
	int aa = test2.a;

	/* Class  cla=Class.forName("test.test1");//����com.TestOne����أ�����һ��Class����  
     System.out.println("********jiazai");  */
  //   test1 one=(test1)cla.newInstance();//�������Class������һ��ʵ�������ø����޲εĹ��췽�������õ�ͬ��new TestOne()  
	}
}

class test2{
	static  int a =1; 	
	static {
		System.out.println("daimakuai ^^^^");
		
	}
	
	 test2() {		
		System.out.println("test1��ʼ��������������");		
	}	
}