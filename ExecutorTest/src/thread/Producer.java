package thread;

import java.util.Queue;

import map.CollectionTest;

public class Producer extends Thread{
	protected Queue<String> queue;
	public Producer(Queue<String> queue,String name) {
		super();
		this.queue=queue;
		setName(name);
	}
	
	@Override
    public  void run() {
		while(true) {
			if(queue.size()<CollectionTest.MAX_SIZE) {
				String producer= getName();
				queue.add("苹果（"+producer+"生产的）");
				System.err.println(producer+"生产了一个苹果，生产苹果后要歇息一秒");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				try {
					Thread.sleep(2000);
					System.err.print("队列满了，待会再生产");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
    }
	
}
