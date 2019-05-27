package blockingQueue;

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
	//如果要开很多线程进行的话，一个blockingQueue（定制是10）只能完成10个线程的加1，后续再加就阻塞了，其他线程都堵在这个方法那里！
	//假如放入的是请求的线程的话，其实也可以看成是消息队列，只能放入10个线程，当不满足10个或者没有的时候，在让其他线程进来，
	//如果需要严格有序，按照开始定义的那样，就直接使用join，注意：：但是join是必须等待线程执行完毕，如果阻塞了的话，就会一直等待，主线程也停止了，注意！
	//实现异步处理，进入队列后，返回结果是订单处理，线程完毕，但是后台还在处理！
	//线程池和blockingQneue之间的关系：在new一个线程池的时候，需要传入一种blockingQueue，底层需要什么队列结构存放线程！！！
	/*synchronized*/ @SuppressWarnings("unchecked")
	int  add ()  {
		while(true) {
		try {
			
			System.out.println(Thread.currentThread().getName()+"生产者执行"+resourceQueue.size());
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
					System.out.println("资源数已满，进入等待…………当前为"+num);
					//notifyAll();
					consumerCondition.signalAll();
					try {
						//wait();
						//lock.wait();这个还是报错
						producterCondition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else {
					num++;
					System.out.println("当前资源数"+num);
				
					
				}
				
				
				
				
			}
		}finally {
			lock.unlock();
		}*/
		
	}
	
	/*synchronized*/ int  remove()  {
		while(true) {
		try {
			System.out.println(Thread.currentThread().getName()+"消费者执行"+resourceQueue.size());
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
					System.out.println("没有资源。需要等待…………当前为"+num);
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
					System.out.println("当前资源数"+num);
					
					
				}
				
				
				
			}
		}finally {
			lock.unlock();
		}*/
		
		
		}
		
		
}
