//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// Bishop.java 
// Bishop chess piece class
//-----------------------------------------------------------------------------
public class Bishop extends Piece{

	public static boolean isAttacking(int col, int row, Piece piece){
		boolean canAttack = false;
		
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

		if((newCol > currCol) && (newRow > currRow)){
			while(newCol-1 != currCol && newRow-1 != currRow){
				currCol = currCol + 1;
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
		if((newCol < currCol) && (newRow < currRow)){
			while(newCol+1 != currCol && newRow+1 != currRow){
				currCol = currCol - 1;
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
