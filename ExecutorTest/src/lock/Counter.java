package lock;

public class Counter {
	private LockOne lockone = new LockOne();
	private int count = 0;
	
	public int inc() throws InterruptedException{
		lockone.lock();
		this.count++;
		lockone.unlock();
		return count;
	}
	
	 public void doAdd() throws InterruptedException{
		 lockone.lock();
		 
		 lockone.unlock();
     }  	
}
