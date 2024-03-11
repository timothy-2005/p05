import processing.core.PApplet;

public class TeddyBear extends Toy{
    private Callout callout;
    private float rotation;
    private boolean rotationDirection;

    public TeddyBear(int x, int y){
        super(ToySaga.BEAR, x, y);
        callout = new Callout(x, y);
        rotation = 0;
        rotationDirection = true;
    }
    public float getRotation(){
        return rotation;
    }
    public void setRotation(float rotation){
        this.rotation = rotation;
    }
    public void setRotationDirection(boolean direction){
        rotationDirection = direction;
    }
    public boolean getRotationDirection(){
        return rotationDirection;
    }
    public void draw(){
        if (toySaga.isNightMode()){
            System.out.println("3");
            drawTeddyBearNightMode();
        }else{
            super.draw();
        }
    }
    public void drawTeddyBearNightMode(){
        System.out.println("1");
        this.move();
        toySaga.pushMatrix();
        toySaga.translate(x, y);
        toySaga.rotate(rotation * PApplet.PI / 2);
        if (toySaga.getMode() == "NIGHT"){
            toySaga.image(callout.image, 20f, -90f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }
    public void move(){
        if (!toySaga.isNightMode()){
            super.move();
        }else{
            rotation = getRotation() + PApplet.radians(3);
            if (rotation >= 30){
                setRotationDirection(false);
            }else if(rotation <= -30){
                setRotationDirection(true);
            }
            setRotation(rotation);
            
        }
    }
}
