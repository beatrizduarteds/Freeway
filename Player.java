/*
  This class simulates the client/player application
*/

import javax.swing.JFrame;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;

class Player
{
  public static void main(String args[]) throws Exception
  {
    // Create a socket and connect with the server
    Socket skt = new Socket("localhost", 2500);
    // Create an output stream and connect with this socket output stream
    DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
    
    
    // Create an input stream buffer and connect with this socket input stream
    BufferedInputStream bis = new BufferedInputStream(skt.getInputStream());
    // Create an object input stream to read the Matrix object on the input stream buffer
    ObjectInputStream ois = new ObjectInputStream(bis);
    // Reference the object to be inputted
    Matrix test2 = (Matrix)ois.readObject();
    test2.printMatrix();
  
 /* 
    
// Game Window
 JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to be able to close the window
		window.setResizable(false); // so the window can not be resized
		window.setTitle("Freeway"); // set a title to the window
		
		
		GamePanel gamePanel = new GamePanel(skt); // create a panel
		window.add(gamePanel); // add the game panel to this window
		window.pack(); // make the window to be sized to fit the panel
		
		window.setLocationRelativeTo(null); // to position the window on the center of the screen
		window.setVisible(true); // to show the window
		
		//test 
		gamePanel.startGameThread();
 
 
 
 
 
 
 
 
  // Close the input stream (object stream must be first )
  ois.close();
  fis.close(); 
  */
  }
}
