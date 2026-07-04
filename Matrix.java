import java.io.Serializable;

/* 
  Class to:
    - Create a matrix by it's width, rows, and values number (set the same to all cells).
    - Print the matrix.
    - Use its objects as a I/O Object Stream through Serializable interface.
*/
public class Matrix implements Serializable
{ 
  // Matrix object attributes
  int rowsNumber;
	int columnsNumber;
	int cellValues;
	int matrix[][];
	
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
}
