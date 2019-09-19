/**
 * This class represents a Tiger in the JunglePark application
 *
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
  // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
  // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far


  /**
   * Creates a new Tiger object positioned at a random position of the display window
   *
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
    deerEatenCount = 0;
  }


  /**
   * Tiger's behavior in the Jungle Park Scans for food at the neighborhood of the current tiger. If
   * the Tiger founds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {
    // TO DO scan for food (aka deer) and hop on it if any.
    boolean isClose = false;
    for (int i = 0; i < processing.listGUI.size(); i++) {
      if (processing.listGUI.get(i) instanceof Deer) {
        isClose = isClose((Deer) processing.listGUI.get(i), SCAN_RANGE);
        if (isClose) {
          hop((Deer) processing.listGUI.get(i));
        }
      }
    }
    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }

  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }

  /**
   * Displays the number of deers the tiger has eaten
   *
   * @return deerEatenCount the number of deers eaten by the tiger
   */
  public int getDeerEatenCount() {
    return deerEatenCount;
  }

  /**
   * Tiger hops on the deer if it is close to it and replaces its position with that of the deer's
   *
   * @param food is the deer closest to the tiger
   */
  public void hop(Deer food) {
    if (isMouseOver()) {
      mouseReleased();
    }
    setPositionX(food.getPositionX());
    setPositionY(food.getPositionY());
    deerEatenCount++;
    processing.listGUI.remove(food);


  }


}
