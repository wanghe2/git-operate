package lock;


import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockInterrupt {
	    public static void main(String[] args) {
	        MyBuffer buffer = new MyBuffer();
	        
	        //开启写线程
	        final WriteThread write = new WriteThread(buffer);
	        write.start();
	        
	        //开启读线程
	        final ReadThread read = new ReadThread(buffer);
	        read.start();
	        
	        //开启第三个线程，用于监听并中断读线程
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                long readThreadMaxWaitTime = 5000;  //读线程最大等待时间，单位：毫秒
	                long startTime = System.currentTimeMillis();
	                while(System.currentTimeMillis()-startTime<readThreadMaxWaitTime){}
	                System.out.println("读线程等待时间已超过"+readThreadMaxWaitTime/1000+"秒，请求中断....");
	                read.interrupt();
	            }
	        }).start();
	    }
	}

	class WriteThread extends Thread{
	    private MyBuffer buffer;
	    public WriteThread(MyBuffer buffer){
	        this.buffer = buffer;
	    }
	    @Override
	    public void run() {
	        buffer.write();
	    }
	}

	class ReadThread extends Thread{
	    private MyBuffer buffer;
	    public ReadThread(MyBuffer buffer) {
	        this.buffer = buffer;
	    }
	    @Override
	    public void run() {
	        try {
	            buffer.read();
	        } catch (InterruptedException e) {
	            System.out.println("读线程已经被中断.....");
	        }
	    }
	}

	class MyBuffer {
	    //使用ReentrantLock锁
	    private ReentrantLock lock = new ReentrantLock();
	    
	    //写操作
	    public void write(){
	        //lock操作必须放在此处，放于try内就会报错，为什么？？？
	        lock.lock();
	        try {
	            long writeNeedTime = 10000;  //写操作需要时间，单位：毫秒
	            long writeStartTime = System.currentTimeMillis();
	            System.out.println("写操作开始，预计执行时间："+writeNeedTime/1000+"秒....");
	            while(System.currentTimeMillis()-writeStartTime<writeNeedTime){}
	            System.out.println("写操作完成....");
	        } finally {
	            lock.unlock();
	        }
	    }
	    
	    //读操作
	    public void read() throws InterruptedException {
	        //lock()方法设置锁机制为“忽略中断锁”，当调用此方法的线程自身或被其他线程请求中断(interrupt)时，操作线程不响应请求，继续处于等待状态
	        //lockInterruptibly()方法可设置锁机制为“相应式中断锁”，当调用此方法的线程自身或被其他线程请求中断(interrupt)时，线程会相应请求，并在调用当前方法的操作时中断线程，中断后不操作线程后续任务
	        //以上的响应指的是线程正在获取锁的过程中被请求中断，若线程在其他非阻塞与阻塞状态时被请求中断，lockInterruptibly()是无法响应中断的，
	        //非阻塞状态可根据中断标记位Thread.currentThread().isInterrupted()，阻塞状态可通过抛出异常InterruptedException来中断线程
	        //详细可以参考http://www.cnblogs.com/hanganglin/articles/3517178.html中的Thread.interrupt资料
	        lock.lockInterruptibly();
	        try {
	            System.out.println("读操作完成....");
	        } finally {
	            lock.unlock();
	           
	        }
	    }
	    
	    
}

