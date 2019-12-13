package thread;

import java.util.concurrent.BlockingQueue;

public class ConsumerNEW extends Thread{
	protected BlockingQueue<String> queue;
	
	public ConsumerNEW(BlockingQueue<String> queue,String name) {
		super();
		this.queue=queue;
		setName(name);
	}
	
	@Override
	public synchronized void run() {
		String cosumer=	getName();
		while(true) {
			try {
				System.err.println(cosumer+"吃了"+queue.take()+" ,吃完苹果");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
