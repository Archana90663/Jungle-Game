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
 * This class represents the ClearButton that clears up all the animals in the JunglePark
 *
 */
public class ClearButton extends Button {
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park);
    this.label = "Clear Park";
  }

  /**
   * Checks to see if the mouse is pressed over the ClearButton. If so, then it should clear all the
   * animals within JunglePark
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      for (int i = 0; i < this.processing.listGUI.size(); i++) {
        if (this.processing.listGUI.get(i) instanceof Animal) {
          this.processing.listGUI.remove(i);
          i--;
        }
      }
    }
  }
}


