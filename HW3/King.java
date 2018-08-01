//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// King.java 
// King chess piece class
//-----------------------------------------------------------------------------
public class King extends Piece{

	public static boolean isAttacking(int col, int row, Piece piece){
		boolean canAttack = false;

		if((piece.col == col && piece.row+1 == row) || (piece.col == col && piece.row-1 == row)){
			canAttack = true;	
		}
		if((piece.col+1 == col && piece.row == row) || (piece.col-1 == col && piece.row == row)){
			canAttack = true;
		}
		if((piece.col-1 == col && piece.row+1 == row) || (piece.col+1 == col && piece.row-1 == row)){
			canAttack = true;
		}
		if((piece.col+1 == col && piece.row-1 == row) || (piece.col-1 == col && piece.row-1 == row)){
			canAttack = true;
		} 
		return canAttack;
	}
	

	public static boolean isLegal(int currentC, int currentR, int newC, int newR){
		boolean canAttack = false;

		if((currentC == newC && currentR == newR+1) || (currentC == newC && currentR == newR-1)){
			canAttack = true;	
		}
		if((currentC == newC+1 && currentR == newR) || (currentC == newC-1 && currentR == newR)){
			canAttack = true;
		}
		if((currentC == newC-1 && currentR == newR+1) || (currentC == newC+1 && currentR == newR-1)){
			canAttack = true;
		}
		if((currentC == newC+1 && currentR == newR+1) || (currentC == newC-1 && currentR == newR-1)){
			canAttack = true;
		} 
		return canAttack;
	}

	public static boolean checkPath(int currCol, int currRow, int newCol, int newRow){
		boolean canMove = true;
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