//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// King.java 
// King chess piece class
//-----------------------------------------------------------------------------
public class King extends Piece{

	public static boolean isAttacking(int col, int row, String type, Piece piece){
		boolean canAttack = false;
		String get = piece.type;

		char colorChar = type.charAt(0);
		char colorChartemp = get.charAt(0);
		
		boolean colorCharBoolean = Character.isUpperCase(colorChar);
		boolean colorChartempBoolean = Character.isUpperCase(colorChartemp);

		if((piece.col == col && piece.row == row+1 && colorChartempBoolean != colorCharBoolean) || 			//need to figure out how to read in types properly
			(piece.col == col && piece.row == row-1 && colorChartempBoolean != colorCharBoolean)){
			canAttack = true;	
		}
		if((piece.col == col+1 && piece.row == row && colorChartempBoolean != colorCharBoolean) || 
			(piece.col == col-1 && piece.row == row && colorChartempBoolean != colorCharBoolean)){
			canAttack = true;
		}
		if((piece.col == col-1 && piece.row == row+1 && colorChartempBoolean != colorCharBoolean) || 
			(piece.col == col+1 && piece.row == row-1 && colorChartempBoolean != colorCharBoolean)){
			canAttack = true;
		}
		if((piece.col == col+1 && piece.row == row+1 && colorChartempBoolean != colorCharBoolean) || 
			(piece.col == col-1 && piece.row == row-1 && colorChartempBoolean != colorCharBoolean)){
			canAttack = true;
		} 
		return canAttack;
	}
}

