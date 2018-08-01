//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// Bishop.java 
// Bishop chess piece class
//-----------------------------------------------------------------------------
public class Bishop extends Piece{



	public static boolean isAttacking(int col, int row, String type, Piece piece){
		boolean canAttack = false;
		String get = piece.type;

		char colorChar = type.charAt(0);
		char colorChartemp = get.charAt(0);
		
		boolean colorCharBoolean = Character.isUpperCase(colorChar);
		boolean colorChartempBoolean = Character.isUpperCase(colorChartemp);
		
		if(piece.col - piece.row == col - row && colorChartempBoolean != colorCharBoolean){
			canAttack = true;
		}
		if(piece.col + piece.row == col + row && colorChartempBoolean != colorCharBoolean){
			canAttack = true;
		}
		return canAttack;
	}
}