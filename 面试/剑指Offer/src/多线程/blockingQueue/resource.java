package ���߳�.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class resource {
	
	private int  num = 0;
	Lock lock = null;
	Condition producterCondition = null;
	Condition consumerCondition = null;
	
	private BlockingQueue resourceQueue = new LinkedBlockingQueue(10);
	
	resource(Lock lock,Condition producterCondition,Condition consumerCondition){
		this.lock = lock;
		this.producterCondition = producterCondition;
		this.consumerCondition = consumerCondition;
	}
	//���Ҫ���ܶ��߳̽��еĻ���һ��blockingQueue��������10��ֻ�����10���̵߳ļ�1�������ټӾ������ˣ������̶߳���������������
	//����������������̵߳Ļ�����ʵҲ���Կ�������Ϣ���У�ֻ�ܷ���10���̣߳���������10������û�е�ʱ�����������߳̽�����
	//�����Ҫ�ϸ����򣬰��տ�ʼ�������������ֱ��ʹ��join��ע�⣺������join�Ǳ���ȴ��߳�ִ����ϣ���������˵Ļ����ͻ�һֱ�ȴ������߳�Ҳֹͣ�ˣ�ע�⣡
	//ʵ���첽����������к󣬷��ؽ���Ƕ��������߳���ϣ����Ǻ�̨���ڴ���
	//�̳߳غ�blockingQneue֮��Ĺ�ϵ����newһ���̳߳ص�ʱ����Ҫ����һ��blockingQueue���ײ���Ҫʲô���нṹ����̣߳�����
	/*synchronized*/ @SuppressWarnings("unchecked")
	int  add ()  {
		while(true) {
		try {
			
			System.out.println(Thread.currentThread().getName()+"������ִ��"+resourceQueue.size());
			resourceQueue.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	//	return resourceQueue.size();
		/*try {
			
			lock.lock();
			System.out.println("kaishi^^^^^^");
			while(true){
				if(num>10) {
					System.out.println("��Դ������������ȴ�����������ǰΪ"+num);
					//notifyAll();
					consumerCondition.signalAll();
					try {
						//wait();
						//lock.wait();������Ǳ���
						producterCondition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else {
					num++;
					System.out.println("��ǰ��Դ��"+num);
				
					
				}
				
				
				
				
			}
		}finally {
			lock.unlock();
		}*/
		
	}
	
	/*synchronized*/ int  remove()  {
		while(true) {
		try {
			System.out.println(Thread.currentThread().getName()+"������ִ��"+resourceQueue.size());
			resourceQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//return resourceQueue.size();
		/*try {
			
			lock.lock();
			System.out.println("kaishi^^");
			while(true) {
				if(num<1) {
					System.out.println("û����Դ����Ҫ�ȴ�����������ǰΪ"+num);
					//notifyAll();
					
					producterCondition.signalAll();
					try {
						consumerCondition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					num--;
					System.out.println("��ǰ��Դ��"+num);
					
					
				}
				
				
				
			}
		}finally {
			lock.unlock();
		}*/
		
		
		}
		
		
}
