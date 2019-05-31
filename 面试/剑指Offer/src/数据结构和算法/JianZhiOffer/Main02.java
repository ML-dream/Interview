package 数据结构和算法.JianZhiOffer;
/*
 * LinkedBlockingQueue
 */
public class Main02{
	
	public static int num ;
	public static void main(String[] args) throws Exception {
		threadTest threadTest = new threadTest(new Main02());
		for(int i=0;i<2;i++) {
			new Thread(threadTest,i+"").start();
			Thread.sleep(100);
		}
	}
}


class threadTest implements Runnable{
	int num ;
	public threadTest(Main02 main02) {
		num =main02.num;
	}
	public void run() {
		
			for(int i=0;i<10;i++) {
		
				new Main02().num=i;	
			
				System.out.println(new Main02().num);
			
		}
		
	}
}