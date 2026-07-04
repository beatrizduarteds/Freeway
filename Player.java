/*
  This class simulates the client aplication
*/

import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class Player
{
  public static void main(String args[]) throws Exception
  {
  // Create a input stream to read a object from a file
  FileInputStream fis = new FileInputStream("gameStateMatrix.txt");
  ObjectInputStream ois = new ObjectInputStream(fis);
  
  // Reference the object to be inputted and read the object in the file
  Matrix test2 = (Matrix)ois.readObject();
  test2.printMatrix();

 
  // Close the input stream (object stream must be first )
  ois.close();
  fis.close(); 
  }
}
