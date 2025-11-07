import java.awt.*;

public class Mario {
    public String name; // Means Mario has all these attributes
    public Image image;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public Rectangle hitbox;
    //public boolean isAlive;

    public Mario(){
        hitbox = new Rectangle(xpos,ypos,width,height);
    }

    public Mario(int xposInput, int yposInput, int dxInput, int dyInput, int widthInput, int heightInput){
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

    public static void main(String[] args) {

    }
}
