//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// NQueens.java
// Takes input and places a single queen on the board along with
// n queens on an n × n chessboard such that no two attack each other.
// It will print the location of all the queens to an output file in increasing
// order.  
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class NQueens{
	public static void main(String args[]) throws IOException{

		if(args.length < 2){
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1); 
		}

		Scanner in = new Scanner(new File (args[0]));
		PrintWriter out = new PrintWriter(new File (args[1]));
		
		int lineNumber = 1;
		int n;
		int X;
		int Y;
		int QueenX;
		int QueenY;


		while(in.hasNextLine()){
			lineNumber++; 
			try{ 
                n = in.nextInt();
            }
            catch(Exception e)
            {
                break;
            }
			X = in.nextInt();
			Y = in.nextInt();
        	
			QueenX = X - 1;
			QueenY = Y - 1;	

			int[] columns = new int[n];
			int[] rows = new int[n];

			if(solveQueens(n, 0, rows, columns, QueenX, QueenY) == true){

				for(int columnNumber = 0; columnNumber < n; columnNumber++){
					for(int counter = 0; counter < n; counter++){		//prints rows and columns in order to outfile		
						if(columns[counter] == columnNumber){
							int a = columns[counter] + 1;
							int b = rows[counter] + 1;	
							out.print(a+" "+b+" ");
						}
					}
				}								
			}
			else{
				out.print("No solution");
			}
			out.println("");
		}
		out.close();
	}

	public static boolean solveQueens(int n, int row, int[] rows, int[] columns, int QueenX, int QueenY){
		boolean safe;
		
		int QueenXPass = QueenX;
		int QueenYPass = QueenY;

		if(row == n){
			return true;					  	//eventually turns true when last row is ran through
		}
		int column;		//stop column by incrementing to 0 every time
		for(column = 0; column < n; column++){
 			safe = true;
 			
 			if(column == QueenX){
					if(row != QueenY){					//makes sure that input queen is placed in the proper row
						safe = false;					// if not possible solveQueens won't return true													
					}
				}

			for(int q = 0; q < row; q++){		
				if(rows[q] == row){
					safe = false;						//checks if there is a queen already in the row
				}								    	//using the positions array
				if(columns[q] == column){
					safe = false;
				}
				if(rows[q] - columns[q] == row - column){
					safe = false;
				}
				if(rows[q] + columns[q] == row + column){
					safe = false;
				}
			}

			if(safe == true){				
				columns[row] = column;		//enter cordinates into array
				rows[row] = row;
				
				if(solveQueens(n, row + 1, rows, columns, QueenXPass, QueenYPass)){
					return true;
				}	//places row and column numbers in array
			}		
		}
		return false;
	}
}
