import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

class GamePanel extends JPanel
{
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
  final int originalTileSize =16; // 16px by 16px minimum tile
  final int tileScale = 3; // to amplify the resolution on the new wider screens
  final int tileSize = originalTileSize * tileScale; // 48px scaling the tile size the will actually be shown
  final int screenColumns = 23; // the last column must be hidden so the car appears gradually?
  final int screenRows = 12;
  final int screenWidth = screenColumns * tileSize; // 1104px
  final int screenHeight = screenRows * tileSize; // 576px

  // constructor
  GamePanel()
  {  
    this.setPreferredSize(new Dimension(screenWidth,screenHeight)); // set the dimensions calculated
    this.setBackground(ROAD); // set the background color to gray
    this.setDoubleBuffered(true); // activate JPanel feature to better rendering performance
  }  

}

