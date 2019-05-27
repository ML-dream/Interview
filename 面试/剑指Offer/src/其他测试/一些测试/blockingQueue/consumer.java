package blockingQueue;

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
			System.out.println(Thread.currentThread().getName()+"消费者开始执行…………");
			resource.remove();
			System.out.println(Thread.currentThread().getName()+"消费者消费-1 …………");
		}finally {
			//lock.unlock();
		}
			
		//}
		
	}
	//、使用场景：比如，多个线程进行多个任务，需要一起暂停的时候，然后使用一个volatile修饰的标志位，每个线程都可见，可以实现很快的停止，
//	一起下发命令，也就是并不要求是同步性及其强，比如上面出现的问题，线程不安全，需要每个线程可见就好了！作为判断的标识位比较好！
	//并不适合做一些竞争性的写操作,没意义，因为读写的过程并不是原子性的！线程不安全，存在脏读现象
	
	

}
