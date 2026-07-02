import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener // interface for receiving keyboard events (keystrokes)
{
  public boolean upPressed, downPressed; // variables to store the chickens moves up/down
  
  @Override
  public void keyTyped(KeyEvent e){} // no need to use this method here but it must be overwrited
  
  @Override
  public void keyPressed(KeyEvent e){
    int code = e.getKeyCode(); // get the keyCode associated with this key event (what the user pressed)
    /* 
      static final int VK_W is the constant for the "W" key
      static final int VK_S is the constant for the "S" key
      public static final int VK_KP_UP is the constant for the numeric keypad up arrow key
      public static final int VK_KP_DOWN is the constant for the numeric keypad down arrow key
      static final int VK_UP is the constant for the non-numpad up arrow key
      public static final int VK_DOWN is the constant for the non-numpad down arrow key
    */
    if(code==KeyEvent.VK_W||code==KeyEvent.VK_KP_UP||code==KeyEvent.VK_UP){ // set when chicken move up
      upPressed = true;
    }
    if(code==KeyEvent.VK_S||code==KeyEvent.VK_KP_DOWN||code==KeyEvent.VK_DOWN){ // set when chicken move down
      downPressed = true;
    }
}
  
  @Override
  public void keyReleased(KeyEvent e){
    int code = e.getKeyCode();
 
    if(code==KeyEvent.VK_W||code==KeyEvent.VK_KP_UP||code==KeyEvent.VK_UP){ // reset after chicken move up
      upPressed = false;
    }
    if(code==KeyEvent.VK_S||code==KeyEvent.VK_KP_DOWN||code==KeyEvent.VK_DOWN){ // reset after chicken move down
      downPressed = false;
    }
  }
}

