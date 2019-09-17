//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park
// Files: JunglePark.java
// Course: CS 300, Fall 2018
//
// Author: Archana Dhyani
// Email: adhyani@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////

/**
 *
 * This class represents a Deer in the JunglePark application
 *
 */
public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
  // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
  // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  /**
   * Constructor that creates a new Deer object positioned at a random position of the display
   * window
   *
   * @param processing contains the list of all animal objects
   */
  public Deer(JunglePark processing) {
    super(processing, IMAGE_FILE_NAME);
    id = nextID;
    this.label = TYPE + id;
    nextID++;
  }

  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   *
   * @param scanRange is an integer that represents the range of the area to be scanned around the
   *        animal
   * @return true or false depending on whether the tiger is within the scanRange
   */
  public boolean scanForThreat(int scanRange) {
    boolean alert = false;
    for (int i = 0; i < processing.listGUI.size(); i++) {
      if (processing.listGUI.get(i) instanceof Tiger) {
        alert = isClose((Tiger) processing.listGUI.get(i), scanRange);
        return alert;
      }
    }
    return alert;
  }


  /**
   * Defines the behavior of a Deer object in the Jungle park
   */
  @Override
  public void action() {
    boolean alert = scanForThreat(SCAN_RANGE);
    if (alert == true) {
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(),
          this.getPositionY() - this.image.height / 2 - 4);
    }

  }
}
