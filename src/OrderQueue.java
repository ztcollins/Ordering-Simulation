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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * OrderQueue is a queue type iterator object.
 * 
 * @author Zach C
 *
 */
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {
  private LinkedOrder front; // front, a reference to the LinkedOrder at the front of the queue
  private LinkedOrder back; // back, a reference to the LinkedOrder at the back of the queue
  private int size; // size, an integer variable tracking the number of Orders currently in the
                    // queue


  /**
   * Creates and returns a new OrderIterator beginning with the current value of front
   */
  @Override
  public Iterator<Order> iterator() {
    OrderIterator iterator = new OrderIterator(front);
    return iterator;
  }


  /**
   * Adds a new LinkedOrder containing newElement to the back of the queue, updating the size
   * variable and front/back references appropriately
   */
  @Override
  public void enqueue(Order newElement) {
    if (front != null) {
      back.setNext(new LinkedOrder(newElement));
      back = back.getNext();
      size++;
    } else {
      LinkedOrder link = new LinkedOrder(newElement);
      front = link;
      back = link;
      size++;
    }
  }


  /**
   * Removes the next LinkedOrder from the front of the queue and returns its Order,updating the
   * size variable and front/back references appropriately. Throws a NoSuchElementException if the
   * queue is empty.
   * 
   * @return Order - Order that is taken out
   */
  @Override
  public Order dequeue() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("ERROR: QUEUE IS EMPTY");
    }
    if (size == 1) {
      Order returnOrder = front.getOrder();
      front = null;
      back = null;
      size--;
      return returnOrder;
    }
    Order returnOrder = front.getOrder();

    front = front.getNext();

    size--;
    return returnOrder;
  }


  /**
   * Returns the Order from the LinkedOrder at the front of the queue without removing the
   * LinkedOrder from the queue. Throws a NoSuchElementException if the queue is empty.
   */
  @Override
  public Order peek() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("ERROR: QUEUE IS EMPTY");
    }
    return front.getOrder();
  }


  /**
   * Returns true if and only if the queue is empty
   */
  @Override
  public boolean isEmpty() {
    if (front != null) {
      return false;
    }
    if (back != null) {
      return false;
    }
    if (size > 0) {
      return false;
    }
    return true;
  }


  /**
   * Creates and returns a String representation of this OrderQueue using an enhanced-for loop. For
   * example, a queue with three Orders might look like this: 1001: fries (2) -> 1002: shake (1) ->
   * 1003: burger(3) -> END
   * 
   * @return A String representation of the queue
   */
  public String toString() {
    if (this.size == 0)
      return "";
    String qString = "";
    for (Order o : this) {
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }
}
