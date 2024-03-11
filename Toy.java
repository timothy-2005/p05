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
        move();
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
        if (x > this.x - image.width / 2 && x < this.x + image.width / 2 && y > this.y - image.height / 2 && y < this.y + image.height / 2){
            return true;
        }
        return false;
    }
    public void startDragging(){
        isDragging = true;
    }
    public void onClick(){
        if (toySaga.noToyIsDragging() && isMouseOver()){
            startDragging();
            
            
        }
    }
    public void onRelease(){
        if (isDragging){
            stopDragging();
        }
    }
    public boolean isMouseOver(){
        return isOver(toySaga.mouseX, toySaga.mouseY);
    }
    
}
