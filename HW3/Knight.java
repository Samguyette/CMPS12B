//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// King.java 
// Kight chess piece class
//-----------------------------------------------------------------------------
public class Knight extends Piece{

	public static boolean isAttacking(int col, int row, Piece piece){
		boolean canAttack = false;

		if((piece.col-1 == col && piece.row+2 == row) || (piece.col+1 == col && piece.row+2 == row)){			
			canAttack = true;
		}
		if((piece.col-1 == col && piece.row-2 == row) || (piece.col+1 == col && piece.row-2 == row)){	
			canAttack = true;
		}
		if((piece.col+2 == col && piece.row-1 == row) || (piece.col+2 == col && piece.row+1 == row)){		
			canAttack = true;
		}
		if((piece.col-2 == col && piece.row-1 == row) || (piece.col-2 == col && piece.row+1 == row)){		
			canAttack = true;
		}
		return canAttack;
	}

	public static boolean isLegal(int currentC, int currentR, int newC, int newR){
		boolean canAttack = false;
		
		if((currentC == newC-1 && currentR== newR+2) || (currentC == newC+1 && currentR== newR+2)){			
			canAttack = true;
		}
		if((currentC == newC-1 && currentR== newR-2) || (currentC == newC+1 && currentR== newR-2)){	
			canAttack = true;
		}
		if((currentC == newC+2 && currentR== newR-1) || (currentC == newC+2 && currentR== newR+1)){			
			canAttack = true;
		}
		if((currentC == newC-2 && currentR== newR-1) || (currentC == newC-2 && currentR== newR+1)){			
			canAttack = true;
		}
		return canAttack;
	}
}


