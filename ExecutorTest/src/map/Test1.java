package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class Test1{

  private String name;

  public Test1(String name) {
    this.name = name;
  }
  public static void main(String[] args) {
    Test1 test1=new Test1("");
    test1.fun4();
  }
	  
  @SuppressWarnings("unused")
public void fun6() {
	Queue<String> priorityQueue=new PriorityQueue<String>();
  }
  
  
  @SuppressWarnings("unused")
  public void fun5() {
	  ConcurrentHashMap<String,Object>concurrentHashMap;
	  ArrayList<String>arrayList;
	  CopyOnWriteArrayList<String>copyOnWriteArrayList;
	  
  }
  
  
  public void fun4() {//测试fast-fail
	  List<String>list=new ArrayList<String>();
	  list.add("a");
	  list.add("a");
	  list.add("b");
	  list.add("c");
	  list.add("c");
	  list.add("c");
	  for(String obj:list) {
		  if(obj.equals("a")) {
			  System.err.print("--");
			  list.remove(obj);
		  }
	  }
  }
  
  
  public void fun3() {
	  Test1 test1=new Test1("hello");
	  Test1 test2=new Test1("hello");
	  Map<Test1, String> map = new HashMap<Test1, String>(4);
	  map.put(test1, "hello");
	  String hello = map.get(test2);
	  System.out.println(hello);
  }
  
  public void fun2() {
	  Test1 test1=new Test1("hello");
	  Test1 test2=new Test1("hello");
	  System.err.print(test1.hashCode()+" vs "+test2.hashCode());
  }
  
  
  public void fun1() {
	  Map<Test1, String> map = new HashMap<Test1, String>(4);
	  map.put(new Test1("hello"), "hello");
	  String hello = map.get(new Test1("hello"));
	  System.out.println(hello);
  }
  
  
  @Override
  public int hashCode() {
	  return name.hashCode();
  }
  
  @Override
  public boolean equals(Object obj) {
	Test1 test1=(Test1)obj;
	if(obj==null) {
		return false;
	}
	if(this.name==null&&test1.getName()==null) {
		return true;
	}
	if(this.name.equals(test1.getName())) {
		return true;
	}
	return false;  
  }
  
  public String getName() {
	  return name;
  }
  
  
}