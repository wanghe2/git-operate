package lock;
/**
 * 不可重入锁，也叫自旋锁
 * @author wanghe
 *
 */
public class LockOne {
	
	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked){    
			wait();
		 }
	   isLocked = true;
	}
	
	public synchronized void unlock(){
       isLocked = false;
       notify();
	}
	
	
}
