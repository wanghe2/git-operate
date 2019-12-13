package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import bean.Address;
import bean.MyRunable;
import bean.User;
import map.CollectionTest;
import thread.Consumer;
import thread.ConsumerNEW;
import thread.Producer;
import thread.ProducerNEW;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Main main = new Main();
		main.fun15();
	}

	public static void fun0() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new MyRunable());
		}
	}

	public static void fun1() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		/**
		 * 延时执行
		 */
		scheduledExecutorService.schedule(new MyRunable(), 10, TimeUnit.SECONDS);
	}

	public static void fun2() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		/**
		 * 定时器
		 */
		scheduledExecutorService.scheduleWithFixedDelay(new MyRunable(), 5, 3, TimeUnit.SECONDS);
	}

	public void fun3() {
		fun4();
	}

	/**
	 * 模拟递归死循环
	 */
	public void fun4() {
		fun3();
	}

	public void fun5() {
		for (int i = 0; i < 10; i++) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "*");
			System.out.println(uuid);
		}
	}

	public void fun6() {
		CollectionTest.fun3();
	}

	/**
	 * 线程队列
	 */
	public void fun7() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Queue<String> appleQueue = new LinkedBlockingQueue<>(CollectionTest.MAX_SIZE);
		Producer producer1 = new Producer(appleQueue, "生产者1");
		Producer producer2 = new Producer(appleQueue, "生产者2");
		Consumer consumer1 = new Consumer(appleQueue, "消费者1");
		Consumer consumer2 = new Consumer(appleQueue, "消费者2");
		Consumer consumer3 = new Consumer(appleQueue, "消费者3");
		executorService.execute(producer1);
		executorService.execute(producer2);
		executorService.execute(consumer1);
		executorService.execute(consumer2);
		executorService.execute(consumer3);
	}

	public void fun8() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		BlockingQueue<String> appleQueue = new LinkedBlockingQueue<>(CollectionTest.MAX_SIZE);
		ProducerNEW producer1 = new ProducerNEW(appleQueue, "生产者1");
		ConsumerNEW consumer1 = new ConsumerNEW(appleQueue, "消费者1");
		ConsumerNEW consumer2 = new ConsumerNEW(appleQueue, "消费者2");
		ConsumerNEW consumer3 = new ConsumerNEW(appleQueue, "消费者3");
		executorService.execute(producer1);
		executorService.execute(consumer1);
		executorService.execute(consumer2);
		executorService.execute(consumer3);
	}

	@SuppressWarnings("unused")
	public void fun9() {
		ArrayList<String> arrayList;
		LinkedList<String> linkedList;
		HashSet<String> hashSet = new HashSet<String>();
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		TreeSet<String> treeSet = new TreeSet<String>();
		Vector<String> vector = new Vector<String>();
		treeSet.add("a");
		treeSet.add("b");
		treeSet.add("e");
		treeSet.add("dsh");
		treeSet.add("d");
		treeSet.add("c");
		treeSet.add("h");
		for (String tree : treeSet) {
			System.err.print(" " + tree);
			System.out.print(" docker ");
		}
	}

	public void fun10() {
		int i = 2;
		i = i << 4;
		System.err.println("数值" + i);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		Map<String, Object> map = new Hashtable<String, Object>();
		map.put("name", "wanghe");
		map.put("age", "25岁");
		map.put("habbit", "跑步");
		Set<Entry<String, Object>> entries = map.entrySet();
		Set<String> keys = map.keySet();
		for (Entry<String, Object> entry : entries) {
			System.err.println(entry.getKey() + "	:	" + entry.getValue());
		}
		for (String key : keys) {
			System.err.println(key + " ");
		}
		hashMap.get("good");
	}

	public void fun11() {
		User user = new User();
		user.setName("good");
		user.setAddress(new Address("厦门"));
		User user2 = null;
		User user3 = null;
		try {
			user2 = (User) user.clone();// 浅拷贝
			user3 = user.highClone();// 深拷贝
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.err.println("  " + user + " -- " + user.hashCode());
		System.err.println("  " + user2 + " -- " + user2.hashCode());
		System.err.println("user2的地址---" + user2.getName());
		user.setName("bad");
		System.err.println("  重新赋值的user1-name---" + user.getName());
		System.err.println("  重新赋值的user2-name---" + user2.getName());
		user.getAddress().setAddress("黄山");
		System.err.println("  重新赋值的user1-address---" + user.getAddress().getAddress());
		System.err.println("  重新赋值的user2-address---" + user2.getAddress().getAddress());
		System.err.println("  重新赋值的user3-address---" + user3.getAddress().getAddress());

	}

	public void fun12() throws InterruptedException, ExecutionException {

		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Integer total = 0;
				for (int i = 0; i <= 100; i++) {
					total += i;
					Thread.sleep(50);
				}
				return total;
			}
		});
		new Thread(futureTask).start();
		System.err.print("\n***********" + futureTask.get());
	}

	public void fun13() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.err.print("延时打印");
			}
		};
		Timer time = new Timer();
		time.schedule(task, 1000);
	}

	public void fun14() {
		ThreadLocal<String> local_data = new ThreadLocal<String>();
		local_data.get();
		local_data.set(" ");
		new Thread(new Runnable() {
			@Override
			public void run() {
				local_data.set("bad");
			}
		}).start();

	}

	public void fun15() throws InterruptedException {
		ThreadGroup threadGroup = new ThreadGroup("group-1");
		List<Thread> threads = new ArrayList<Thread>();

		threads.toArray();

		for (int i = 0; i < 8; i++) {
			Thread thread = new Thread(threadGroup,new Runnable() {
				@Override
				public void run() {
					try {
						for (int i = 0; i < 100000; i++) {

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "线程--" + i);
			threads.add(thread);
			thread.start();
		}
		System.err.println("活跃线程**" + threadGroup.activeCount());
		Thread.sleep(100);
		System.err.println("活跃线程**" + threadGroup.activeCount());
	}
	
	public void fun16() {
		Thread.currentThread().isInterrupted();
		Thread.currentThread().interrupt();
	}
	
	public void fun17() {
		ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();//读写锁
    	reentrantReadWriteLock.readLock();
    	
    	ReentrantLock lock=new ReentrantLock(true);//公平锁
    	lock.isLocked();
    	lock.lock();
	}
	
	

}
