import javax.swing.JFrame;
import java.net.ServerSocket;
import java.net.Socket;

class Server
{
	public static void main(String args[]) throws Exception
	{
	  //Matrix test1 = new Matrix(25,50,3);
    Matrix gameState = new Matrix(GamePanel.screenHeight,GamePanel.screenWidth); // create a matrix object that represents the game state
    SocketThread.gameState=gameState; // reference to this matrix for client threads
    
    ServerSocket ss = new ServerSocket(2500); // create a server socket to be available to connect with clients
  
    Socket skt; // reference an client socket;
    
    int count = 1; // create client count
    
    do
    {
      if(count<=2)
      {
        skt = ss.accept(); // connect with the player
        SocketThread sktT = new SocketThread(skt,count); // create a new player socket thread
        System.out.println("Player "+count+" just arrive!");
        count++;
        sktT.start(); // start player's thread
      }
    }while(true);
	  
	
	
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

