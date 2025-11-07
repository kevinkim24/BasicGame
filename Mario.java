import java.awt.*;

public class Mario {
    public String name; // Means Mario has all these attributes
    public Image image;
    public int xpos;
    public int ypos;
    public double dx;
    public double dy;
    public int width;
    public int height;
    public Rectangle hitbox;
    //public boolean isAlive;

    public Mario(){
        hitbox = new Rectangle(xpos,ypos,width,height);
    }

    public Mario(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput){
        // Take in params
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        // Make hitbox
        hitbox = new Rectangle(xpos,ypos,width,height);
    }

    public void move() {
        xpos += (int) dx;
        ypos += (int) dy;
    }

    public void wrap(){
        if (xpos == 1000 - width && dx > 0) dx *= -1;
        else if (ypos == 700 - height && dy > 0) dy *= -1;
        else if (xpos == 0 && dx < 0) dx *= -1;
        else if (ypos == 0 && dy < 0) dy *= -1;

    }

    public static void main(String[] args) {

    }
}
