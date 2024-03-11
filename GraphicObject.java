public class GraphicObject extends Object implements Drawable{
    protected processing.core.PImage image;
    protected static ToySaga toySaga;
    protected int x;
    protected int y;

    public GraphicObject(String filename){
        
        image = toySaga.loadImage(filename);
        x = 400;
        y = 300;
    }
    public GraphicObject(String filename, int x, int y){
        
        image = toySaga.loadImage(filename);
        this.x = x;
        this.y = y;
    }
    
    public void setImage(String filename){
        image = toySaga.loadImage(filename);
    }
    public void draw(){
        toySaga.image(image, x, y);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public static void setProcessing(ToySaga toySaga){
        GraphicObject.toySaga = toySaga;
    }
    
}
