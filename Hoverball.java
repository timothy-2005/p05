import processing.core.PApplet;

public class Hoverball extends Toy{
    public Hoverball(int x, int y){
        super(ToySaga.HOVERBALL_OFF,x ,y);
    }
    private void switchOnOff(){
        if (toySaga.isNightMode()){
            setImage(ToySaga.HOVERBALL_ON);
        }else{
            setImage(ToySaga.HOVERBALL_OFF);
        }
    }
    public void draw(){
        switchOnOff();
        super.draw();
    }
    public void move(){
        if (!toySaga.isNightMode()){
            super.move();
        }else{
            move(0, Math.round(6 * PApplet.sin(toySaga.frameCount * 0.1f)));
        }
    }
}
