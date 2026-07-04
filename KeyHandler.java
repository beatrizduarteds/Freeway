import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.Socket;
import java.io.DataOutputStream;

public class KeyHandler implements KeyListener // interface for receiving keyboard events (keystrokes)
{
  public boolean upPressed, downPressed; // variables to store the chickens moves up/down
  Socket skt;
  
  KeyHandler(Socket skt)
  {
    this.skt=skt;
  }
  
  @Override
  public void keyTyped(KeyEvent e){} // no need to use this method here but it must be overwrited
  
  @Override
  public void keyPressed(KeyEvent kp)
  { 
    /*
      Get the keyCode associated with this key event (what the user pressed):
        - static final int VK_W is the constant for the "W" key
        - static final int VK_S is the constant for the "S" key
        - public static final int VK_KP_UP is the constant for the numeric keypad up arrow key
        - public static final int VK_KP_DOWN is the constant for the numeric keypad down arrow key
        - static final int VK_UP is the constant for the non-numpad up arrow key
        - public static final int VK_DOWN is the constant for the non-numpad down arrow key
    */
    int code = kp.getKeyCode();
    try
    {
      // Create an output stream to send an int number to the server
      DataOutputStream dos = new DataOutputStream(this.skt.getOutputStream());
      // Send code
      dos.writeInt(code);
          
    }catch(Exception e){}
    
    
    /* 
          
    if(code==KeyEvent.VK_W||code==KeyEvent.VK_KP_UP||code==KeyEvent.VK_UP){ // set when chicken move up
      upPressed = true;
    }
    if(code==KeyEvent.VK_S||code==KeyEvent.VK_KP_DOWN||code==KeyEvent.VK_DOWN){ // set when chicken move down
      downPressed = true;
    }
    */
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
    
    
    /*
    if(code==KeyEvent.VK_W||code==KeyEvent.VK_KP_UP||code==KeyEvent.VK_UP){ // reset after chicken move up
      upPressed = false;
    }
    if(code==KeyEvent.VK_S||code==KeyEvent.VK_KP_DOWN||code==KeyEvent.VK_DOWN){ // reset after chicken move down
      downPressed = false;
    }
    */
  }
}

