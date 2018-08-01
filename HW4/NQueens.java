//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// NQueens.java
// Takes input and places multiple queens on the board along with
// (n - preset) queens on an n × n chessboard such that no two attack each other.
// It will print the location of all the queens to an output file in increasing
// order. This version uses a stack rather than recursion.
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class NQueens{
	public static void main(String args[]) throws IOException{

		if(args.length < 2){						//checks for proper input
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1); 
		}

		Scanner in = new Scanner(new File (args[0]));
		PrintWriter out = new PrintWriter(new File (args[1]));
		
		Stack<Queen> queenStack = new Stack<Queen>();
		int n;
		int x;
		int y;
		int tempQueenCount;
		int presetQueens;
		int counter;
		int index;
		int col;
		int row;

		while(in.hasNextLine()){
			presetQueens = 0;
			tempQueenCount = 0;
			counter = 0;
			boolean lineFinished = false;
			try{ 
                n = in.nextInt();			//catches exception found from HW1
            }
            catch(Exception e)
            {
                break;
            }

            String data = in.nextLine();
			String[] pieces = data.split(" ");			//converts to string
			int indexSize = 0;
			index = 1;
			if(n < 9){
				indexSize = (data.length()/4);
			}
			if(n > 9){
				indexSize = ((data.length()-2)/4);
			}
            while(indexSize > 0){
         		x = Integer.parseInt(pieces[index]);		//converts back to int			
				index++;
				y = Integer.parseInt(pieces[index]);
				index++;
				if(isAttacking(x,y,queenStack) == true && lineFinished == false){
					out.println("No solution");
					lineFinished = true;
				}
				if(isAttacking(x,y,queenStack) == false && lineFinished == false){
					Queen newQueen = new Queen(x,y);
					queenStack.push(newQueen);			//pushes the queens in the input onto the stack
					presetQueens++;
				}
				indexSize--;
            }

            tempQueenCount = presetQueens;
            col = 1;
            row = 1;
            boolean whileLoopFinished = false;
            while(col <= n){
            	row = 1;
            	while(row <= n){
	            	if(alreadyInCol(col, queenStack) == false && lineFinished == false){	//checks if there is a queen already in col
	            		if(isAttacking(col, row, queenStack) == false){					//checks if position is being attacked
	            			Queen newQueen = new Queen(col, row);
	            			queenStack.push(newQueen);									//if not places queen
	            			tempQueenCount++;
	            			whileLoopFinished = true;
	            		}
	            		while(row == n && lineFinished == false && whileLoopFinished == false){
	            			if(queenStack.isEmpty() == false && whileLoopFinished == false){
		            			Queen fail = queenStack.pop();						//if can't find open spot in col it pops previous queen
				           		tempQueenCount--;
				           		col = fail.col;										//and resets col and row variables
				           		row = fail.row;
				           		if(col == 1){
				           			whileLoopFinished = true;
				           		}
				           	}
				           	if(queenStack.isEmpty() && row == n){
				           		out.println("No solution");
				           		lineFinished = true;
				           		break;
				           	}
	            		}
	            		whileLoopFinished = false;
	            		if(tempQueenCount < presetQueens){						//if preset Queen is poped prints no solution
	            			out.println("No solution");
	            			lineFinished = true;
	            		}

	            		if(tempQueenCount == n){								//checks if there are n queens placed in the stack	
							Queen[] sortedQueens = new Queen[n];
	    					while(counter < n){									//sorts stack into an array by col number
		   					 	Queen temp = queenStack.pop();			
		  					  	sortedQueens[temp.col-1] = temp;
						    	counter++;
						    }
						    for(int i = 0; i < sortedQueens.length; i++){
								Queen temp = sortedQueens[i];
						    	out.print(temp.col+" ");
						    	out.print(temp.row+" ");
						    }
						   	out.println("");
						   	lineFinished = true;
	            		}
	            	}
	            	row++;
            	}
            	col++;
            }
            if(lineFinished == false){
            	out.println("No solution");
            }
            while(queenStack.isEmpty() == false){
            	queenStack.pop();								//clears stack for next line
            }
		}
		out.close();
	}

	public static boolean isAttacking(int col, int row, Stack queenStack){
		Iterator<Queen> itr = queenStack.iterator();
		while(itr.hasNext()){
			Queen temp = itr.next();

			if(temp.col == col){		//checks if theres a queen in same col
				return true;
			}
			if(temp.row == row){		//checks if theres a queen in same row
				return true;
			}
			if(temp.row - temp.col == row - col){		//checks if theres a queen in same diagnol 
				return true;
			}
			if(temp.row + temp.col == row + col){		//checks if theres a queen in same diagnol 
				return true;
			}
		}
		return false;
	}
	public static boolean alreadyInCol(int col, Stack queenStack){
		Iterator<Queen> itr = queenStack.iterator();
		while(itr.hasNext()){
			Queen temp = itr.next();
			if(col == temp.col){
				return true;
			}
		}
		return false;
	}
}
