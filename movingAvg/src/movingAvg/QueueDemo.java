package movingAvg;

import java.util.*;
import com.google.common.collect.*;

public class QueueDemo {
  static String newLine = System.getProperty("line.separator");
  public static void main(String[] args) {
  
    System.out.println(newLine + "Queue in Java" + newLine);
    System.out.println("-----------------------" + newLine);
    System.out.println("Adding items to the Queue" + newLine);
    //Creating queue would require you to create instannce of LinkedList and assign 
    //it to Queue
    //Object. You cannot create an instance of Queue as it is abstract
    int winSize = 4;
    EvictingQueue<Integer> queue = EvictingQueue.create(winSize);
    
    int a = 1;
    int b = 2;
    
    //you add elements to queue using add method
    queue.add(a);
    queue.add(b);

    queue.add(a);
    queue.add(b);
    queue.add(a);
    
    int solution = 0;
    while(!queue.isEmpty()) {
    	solution = solution + queue.poll();
    }
  
    System.out.println(newLine + "Items in the queue..." + solution + newLine);

    //You remove element from the queue using .remove method
    //This would remove the first element added to the queue, here Java
    System.out.println("remove element: " + queue.remove() + newLine);
    
    //.element() returns the current element in the queue, here when "java" is removed
    //the next most top element is .NET, so .NET would be printed.
    System.out.println("retrieve element: " + queue.element() + newLine);
    
    //.poll() method retrieves and removes the head of this queue
    //or return null if this queue is empty. Here .NET would be printed and then would 
    //be removed
    //from the queue
    System.out.println("remove and retrieve element, null if empty: " + queue.poll() + 
    newLine);
    
    //.peek() just returns the current element in the queue, null if empty
    //Here it will print Javascript as .NET is removed above
    System.out.println("retrieve element, null is empty " + queue.peek() + newLine);
  }
}
