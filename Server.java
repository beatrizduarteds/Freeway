import javax.swing.JFrame;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class Server
{
	public static void main(String args[]) throws Exception
	{
	
	// Create the matrix that represents the pixels: 1104 width/columns, and 576 height/lines
	
	
	
	
	
	
	/*
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to be able to close the window
		window.setResizable(false); // so the window can not be resized
		window.setTitle("Freeway"); // set a title to the window
		
		
		GamePanel gamePanel = new GamePanel(); // create a panel
		window.add(gamePanel); // add the game panel to this window
		window.pack(); // make the window to be sized to fit the panel
		
		window.setLocationRelativeTo(null); // to position the window on the center of the screen
		window.setVisible(true); // to show the window
		
		//test 
		gamePanel.startGameThread();
	*/
	
	// Create a matrix object with the game state
	//Matrix test1 = new Matrix(25,50,3);
	GamePanel gamePanel = new GamePanel();
  Matrix gameState = new Matrix(gamePanel.screenHeight,gamePanel.screenWidth);
	
	// Create an output stream to send the matrix object to a file
	FileOutputStream fos = new FileOutputStream("gameStateMatrix.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	
	// Write the object on the file (it generates a binary file in this case)
	oos.writeObject(gameState);
	
	// Create a socket to connect to 2 players
	// Send the game state matrix to each player
	
	// Close the output stream (object stream must be first)
	oos.close();
	fos.close();
	}
}

