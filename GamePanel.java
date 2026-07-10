import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.net.Socket;

class GamePanel extends JPanel implements Runnable
{
  Socket skt; // reference player's socket
  KeyHandler keyHandler = new KeyHandler(this.skt); // create the object to listen and handle this players key inputs
  
  Thread gameThread; // reference the thread for the game loop 
  
  int FPS = 60;// set  game loop FPS
  
  // Set player's default positions and speed
  int playerX = tileSize*6;
  int playerY = screenHeight-tileSize;
  int playerSpeed = 4;
  
  
  // COLORS
  // Background Colors
  // Color name = new Color(int/float redValue, int/float greenValue, int/float blueValue);
  Color ROAD = new Color(144, 139, 145); // gray
  Color BLACKLINES = new Color(0, 0, 0); // black
  Color CURB = new Color(178, 173, 179); // light gray
  Color ROAD_PAINT_GREY = new Color(208, 203, 209); // lightest gray
  Color ROAD_PAINT_YELLOW = new Color(216, 213, 127); // yellow
  Color SCORE = new Color(226, 117, 121); // pink
  // Cars Colors
  Color CAR1 = new Color(163, 23, 30); // red
  Color CAR2 = new Color(192, 225, 127); // light green
  Color CAR3 = new Color(104, 108, 10); // dark green
  Color CAR4 = new Color(235, 102, 117); // pastel pink
  Color CAR5 = new Color(30, 22, 177); // blue 
  Color CAR6 = new Color(159, 99, 46); // light brown
  Color CAR7 = new Color(94, 85, 207); // light blue
  Color CAR8 = new Color(191, 48, 43); // light red
  Color CAR9 = new Color(147, 175, 91); // green
  Color CAR10 = new Color(216, 218, 84); // pastel yellow
  // Chickens Color
  Color CHICKEN = new Color(252, 254, 79); // brighter yellow

  // SCREEN SIZES
  static final int tileSize = 48; // 48px  width and 48px height screen grid
  static final int screenRows = 12; // each row has 48px of height
  static final int screenColumns = 23; // each column has 48px of width
  static final int screenWidth = screenColumns * tileSize; // 1104px
  static final int screenHeight = screenRows * tileSize; // 576px
  
   
  // constructor
  GamePanel(Socket skt)
  {  
    this.setPreferredSize(new Dimension(screenWidth,screenHeight)); // set the dimensions calculated
    this.setBackground(ROAD); // set the background color to gray
    this.setDoubleBuffered(true); // activate JPanel feature to better rendering performance
    this.skt = skt;
    this.addKeyListener(keyHandler); // add key listener to this panel
    this.setFocusable(true); // set this panel to be focused to receive key inputs
  }  

  public void run() 
  {
    // math to slow down game loop to the preferred FPS
    double drawInterval = 1000000000/FPS;
    double delta = 0;
    long lastTime = System.nanoTime(); // returns the current value of running JVM's high-resolution time source, in nanoseconds (more precise)
    // long currentTime2 = System.currentTimeMillis(); // returns the current value of running JVM's high-resolution time source, in milliseconds
    long currentTime;
      
    // Game Loop
    while(gameThread != null)
    {  
      currentTime = System.nanoTime();
      delta+=(currentTime-lastTime)/drawInterval;
      lastTime=currentTime;
      if(delta>=1){
        //System.out.println(currentTime);
        // System.out.println("The game is running!");
        update(); // update the characters positions
        repaint(); // print the current state
        delta--;
      }

    }
  }
  
  
  void startGameThread()
  {  
    gameThread = new Thread(this); // pass the GamePanel class to the constructor
    gameThread.start();
  }
  
  /* 
      Update the position of the chickens
        - X=0 and Y=0 in up the left corner
        - X value increase to the right
        - Y value increase going down
  */
  public void update(){
  /*
    if(keyHandler.upPressed==true){
      playerY-=playerSpeed;
    }
    else if(keyHandler.downPressed==true){
      playerY+=playerSpeed;
    }
  */
  }
  
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D)g; // cast graphics to 2D
    
    g2D.setColor(CHICKEN); // set color of chicken 1
    g2D.fillRect(playerX,playerY,tileSize,tileSize/2); // draw opaque rectangle give coordinates x, y, and width and height
    g2D.dispose(); // release any system resources that this graphics is using
    
  }
  
}

