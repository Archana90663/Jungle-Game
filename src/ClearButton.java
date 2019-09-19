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


