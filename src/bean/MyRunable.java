package bean;

public class MyRunable implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(1500);
			System.err.println("**打印***--"+Thread.currentThread().getName()+"******");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
