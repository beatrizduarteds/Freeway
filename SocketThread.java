/*
  Thread class to represent each player.
  The first 2 clients to connect are able to send moves.
  The 3º+ clients will only be able to get the game state.
*/

import java.lang.Thread;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.ObjectOutputStream;
import java.io.DataInputStream;

class SocketThread extends Thread
{
  Socket sktThread;
  int playerNumber;
  static Matrix gameState;

  
  SocketThread(Socket skt, int count)//constructor
  {
  	this.sktThread = skt;
  	this.playerNumber = count;
  }
  
  @Override
  public void run()
  {
    int code;
    try
    {
      do
      {
          BufferedInputStream bis = new BufferedInputStream(this.sktThread.getInputStream()); // create buffer to get this player's moves
          
          DataInputStream dis = new DataInputStream(bis); // create a input stream to read from the buffer
          
          code = (int)dis.readInt(); // read key code
          
          // update the game state matrix
          gameState.updateMatrix(code,playerNumber);
      
        // Create an output stream and connect with the server output stream (it's 'skt' after connected)
	      ObjectOutputStream oos = new ObjectOutputStream(this.sktThread.getOutputStream());
	      
	      // Write the matrix to this client (its in binary)
	      oos.writeObject(gameState);
	      
      }while(code!=8);
      
	    sktThread.close();
	    
    }catch(Exception e){}
    
    

  }
  
}
