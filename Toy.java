public class Toy extends GraphicObject implements MouseListener, Movable{
    private boolean isDragging;

    public Toy(String filename){
        super(filename);
        isDragging = false;
    }
    public Toy(String filename, int x, int y){
        super(filename, x, y);
        isDragging = false;
    }
    public void draw(){
        super.draw();
    }
    public boolean isDragging(){
        return isDragging;
    }
    public void stopDragging(){
        isDragging = false;
    }
    public void move(){
        if (isDragging){
            move(toySaga.mouseX - toySaga.pmouseX, toySaga.mouseY - toySaga.pmouseY);
        }
    }
    protected void move(int dx, int dy){
        x += dx;
        y += dy;
        if(x < 0){
            x = 0;
        }else if (x > toySaga.width){
            x = toySaga.width;
        }else if (y < 0){
            y = 0;
        }else if (y > toySaga.height){
            y = toySaga.height;
        }
    }

    public boolean isOver(int x, int y){
        if (x > this.x && x < this.x + image.width && y > this.y && y < this.y + image.height){
            return true;
        }
        return false;
    }
    public void onClick(){
        if (!isDragging && isMouseOver()){
            isDragging = true;
        }
    }
    public void onRelease(){
        if (isDragging){
            isDragging = false;
        }
    }
    public boolean isMouseOver(){
        return isOver(toySaga.mouseX, toySaga.mouseY);
    }
    
}
