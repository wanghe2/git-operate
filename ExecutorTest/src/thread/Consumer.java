package thread;

import java.util.Queue;

public class Consumer extends Thread{
	protected Queue<String> queue;
	
	public Consumer(Queue<String> queue,String name) {
		super();
		this.queue=queue;
		setName(name);
	}
	
	@Override
	public synchronized void run() {
		while(true) {
			String cosumer=	getName();
			if(queue.size()>0) {
				String  apple=queue.poll();
				System.err.println(cosumer+"吃了"+apple+" ,吃完苹果，要歇息2秒");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				try {
					System.err.println(Thread.currentThread().getName()+"苹果没了，等3秒再吃");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
