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

/**
 * @author SaiRahulReddyKondlapudi
 * @Description This is the class for Student Objects
 *
 */
public class Student {

  private int x; // represents the x coordinate for finding the location
  private int y; // represents the y coordinate for representing the location
  private int id;// represents the unique number alloted to the students

  /**
   * This is a constructor for the student object which takes in 3 arguments
   * 
   * @param x- represents the x coordinate for finding the location
   * @param y- represents the y coordinate for finding the location
   * @param id - represents the unique number alloted to the students
   */
  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  /**
   * The method used to retrieve the value in the x field.
   * 
   * @return the value in y
   */
  public int getX() {
    return x;
  }

  /**
   * The method used to retrieve the value in the y field.
   * 
   * @return the value in x
   */
  public int getY() {
    return y;
  }

  /**
   * The method used to retrieve the value in the id field.
   * 
   * @return the value in id
   */
  public int getId() {
    return id;
  }

  /**
   * It is a method to represent the student object fields in terms of string.
   */
  @Override
  public String toString() {
    String s = id + "(" + x + "," + y + ")";
    return s;
  }
}
