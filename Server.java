import javax.swing.JFrame;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;

class Server
{
	public static void main(String args[]) throws Exception
	{
	  // Create a matrix object that represents the game state
	  //Matrix test1 = new Matrix(25,50,3);
    Matrix gameState = new Matrix(GamePanel.screenHeight,GamePanel.screenWidth);
    
    // Create a server socket to be available to connect with clients/players
    ServerSocket ss = new ServerSocket(2500);
       
    // Reference an client socket;
    Socket skt;
    
    // Create client count
    int count = 1;
    
    // Conect with the client
    skt = ss.accept();
    System.out.println("Player "+count+++" just arrive!");
    
	  
	  // Create an output stream and connect with the server output stream (it's 'skt' after connected)
	  ObjectOutputStream oos = new ObjectOutputStream(skt.getOutputStream());
	  
	  // Write the matrix to this client (its in binary)
	  oos.writeObject(gameState);
	  
	  // Close the output stream (object stream must be first)
	  oos.close();
	  
	
	
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
	
	}
}

