/**
 * Car class is a subclass of Toy class. It has a unique draw method that draws the car in night
 * mode. It also has a move method that moves the car in night mode. It has a flipMoveDirection
 * method that flips the direction of the car. It has a getSpeed method that returns the absolute
 * speed of the car. It has a setSpeed method that sets the absolute speed of the car.
 */
public class Car extends Toy {
    /**
     * Absolute speed of the car
     */
    private static int absoluteSpeed;
    /**
     * Boolean that indicates if the car is moving rightward
     */
    private boolean isMovingRightward;
    /**
     * Speed of the car
     */
    private int speed;

    /**
     * Constructs a new Car object with a specific x and y position
     * 
     * @param x x-position of the center of the car
     * @param y y-position of the center of the car
     */
    public Car(int x, int y) {
        super(ToySaga.CAR, x, y);
        absoluteSpeed = 8; // Initializes the absolute speed of the car
        isMovingRightward = true;
        speed = absoluteSpeed;
    }

    /**
     * Draws the car on the screen
     */
    @Override
    public void draw() {
        if (toySaga.isNightMode()) {
            move();
            drawCarNightMode();
        } else {
            super.draw();
        }
    }

    /**
     * Draws the car on the screen in night mode
     */
    private void drawCarNightMode() {
        toySaga.pushMatrix();
        toySaga.rotate(0.0f);
        toySaga.translate(x, y);
        if (!isMovingRightward) {
            toySaga.scale(-1.0f, 1.0f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }

    /**
     * Flips the direction of the car
     */
    public void flipMoveDirection() {
        isMovingRightward = !isMovingRightward;
        speed = -speed;
    }

    /**
     * Moves the car on the screen
     */
    @Override
    public void move() {
        if (!toySaga.isNightMode()) {
            super.move();
        } else {
            move(speed, 0);
            if (x >= toySaga.width || x <= 0) {
                flipMoveDirection();
            }
        }
    }

    /**
     * Returns the absolute speed of the car
     */
    public static int getSpeed() {
        return Car.absoluteSpeed;
    }

    /**
     * Sets the absolute speed of the car
     * 
     * @param speed new absolute speed of the car
     */
    public static void setSpeed(int speed) {
        absoluteSpeed = speed;
    }
}
