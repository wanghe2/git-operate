package lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private ReentrantLock reentrantLock;
	
	private Double amount;
	
	private Semaphore semaphore;
	
	private  ReadWriteLock readWriteLock;
	
	public void test() {
		reentrantLock.lock();
		synchronized (amount) {

		}
		reentrantLock.tryLock();
		
	}
	
	public ReentrantLock getReentrantLock() {
		return reentrantLock;
	}
	public void setReentrantLock(ReentrantLock reentrantLock) {
		this.reentrantLock = reentrantLock;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	public Semaphore getSemaphore() {
		return semaphore;
	}
	
	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	public void setReadWriteLock(ReadWriteLock readWriteLock) {
		this.readWriteLock = readWriteLock;
	}
	
	
	
}
