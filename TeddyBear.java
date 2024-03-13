import processing.core.PApplet;

/**
 * This class represents a teddy bear in the toy saga game. It extends the Toy class and adds a
 * callout and rotation
 */
public class TeddyBear extends Toy {
  /**
   * Callout object that represents the callout of the teddy bear
   */
  private Callout callout;

  /**
   * Rotation of the teddy bear
   */
  private float rotation;

  /**
   * Direction of the rotation of the teddy bear
   */
  private boolean rotationDirection;

  /**
   * Constructs a new TeddyBear object with a specific x and y position
   * 
   * @param x x-position of the center of the teddy bear
   * @param y y-position of the center of the teddy bear
   */
  public TeddyBear(int x, int y) {
    super(ToySaga.BEAR, x, y);
    callout = new Callout(x, y);
    rotation = 0; // Initializes the rotation of the teddy bear
    rotationDirection = true; // Initializes the rotation direction of the teddy bear
  }

  /**
   * Draws the teddy bear on the screen
   * 
   * @return the rotation of the teddy bear
   */
  public float getRotation() {
    return rotation;
  }

  /**
   * Sets the rotation of the teddy bear
   * 
   * @param rotation new rotation of the teddy bear
   */
  public void setRotation(float rotation) {
    this.rotation = rotation;
  }

  /**
   * Sets the rotation direction of the teddy bear
   * 
   * @param direction new rotation direction of the teddy bear
   */
  public void setRotationDirection(boolean direction) {
    rotationDirection = direction;
  }

  /**
   * Returns the rotation direction of the teddy bear
   */
  public boolean getRotationDirection() {
    return rotationDirection;
  }

  /**
   * Draws the teddy bear on the screen
   */
  @Override
  public void draw() {
    if (toySaga.isNightMode()) {
      drawTeddyBearNightMode();
    } else {
      super.draw();
    }
  }

  /**
   * Draws the teddy bear on the screen in night mode
   */
  public void drawTeddyBearNightMode() {

    this.move();
    toySaga.pushMatrix();
    toySaga.translate(x, y);
    toySaga.rotate(rotation * PApplet.PI / 2);
    if (toySaga.getMode() == "NIGHT") {
      toySaga.image(callout.image, 20f, -90f);
    }
    toySaga.image(image, 0.0f, 0.0f);
    toySaga.popMatrix();
  }

  /**
   * Moves the teddy bear to the current mouse position
   */
  @Override
  public void move() {
    if (!toySaga.isNightMode()) {
      super.move();
    } else {
      if (rotation >= PApplet.radians(30)) { // If the rotation is greater than 30 degrees
        setRotationDirection(false); // Sets the rotation direction to false
      } else if (rotation <= PApplet.radians(-30)) { // If the rotation is less than -30 degrees
        setRotationDirection(true); // Sets the rotation direction to true
      }
      if (rotationDirection) { // If the rotation direction is true
        rotation = getRotation() + PApplet.radians(3); // Increases the rotation of the teddy bear
      } else {
        rotation = getRotation() - PApplet.radians(3);
      } // Decreases the rotation of the teddy bear
    }
  }
}
