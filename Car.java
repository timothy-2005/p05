public class Car extends Toy{
    private static int absoluteSpeed;
    private boolean isMovingRightward;
    private int speed;

    public Car(int x, int y) {
        super("car.png", x, y);
        absoluteSpeed = 8;
        isMovingRightward = true;
        speed = absoluteSpeed;
    }

    public void draw(){
        if (toySaga.isNightMode()){
            move();
            drawCarNightMode();
        }else{
            draw();
        }
    }
    private void drawCarNightMode(){
        toySaga.pushMatrix();
        toySaga.rotate(0.0f);
        toySaga.translate(x, y);
        if (!isMovingRightward){
            toySaga.scale(-1.0f, 1.0f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }
    public void flipMoveDirection(){
        isMovingRightward = !isMovingRightward;
        speed = - speed;        
    }
    public void move(){
        if (!toySaga.isNightMode()){
            move();
        }else{
            move(speed, 0);
            if (isOver(image.width, getY()) || isOver(0, getY())){
                flipMoveDirection();
            }
        }
    }
    public static int getSpeed(){
        return Car.absoluteSpeed;
    }
    public static void setSpeed(int speed){
        absoluteSpeed = speed;
    }
}
