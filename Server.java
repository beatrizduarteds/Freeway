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
	  
	  // Write(send) the matrix to this client (its in binary)
	  oos.writeObject(gameState);
	  
	  // Close the output stream (object stream must be first)
	  oos.close();
	
	}
}

