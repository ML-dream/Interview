package 其他测试.一些测试.test;

class SingleTon {
	private static SingleTon singleTon = new SingleTon();
	public static int count1;
	public static int count2 = 0;
	
 
	private SingleTon() {
		count1++;
		count2++;
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);
	}
 
	public static SingleTon getInstance() {
		return singleTon;
	}
}
 
public class Test2 {
	public static void main(String[] args) throws Exception {
		//SingleTon singleTon = SingleTon.getInstance();
		Class  cla=Class.forName("test.SingleTon");//���ؾͻ�����̬��ִ�У�����
		
		SingleTon singleTon = SingleTon.getInstance();
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);
	}
}
