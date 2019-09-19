/**
 * This a super class for any Button that can be added to a PApplet application This class
 * implements the ParkGUI interface
 *
 */
public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
  // the display window
  protected String label; // text/label that represents the button

  /**
   * This constructor creates the button by providing its necessary position and label.
   *
   * @param x is the x position of its location
   * @param y is the y position of its location
   * @param processing is the location as to where the button will be placed in the window.
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing;
    this.position = new float[2];
    this.position[0] = x;
    this.position[1] = y;
    this.label = "Button";
  }


  /**
   * Draws out the Button border at first and if the mouse cursor is on the button it fills it in
   * with gray else it fills it in with light gray. After that, it makes a rectangular box, fills it
   * in and displays the necessary text.
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Checks whether the user is pressing down on the button.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * Checks whether the user stopped pressing down on the button.
   */
  @Override
  public void mouseReleased() {}

  /**
   * Checks whether the mouse cursor is on the button.
   */
  @Override
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}
