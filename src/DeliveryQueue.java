//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: Student.java,FoodRobot.java,Delivery.java,DeliveryQueue.java,
// DeliveryQueueTester.java,DeliverySchedulingApp.java
// Course: (CS 300, Spring, and 2020)
//
// Author: Sai Rahul Reddy Kondlapudi
// Email: kondlapudi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author SaiRahulReddyKondlapudi
 * @Description This is the class for the Delivery Queue implementation
 *
 */
public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the array
  private Delivery[] heap; // the array to hold the values
  private int size; // to keep track of the number of elements in the array

  /**
   * The constructor for the DeliveryQueue which initializes the objects fields.
   */
  public DeliveryQueue() {
    heap = new Delivery[INITIAL_CAPACITY]; // Initializing with the given INITIAL_CAPACITY
    size = 0;
  }

  /**
   * this method adds a new delivery to this priority queue. If the heap is already at capacity when
   * this method is called, it should first create a new larger capacity array (twice the previous
   * heap capacity), copy the old arrays contents into this larger array, and then use this array as
   * the heap going forward
   * 
   * @param obj - takes in a Delivery object
   */
  public void offerDelivery(Delivery obj) {
    if (size == 0) {
      heap[0] = obj;
    } else if (size < heap.length) {
      heap[size] = obj;
      percolateUp(size);
    } else if (size == heap.length) {
      Delivery[] newHeap = Arrays.copyOf(heap, size * 2);// copying the existing elements into a new
      heap = newHeap; // array with twice the size
      heap[size] = obj;
      percolateUp(size);
    }
    size++;
  }

  /**
   * This method recursively propagates heap order to prevent the violations up the heap
   * 
   * @param index - takes in an index to propagate the heap
   */
  private void percolateUp(int index) {
    if (index != 0) {
      int parentIndex = getParent(index);
      if (heap[index].compareTo(heap[parentIndex]) >= 0) {
        return;
      } else {
        swap(index, parentIndex); // swapping the two elements in the array
        percolateUp(parentIndex);
      }
    }


  }

  /**
   * Thus method removes and returns the highest priority delivery object from this priority queue,
   * and also removes all other delivery objects that have equal priority with the that has highest
   * priority one.If the heap is empty, then this method throws a NoSuchElementException with the
   * message: “Warning: Empty Heap!”
   * 
   * @return
   */
  public Delivery pollBestDelivery() {
    if (size == 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    Delivery item = heap[0];
    heap[0] = heap[size - 1];
    heap[size - 1] = null;
    size--;
    percolateDown(0);
    for (int i = 0; i < size; i++) {
      if (item.equals(heap[i])) { // checking the equality of the two elements in the array
        heap[i] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        i--;
      }
    }
    heapify();
    return item;
  }

  /**
   * This method recursively propagates heap order to prevent the violations down the heap
   * 
   * @param index - takes in an index to propagate the heap
   */
  private void percolateDown(int index) {
    int smallerChildIndex = index;
    if (getLeftChild(index) < size
            && heap[smallerChildIndex].compareTo(heap[getLeftChild(index)]) > 0) {
      smallerChildIndex = getLeftChild(index);
    }
    if (getRightChild(index) < size
            && heap[smallerChildIndex].compareTo(heap[getRightChild(index)]) > 0) {
      smallerChildIndex = getRightChild(index);
    }
    if (smallerChildIndex != index) {
      swap(smallerChildIndex, index);
      percolateDown(smallerChildIndex);
    }

  }

  /**
   * This method returns the highest priority delivery without removing it. If the heap is empty,
   * then this method should throw a NoSuchElementException with the message “Warning: Empty Heap!”
   * 
   * @return the highest priority delivery
   */
  public Delivery peek() {

    if (size == 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    } else {
      return heap[0]; // returning the highest priority index in the array
    }
  }

  /**
   * This method returns the number of objects presently in the queue
   * 
   * @return the size field
   */
  public int getSize() {
    return size; // returns the size field
  }

  /**
   * This method checks if the the queue is empty or not.
   *
   * @return true of the queue is empty else false
   */
  public boolean isEmpty() {
    if (heap == null) { // checking if the array is empty
      return true;
    }
    return false;
  }


  /**
   * This method is responsible for eliminating all the heap order violations in the array
   */
  private void heapify() {
    for (int i = size / 2; i >= 0; i--) {
      percolateDown(i); // removing all the heap order violations
    }
  }

  /**
   * This is a helper method to retrieve the index of the left child index provided its parent index
   * 
   * @param index - the index of the respective parent
   * @return the index of the left child
   */
  private int getLeftChild(int index) {
    return 2 * index + 1; // calculating the left child
  }

  /**
   * This is a helper method to retrieve the index of the right child index provided its parent
   * index
   * 
   * @param index - the index of the respective parent
   * @return the index of the right child
   */
  private int getRightChild(int index) {
    return 2 * index + 2; // calculating the right child
  }

  /**
   * This is a helper method to retrieve the index of the parent
   * 
   * @param index provide the index to find its parent
   * @return the index of the parent
   */
  private int getParent(int index) {
    return (index - 1) / 2; // calculating the parent
  }

  /**
   * This is a helper method to swap the two items in the array
   * 
   * @param indexA - the first item to be swapped
   * @param indexB - the second item to be swapped
   */
  private void swap(int indexA, int indexB) {
    Delivery temp = heap[indexA];
    heap[indexA] = heap[indexB];
    heap[indexB] = temp;
  }

  /**
   * This a method which provides a string representation of all the elements in the array.
   */
  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }

    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string; // returning the string representation of the array
  }
}