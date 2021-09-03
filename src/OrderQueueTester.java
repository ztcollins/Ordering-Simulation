//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Order Up!
// Course: CS 300 Spring 2021
//
// Author: Zachary Collins
// Email: ztcollins@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: -
// Online Sources: -
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * unit testing class. As before,your tester methods should be static boolean
 * methods with no parameters.
 * 
 * @author Zach C
 *
 */
public class OrderQueueTester {

  /**
   * Calls your runAllTests() method
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    runAllTests();
    //test2();
  }
  
  
  /**
   * Returns true if and only if all test methods succeed;false otherwise.
   * At least four test methods of own design.
   * 
   * @return
   */
  public static boolean runAllTests() {
    try {
      if(test1() != true) {
        return false;
      }
      System.out.println("NOTICE: TEST 1 PASSED.");
      if(test2() != true) {
        return false;
      }
      System.out.println("NOTICE: TEST 2 PASSED.");
      if(test3() != true) {
        return false;
      }
      System.out.println("NOTICE: TEST 3 PASSED.");
      if(test4() != true) {
        return false;
      }
      System.out.println("NOTICE: TEST 4 PASSED.");
      //System.out.println("test");
      System.out.println("NOTICE: ALL TESTS PASSED.");
      return true;
    }
    catch (NoSuchElementException e) {
      System.out.println("ERROR: NO SUCH ELEMENT EXCEPTION THROWN.");
      return false;
    }
  }
  
  
  /**
   * tester method that checks whether OrderIterator class is performing correctly
   * 
   * @return boolean - true/false if performing correctly
   */
  public static boolean test1() {
    Order.resetIDGenerator();
    
    Order o1 = new Order("chicken", 15);
    Order o2 = new Order("Spaghetti", 30);
    
    LinkedOrder l1 = new LinkedOrder(o1);
    LinkedOrder l2 = new LinkedOrder(o2);
    
    l1.setNext(l2);
    
    OrderIterator iterator = new OrderIterator(l1);
    OrderIterator iterator2 = new OrderIterator(l2);
    
    //System.out.println(iterator.hasNext());
    //System.out.println(iterator2.hasNext());
    //System.out.println(iterator.next());
    if(iterator.hasNext() != true) {
      return false;
    }
    if(iterator2.hasNext() != true) {
      System.out.println("ERROR: TEST 1 FAILED.");
      return false;
    }
    
    return true;
    
  }
  
  
  /**
   * tester method that checks whether OrderIterator class is performing correctly
   * 
   * @return boolean - true/false if performing correctly
   */
  public static boolean test2() {
    Order.resetIDGenerator();
    
    Order o1 = new Order("chicken", 15);
    Order o2 = new Order("Spaghetti", 30);
    Order o3 = new Order("noodles", 5);
    
    OrderQueue q1 = new OrderQueue();
    
    q1.enqueue(o1);
    q1.enqueue(o2);
    q1.enqueue(o3);
    
    if(!q1.toString().equals("1001: chicken (15) -> 1002: Spaghetti (30) -> 1003: noodles (5) -> END")) {
      System.out.println("ERROR: TEST 2 FAILED.");
      return false;
    }
    
    //System.out.println(q1.toString());
    return true;
    
  }
  
  
  /**
   * tester method that checks whether OrderIterator class is performing correctly
   * 
   * @return boolean - true/false if performing correctly
   */
  public static boolean test3() {
 Order.resetIDGenerator();
    
    Order o1 = new Order("chicken", 15);
    Order o2 = new Order("Spaghetti", 30);
    Order o3 = new Order("noodles", 5);
    
    OrderQueue q1 = new OrderQueue();
    
    q1.enqueue(o1);
    q1.enqueue(o2);
    q1.enqueue(o3);
    q1.dequeue();
    
    if(!q1.toString().equals("1002: Spaghetti (30) -> 1003: noodles (5) -> END")) {
      System.out.println("ERROR: TEST 3 FAILED.");
      return false;
    }
    //System.out.println(q1.toString());
    return true;
    
    
  }
  
  
  /**
   * tester method that checks whether OrderIterator class is performing correctly
   * 
   * @return boolean - true/false if performing correctly
   */
  public static boolean test4() {
 Order.resetIDGenerator();
    
    Order o1 = new Order("chicken", 15);
    Order o2 = new Order("Spaghetti", 30);
    Order o3 = new Order("noodles", 5);
    
    
    OrderQueue q1 = new OrderQueue();
    
    q1.enqueue(o1);
    q1.enqueue(o2);
    q1.enqueue(o3);
    q1.dequeue();
    q1.dequeue();
    q1.dequeue();
    //System.out.println(q1.toString());
    //System.out.println("bruh");
    
    if(!q1.toString().equals("")) {
      System.out.println("ERROR: TEST 4 FAILED.");
      return false;
    }
    
    //System.out.println(q1.toString());
    return true;
    
    
  }

}
