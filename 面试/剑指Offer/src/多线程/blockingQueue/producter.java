package ���߳�.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.junit.Test;

public class producter implements Runnable {

	resource resource=null;
	Lock lock = null;
	Condition producterCondition = null;
	producter(resource resource,Lock lock,Condition condition){
		this.resource= resource;
		this.lock = lock;
		this.producterCondition = condition;
	}

	/**
	 * ����
	 * 
	 */
	
	@Test
	@Override
	public void run() {
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			this.wait(5000);
		} catch (Exception e) {
			System.out.println("ִ�еȴ�");
		}*/
		//synchronized (resource) {
			//lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"�����߳̿�ʼִ�С�������");
				// TODO Auto-generated method stub
				resource.add();
				System.out.println(Thread.currentThread().getName()+"������+1");
			}finally{
				//lock.unlock();
				
			}
			
			
			
	//	}
		
		
	}
	
	

}
