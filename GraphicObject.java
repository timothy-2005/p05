import processing.core.PImage;

/**
 * GraphicObject is a class that represents a drawable object in the game.
 */
public class GraphicObject extends Object implements Drawable {
  /**
   * PImage object that represents the image of this object
   */
  protected PImage image;
  /**
   * ToySaga PApplet object where the button will be displayed
   */
  protected static ToySaga toySaga;
  /**
   * x-position of the center of this object
   */
  protected int x;
  /**
   * y-position of the center of this object
   */
  protected int y;

  /**
   * Constructs a new GraphicObject with a specific filename
   * 
   * @param filename name of the file that contains the image of this object
   */
  public GraphicObject(String filename) {
    image = toySaga.loadImage(filename);
    x = 400; // center of the screen
    y = 300; // center of the screen
  }

  /**
   * Constructs a new GraphicObject with a specific filename, x and y position
   * 
   * @param filename name of the file that contains the image of this object
   * @param x        x-position of the center of this object
   * @param y        y-position of the center of this object
   */
  public GraphicObject(String filename, int x, int y) {
    image = toySaga.loadImage(filename);
    this.x = x;
    this.y = y;
  }

  /**
   * Draws the object on the screen
   * 
   * @param filename name of the file that contains the image of this object
   */
  public void setImage(String filename) {
    image = toySaga.loadImage(filename);
  }

  /**
   * Moves the object to a specific x and y position
   */
  @Override
  public void draw() {
    toySaga.image(image, x, y);
  }

  /**
   * returns the x position of the object
   * 
   * @return x position of the object
   */
  public int getX() {
    return x;
  }

  /**
   * returns the y position of the object
   * 
   * @return y position of the object
   */
  public int getY() {
    return y;
  }

  /**
   * Sets the x position of the object
   * 
   * @param toySaga x position of the object
   */
  public static void setProcessing(ToySaga toySaga) {
    GraphicObject.toySaga = toySaga;
  }

}
