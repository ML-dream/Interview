package 其他知识点.test;
public class Test
{
	public static void main(String[] args)
	{
		Test1 ss = new Test1();
	}
}
/*�ܽ�һ��
 ʹ�ö�̬�����Ϊ�����������̬������Ҫ������ͱ������඼Ҫʵ�ֽӿڣ���Ӳ����ǰд����Ӧ����
 ��̬������̬�Ĺ������ɴ����ࡿ��
 JDK�������ã�ʵ����չ��ʵ�����أ��ص㣺����Ҫ������ʵ�ֽӿڣ����Ǳ�������Ȼ��Ҫ����Ϊ��̬������Ҫ���ݽӿ�֪�����ķ���������Ҫ����ӿڶԹ���Ĵ�����
 ���н��ա�
 cglib�������Դ����κ��࣬����Ҫ������ʵ�ֽӿڡ�

 ��̬�����Ӧ�ã��������Ĺ��ܣ�������web.xml�У����ض���������й��ˣ�Ȼ����õ���Ӧ�ķ����У�������Ӧ�Ķ�̬������̬����չ�����ķ���������������Ӧ�ı������ã���һ���ô���
 ���Զ����е�������в�ͬ�Ĵ������ɣ���̬�������˴����������ߣ�ÿ�����󶼽���дһ����Ӧ�Ĵ����࣬��Ȼ���鷳�����⣬����Ǳ��������нӿڵģ���ʹ��JDK�������û�нӿڣ���ʹ��cglib����
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
	//������̾��ǣ�channel--readbuffer--ֱ�ӵ�--socketBuffer--�ٵ�channel
	//˵����buffer����limit�����ĺ�������ʶ
	//		channel������һ��˫���ͨ�������Խ�����Ϣ�Ľ�����
	//      channel����ע�ᵽselector�У�����ѡ���
	
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
