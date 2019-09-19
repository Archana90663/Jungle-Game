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
