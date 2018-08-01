//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// Rook.java 
// Rook chess piece class
//-----------------------------------------------------------------------------
public class Rook extends Piece{

	public static boolean isAttacking(int col, int row, Piece piece){
		boolean canAttack = false;

		if(piece.col == col || piece.row == row){
			canAttack = true;
		}
		return canAttack;
	}

	public static boolean isLegal(int currentC, int currentR, int newC, int newR){
		boolean canAttack = false;

		if(currentC == newC || currentR == newR){
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
		if((newCol == currCol) && (newRow > currRow)){
			while(newRow-1 != currRow){
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
		if((newCol == currCol) && (newRow < currRow)){
			while(newRow+1 != currRow){
				currRow = currRow - 1;
				if(LinkedList.Find(currCol, currRow)){
					canMove = false;
				}
			}
		}
		return canMove;
	}
}

