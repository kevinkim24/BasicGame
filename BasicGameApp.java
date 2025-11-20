//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// Graphics Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //You can set their initial values too
    Mario mario;
    Luigi luigi;
    Image background;

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor
        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game
        background = Toolkit.getDefaultToolkit().getImage("marioworld.png");

        mario = new Mario(500,350,1.5,1.5,100,100);
        mario.name = "Mario Mario";
        mario.aliveImage = Toolkit.getDefaultToolkit().getImage("Mario.png");
        mario.deadImage = Toolkit.getDefaultToolkit().getImage("deadMario.jpg");

        luigi = new Luigi(0,350,1.5,1.5,200,300);
        luigi.name = "Luigi Mario";
        luigi.image = Toolkit.getDefaultToolkit().getImage("luigi.png");
    }
    // end BasicGameApp constructor

    public void moveThings() {
        //call the move() code for each object  -
        mario.move();
        luigi.move();
    }

    public void checkCollision(){
        System.out.println("Checking for Collisions");
        System.out.println(mario.hitbox);
        System.out.println(luigi.hitbox);
        if (mario.hitbox.intersects(luigi.hitbox)){
            mario.isAlive = false;
            System.out.println("INTERSECTING");
        }
        else{
            System.out.println("No collision");
            mario.isAlive = true;
        }
    }


    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        // Signature: drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
        g.drawImage(background,0,0,WIDTH,HEIGHT,null);  // Background MUST be drawn first
        if (mario.isAlive) {
            g.drawImage(mario.aliveImage, mario.xpos, mario.ypos, mario.width, mario.height, null);
        }
        else{
            g.drawImage(mario.deadImage, mario.xpos, mario.ypos, mario.width, mario.height, null);
        }
        g.drawImage(luigi.image,luigi.xpos,luigi.ypos,luigi.width,luigi.height,null);

        g.dispose();
        bufferStrategy.show();
    }














//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    // PSVM: This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            checkCollision();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename){
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}

