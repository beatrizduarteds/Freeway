import java.io.Serializable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* 
  Class to:
    - Create a matrix by it's width, rows, and values number (set the same to all cells).
    - Print the matrix.
    - Use its objects as a I/O Object Stream through Serializable interface.
    - Update the matrix
*/
public class Matrix implements Serializable
{ 
  // Matrix object attributes
  int rowsNumber;
	int columnsNumber;
	int cellValues;
	int matrix[][];
	public boolean upPressed, downPressed; // variables to store the chickens moves up/down
	
	Matrix(){}
	
	// Construct filling the matrix with 0's
	Matrix(int rows, int columns)
	{	
	  this.rowsNumber = rows;
	  this.columnsNumber = columns;
	  this.matrix = new int[rowsNumber][columnsNumber];
	  this.cellValues = 0;
	  for(int i = 0; i < this.rowsNumber; i++)
	  {
	    for(int j = 0; j < this.columnsNumber; j++)
	    {
	      this.matrix[i][j] = cellValues;
	    }
	  }
	}
	
	// Construct filling the matrix with the 'values' number
	Matrix(int rows, int columns, int values)
	{	
	  this.rowsNumber = rows;
	  this.columnsNumber = columns;
	  this.matrix = new int[rowsNumber][columnsNumber];
	  this.cellValues = values;
	  for(int i = 0; i < this.rowsNumber; i++)
	  {
	    for(int j = 0; j < this.columnsNumber; j++)
	    {
	      this.matrix[i][j] = cellValues;
	    }
	  }
	}
	
	// Print the matrix
	void printMatrix()
	{	
	  for(int i = 0; i < this.rowsNumber; i++)
	  {
	    for(int j = 0; j < this.columnsNumber; j++)
	    {
	       System.out.print(this.matrix[i][j]+" ");
	    }
	    System.out.println("");
	  }
	}
	
	// Update the matrix
	/*
      Get the keyCode associated with this key event (what the user pressed):
        - static final int VK_W is the constant for the "W" key
        - static final int VK_S is the constant for the "S" key
        - public static final int VK_KP_UP is the constant for the numeric keypad up arrow key
        - public static final int VK_KP_DOWN is the constant for the numeric keypad down arrow key
        - static final int VK_UP is the constant for the non-numpad up arrow key
        - public static final int VK_DOWN is the constant for the non-numpad down arrow key
    */
	void updateMatrix(int code, int playerNumber)
	{      
    if(code==KeyEvent.VK_W||code==KeyEvent.VK_KP_UP||code==KeyEvent.VK_UP){ // set when chicken move up
      upPressed = true;
    }
    
    else if(code==KeyEvent.VK_S||code==KeyEvent.VK_KP_DOWN||code==KeyEvent.VK_DOWN){ // set when chicken move down
      downPressed = true;
    }
    
    else if(code==KeyEvent.VK_W||code==KeyEvent.VK_KP_UP||code==KeyEvent.VK_UP){ // reset after chicken move up
      upPressed = false;
    }
    
    else if(code==KeyEvent.VK_S||code==KeyEvent.VK_KP_DOWN||code==KeyEvent.VK_DOWN){ // reset after chicken move down
      downPressed = false;
    }
    

	}
	
}
