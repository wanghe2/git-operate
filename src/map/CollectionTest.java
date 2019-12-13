package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionTest {
	public static final Integer MAX_SIZE=5;
	public void fun1() {
		Map<String,String>map=new HashMap<String, String>();
		map.size();
		Vector<String>vector=new Vector<String>();
		vector.size();
		Hashtable<String, Object>hashtable=new Hashtable<>();
		hashtable.put("", "");
	}
	
	public static void fun2() {
		Stack<String>stack=new Stack<String>();
		stack.push("第一进入");
		stack.push("第二进入");
		stack.push("第三进入");
		while(stack.size()>0) {
			System.err.println("*********出站元素********"+stack.pop()+"*********");
		}
	}
	
	public static void fun3() {
		Queue<String> queue=new ArrayBlockingQueue<String>(3);
		queue.add("one");
		queue.add("two");
		queue.add("three");
		queue.add("four");
		queue.add("five");
		System.err.println("##########"+queue.size());
		queue.size();
		queue.poll();
		System.err.println("##########"+queue.size());
	}
	
}
