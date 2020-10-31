
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
 * @Description This is the class for the Delivery Objects
 *
 */
public class Delivery implements Comparable<Delivery> {

  private int studentId; // the unique id alloted to the students
  private String robotName; // the name of the FoodRobot
  private int distance; // the Manhattan distance between student and the robot.

  /**
   * This is the constructor for Delivery class which takes in Student and FoodRobot
   * 
   * @param student - takes in a Student object
   * @param robot   - takes in a robot object
   */
  public Delivery(Student student, FoodRobot robot) {
    this.studentId = student.getId();
    this.robotName = robot.getName();
    this.distance =
            Math.abs(student.getX() - robot.getX()) + Math.abs(student.getY() - robot.getY());
  }

  /**
   * The method returns a negative number whenever the object that it is called on has a higher
   * priority than the object passed as an argument. When the argument passed has a higher priority
   * than the object that this method is called on, the method returns a positive number.
   */
  @Override
  public int compareTo(Delivery obj) {

    if (this.distance < obj.distance) { // comparing the distance of the two objects
      return -1;
    } else if (this.distance > obj.distance) {
      return 1;
    }
    if (this.distance == obj.distance) {
      if (this.studentId < obj.studentId) {
        return -1;
      } else if (this.studentId > obj.studentId) { // comparing the studentId of the two objects
        return 1;
      }
    }
    if (this.studentId == obj.studentId) {
      if (this.robotName.compareTo(obj.robotName) < 0) { // comparing the robotNames of the objects
        return this.robotName.compareTo(obj.robotName);
      } else if (this.robotName.compareTo(obj.robotName) > 0) {
        return this.robotName.compareTo(obj.robotName);
      }
    }
    return 0;
  }

  /**
   * When this method is called on a Delivery object the method should return true under two
   * different circumstances: either the studentIds within the two delivery objects are equal, or
   * the robotNames within the two delivery objects are equal. When neither of these circumstances
   * are found, equals should return false.When this method is called on a student object the
   * Student: when comparing this Delivery object to an argument of type Student, the equals method
   * should return true only when this delivery object’s studentId is equal to the student
   * argument’s id. Otherwise it should return false.When this method is called on a FoodRobot
   * object the FoodRobot: when comparing this Delivery object to an argument of type FoodRobot, the
   * equals method should return true only when this delivery object’s robotName is equal to the
   * food robot’s name. Otherwise it should return false.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Delivery) { // checks if the given object is an instance of Delivery
      if (((Delivery) obj).studentId == this.studentId
              || ((Delivery) obj).robotName == this.robotName) {
        return true;
      } else {
        return false;
      }
    }
    if (obj instanceof Student) { // checks if the given object is an instance of Student
      if (this.studentId == ((Student) obj).getId()) {
        return true;
      } else {
        return false;
      }
    }
    if (obj instanceof FoodRobot) { // checks if the given object is an instance of FoodRobot
      if (this.robotName == ((FoodRobot) obj).getName()) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

  /**
   * Gives the String representation of the fields in this class.
   */
  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }
}
