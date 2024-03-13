/**
 * This class represents a toy in the game. It extends the GraphicObject class and implements the
 * MouseListener and Movable interfaces.
 */
public class Toy extends GraphicObject implements MouseListener, Movable {
    /**
     * parameter that indicates if the toy is being dragged
     */
    private boolean isDragging;
  
    /**
     * Constructs a new Toy object with a specific filename
     * 
     * @param filename name of the file that contains the image of the toy
     */
    public Toy(String filename) {
      super(filename); // Calls the constructor of the superclass
      isDragging = false; // Initializes the isDragging parameter
    }
  
    /**
     * Constructs a new Toy object with a specific filename, x and y position
     * 
     * @param filename name of the file that contains the image of the toy
     * @param x        x-position of the center of the toy
     * @param y        y-position of the center of the toy
     */
    public Toy(String filename, int x, int y) {
      super(filename, x, y);
      isDragging = false;
    }
  
    /**
     * Draws the toy on the screen
     */
    @Override
    public void draw() {
      move();
      super.draw();
    }
  
    /**
     * Returns true if the toy is being dragged, false otherwise
     * 
     * @return
     */
    public boolean isDragging() {
      return isDragging;
    }
  
    /**
     * Starts dragging the toy
     */
    public void stopDragging() {
      isDragging = false;
    }
  
    /**
     * Moves the toy to the current mouse position
     */
    @Override
    public void move() {
      if (isDragging) {
        move(toySaga.mouseX - toySaga.pmouseX, toySaga.mouseY - toySaga.pmouseY);
      }
    }
  
    /**
     * Moves the toy by a specific amount in the x and y direction
     * 
     * @param dx horizontal movement
     * @param dy vertical movement
     */
    protected void move(int dx, int dy) {
      x += dx;
      y += dy;
      if (x < 0) { // If the toy is out of the screen, it is moved to the edge
        x = 0;
      } else if (x > toySaga.width) { // If the toy is out of the screen, it is moved to the edge
        x = toySaga.width;
      } else if (y < 0) { // If the toy is out of the screen, it is moved to the edge
        y = 0;
      } else if (y > toySaga.height) { // If the toy is out of the screen, it is moved to the edge
        y = toySaga.height;
      }
    }
  
    /**
     * Returns true if the mouse is over the toy, false otherwise
     * 
     * @param x x-position of the mouse
     * @param y y-position of the mouse
     * @return true if the mouse is over the toy, false otherwise
     */
    public boolean isOver(int x, int y) {
      if (x > this.x - image.width / 2 && x < this.x + image.width / 2
          && y > this.y - image.height / 2 && y < this.y + image.height / 2) { // Checks if the mouse
                                                                               // is over the toy
        return true;
      }
      return false;
    }
  
    /**
     * Starts dragging the toy
     */
    public void startDragging() {
      isDragging = true;
    }
  
    /**
     * This method is called when the mouse is clicked
     */
    public void onClick() {
      if (toySaga.noToyIsDragging() && isMouseOver()) {
        startDragging();
      }
    }
  
    /**
     * This method is called when the mouse is released
     */
    public void onRelease() {
      if (isDragging) {
        stopDragging();
      }
    }
  
    /**
     * This method is called when the mouse is pressed
     */
    public boolean isMouseOver() {
      return isOver(toySaga.mouseX, toySaga.mouseY);
    }
  
  }
  