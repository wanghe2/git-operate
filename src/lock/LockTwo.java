package lock;
/**
 * 可重入锁
 * @author wanghe
 *
 */
public class LockTwo {
    boolean isLocked = false;
    Thread  lockedBy = null;
    int lockedCount = 0;
    
    public synchronized void lock() throws InterruptedException{
        Thread callingThread = Thread.currentThread();
        while(isLocked && lockedBy != callingThread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }
    
    
    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

}
