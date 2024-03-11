public class Car extends Toy{
    private static int absoluteSpeed = 8;
    private boolean isMovingRightward;
    private int speed;

    public Car(int x, int y) {
        super("car.png", x, y);
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
        
    }
}
