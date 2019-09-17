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
 * This class represents the AddAnimalButton that adds animals to the JunglePark.
 *
 */
public class AddAnimalButton extends Button {
  private String type; // type of the animal to add

  /**
   * This constructor creates buttons to add animals within JunglePark
   *
   * @param type is a String that determines whether the animal to be added is a tiger or deer
   * @param x is an int that signifies the x-position of the button
   * @param y is an int that signifies the y-position of the button
   * @param park is the JunglePark to be added to
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park);
    this.type = type.toLowerCase();
    this.label = "Add " + type;
  }

  /**
   * Checks if the mouse is pressed over the AddAnimalButton. If so then it should add the
   * corresponding animal
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          this.processing.listGUI.add(new Tiger(this.processing));
          break;
        case "deer":
          this.processing.listGUI.add(new Deer(this.processing));
          break;
      }
    }
  }
}
