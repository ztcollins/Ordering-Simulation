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
 * OrderIterator is a straightforward iterator object.
 * 
 * @author Zach C
 *
 */
public class OrderIterator implements Iterator<Order> {
  private LinkedOrder current; // the linked order that it's currently using

  /**
   * Constructor, initializes current to the provided starting LinkedOrder. Does not care whether
   * the argument value is null.
   * 
   * @param start
   */
  public OrderIterator(LinkedOrder start) {
    current = start;
  }


  /**
   * Returns true if and only if the iteration has more orders
   */
  @Override
  public boolean hasNext() {
    if (current != null) {
      return true;
    }
    return false;
  }


  /**
   * Throws a NoSuchElementException with a descriptive error message if the iteration does not have
   * more orders to return. Otherwise returns the next Order and updates the current field
   * appropriately.
   */
  @Override
  public Order next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("The iterator has no more orders to return!");
    }
    Order thisOrder = current.getOrder();
    current = current.getNext();
    return thisOrder;
  }

}
