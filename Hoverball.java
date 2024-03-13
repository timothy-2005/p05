import processing.core.PApplet;

/**
 * This class represents a hoverball in the toy saga game. It extends the Toy class and adds a
 * switch on/off and movement
 */
public class Hoverball extends Toy {

  /**
   * Constructs a new Hoverball object with a specific x and y position
   * 
   * @param x x-position of the center of the hoverball
   * @param y y-position of the center of the hoverball
   */
  public Hoverball(int x, int y) {
    super(ToySaga.HOVERBALL_OFF, x, y);
  }

  /**
   * Switches the hoverball on or off
   */
  private void switchOnOff() {
    if (toySaga.isNightMode()) {
      setImage(ToySaga.HOVERBALL_ON);
    } else {
      setImage(ToySaga.HOVERBALL_OFF);
    }
  }

  /**
   * Draws the hoverball on the screen
   */
  @Override
  public void draw() {
    switchOnOff();
    super.draw();
  }

  /**
   * Moves the hoverball on the screen
   */
  @Override
  public void move() {
    if (!toySaga.isNightMode()) {
      super.move();
    } else {
      move(0, Math.round(6 * PApplet.sin(toySaga.frameCount * 0.1f))); // Moves the hoverball up and
                                                                       // down
    }
  }
}
