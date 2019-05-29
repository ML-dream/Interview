package 其他测试.一些测试.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//sʹ��join����֤�̵߳�˳��ִ�У�������
	/*	for (int i = 0; i < 1; i++) {
			 Thread  t = new Thread(new producter(re), "Producer" + (i + 1));
			 
			 t.start();
			// t.sleep(10000);
		//	 t.join();
		}
		
	
		for (int i = 0; i < 1; i++) {
			Thread t= new Thread(new consumer(re), "Consumer" + (i + 1));
					t.start();
			   //  t.join();
		}*/
		
	
		//������һ��ִ�е��ģ�
		
		
		
		
		Lock lock = new ReentrantLock();
		Condition producterCondition = lock.newCondition(); 
		Condition consumerCondition  = lock.newCondition(); 
		
		resource re = new resource(lock,producterCondition,consumerCondition);
		
		new Thread(new producter(re,lock,producterCondition)).start();
		new Thread(new consumer(re,lock,consumerCondition)).start();
		/*new Thread(new producter(re,lock,producterCondition)).start();
		new Thread(new consumer(re,lock,consumerCondition)).start();*/
		/*new Thread(new producter(re)).start();
		new Thread(new producter(re)).start();
		new Thread(new  consumer(re)).start();
		new Thread(new  consumer(re)).start();
		new Thread(new  consumer(re)).start();
		new Thread(new  consumer(re)).start();
		new Thread(new  consumer(re)).start();*/
	}

}
