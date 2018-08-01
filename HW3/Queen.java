//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// Queen.java 
// Queen chess piece class
//-----------------------------------------------------------------------------
public class Queen extends Piece{

	public static boolean isAttacking(int col, int row, Piece piece){
		boolean canAttack = false;
		
		if(piece.col == col || piece.row == row){
			canAttack = true;
		}
		if(piece.col - piece.row == col - row){
			canAttack = true;
		}
		if(piece.col + piece.row == col + row){
			canAttack = true;
		}
		return canAttack;
	}

	

	public static boolean isLegal(int currentC, int currentR, int newC, int newR){
		boolean canAttack = false;
		if(currentC == newC || currentR == newR){
			canAttack = true;
		}
		if(currentC - currentR == newC - newR){
			canAttack = true;
		}
		if(currentC + currentR == newC + newR){
			canAttack = true;
		}
		return canAttack;
	}

	public static boolean checkPath(int currCol, int currRow, int newCol, int newRow){
		boolean canMove = true;
		//System.out.println("L");
		if((newCol > currCol) && (newRow == currRow)){
			while(newCol-1 != currCol){
				currCol = currCol + 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol > currCol) && (newRow > currRow)){
			while(newCol-1 != currCol && newRow - 1 != currRow){
				currCol = currCol + 1;
				currRow = currRow + 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol == currCol) && (newRow > currRow)){
			while(newRow-1 != currRow){
				currRow = currRow + 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol < currCol) && (currRow < newRow)){
			while(newCol+1 != currCol && newRow-1 != currRow){
				currCol = currCol - 1;
				currRow = currRow + 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol < currCol) && (newRow == currRow)){
			while(newCol+1 != currCol){
				currCol = currCol - 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol < currCol) && (newRow < currRow)){
			while(newCol+1 != currCol && newRow+1 != currRow){
				currCol = currCol - 1;
				currRow = currRow - 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol == currCol) && (newRow < currRow)){
			while(newRow+1 != currRow){
				currRow = currRow - 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		if((newCol > currCol) && (newRow < currRow)){
			while(newCol-1 != currCol && newRow+1 != currRow){
				currCol = currCol + 1;
				currRow = currRow - 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		return canMove;
	}
}