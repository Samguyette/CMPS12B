//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// Pawn.java 
// Kight chess piece class
//-----------------------------------------------------------------------------
public class Pawn extends Piece{

	public static boolean isAttacking(int col, int row, String type, Piece piece){
		boolean canAttack = false;
		String get = piece.type;

		char colorChar = type.charAt(0);			//ASSUMMING WHITE STARTS ON BOTTOM SIDE
		char colorChartemp = get.charAt(0);			//AND BLACKS START ON TOP SIDE
		
		boolean colorCharBoolean = Character.isUpperCase(colorChar);
		boolean colorChartempBoolean = Character.isUpperCase(colorChartemp);
		
		if(colorCharBoolean != colorChartempBoolean){
			if(colorCharBoolean == true){
				if(piece.col == col-1 && piece.row == row+1 && colorChartempBoolean != colorCharBoolean){
					
				canAttack = true;
				}
				if(piece.col == col-1 && piece.row == row-1 && colorChartempBoolean != colorCharBoolean){
					
				canAttack = true;
				}
			}
			if(colorCharBoolean == false){
				if(piece.col == col+1 && piece.row == row+1 && colorChartempBoolean != colorCharBoolean){
					
				canAttack = true;
				}
				if(piece.col == col-1 && piece.row == row+1 && colorChartempBoolean != colorCharBoolean){
					
				canAttack = true;
				}
			}
		}
		return canAttack;
	}
}


