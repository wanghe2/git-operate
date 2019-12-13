package thread;

import java.util.concurrent.BlockingQueue;

public class ProducerNEW extends Thread{
	protected BlockingQueue<String> queue;
	public ProducerNEW(BlockingQueue<String> queue,String name) {
		super();
		this.queue=queue;
		setName(name);
	}
	
	@Override
    public synchronized void run() {
		while(true) {
			String producer= getName();
			try {
				queue.put("苹果（"+producer+"生产的）");
				System.err.println(producer+"生产了一个苹果");
		
					Thread.sleep(1000);
		
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
    }
	
}
