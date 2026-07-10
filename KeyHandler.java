import java.net.Socket;
import java.io.DataOutputStream;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener // interface for receiving keyboard events (keystrokes)
{
  Socket skt;
  
  KeyHandler(Socket skt)
  {
    this.skt=skt;
  }
  
  @Override
  public void keyTyped(KeyEvent e){} // no need to use this method here but it must be overridden
  
  @Override
  public void keyPressed(KeyEvent kp)
  { 
    
    int code = kp.getKeyCode();
    try
    {
      // Create an output stream to send an int number to the server
      DataOutputStream dos = new DataOutputStream(this.skt.getOutputStream());
      // Send code
      dos.writeInt(code);
          
    }catch(Exception e){}
    
}
  
  @Override
  public void keyReleased(KeyEvent kr)
  {
    // Get code of the released key
    int code = kr.getKeyCode();
      
    try
    {
      // Create an output stream to send an int number to the server
      DataOutputStream dos = new DataOutputStream(this.skt.getOutputStream());
      // Send code
      dos.writeInt(code);
      
    }catch(Exception e){}
    
  }
}

