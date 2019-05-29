package 其他测试.一些测试.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class consumer implements Runnable {
	resource resource = null;
	Lock lock = null;
	Condition consumerCondition = null;
	
	consumer(resource resource,Lock lock,Condition condition){
		this.resource = resource;
		this.consumerCondition = condition;
		this.lock = lock;
	}
//
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//synchronized (resource) {
		try {
			System.out.println(Thread.currentThread().getName()+"�����߿�ʼִ�С�������");
			resource.remove();
			System.out.println(Thread.currentThread().getName()+"����������-1 ��������");
		}finally {
			//lock.unlock();
		}
			
		//}
		
	}
	//��ʹ�ó��������磬����߳̽��ж��������Ҫһ����ͣ��ʱ��Ȼ��ʹ��һ��volatile���εı�־λ��ÿ���̶߳��ɼ�������ʵ�ֺܿ��ֹͣ��
//	һ���·����Ҳ���ǲ���Ҫ����ͬ���Լ���ǿ������������ֵ����⣬�̲߳���ȫ����Ҫÿ���߳̿ɼ��ͺ��ˣ���Ϊ�жϵı�ʶλ�ȽϺã�
	//�����ʺ���һЩ�����Ե�д����,û���壬��Ϊ��д�Ĺ��̲�����ԭ���Եģ��̲߳���ȫ�������������
	
	

}
