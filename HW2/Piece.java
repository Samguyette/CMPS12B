//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// Piece.java 
// Piece super class
//-----------------------------------------------------------------------------
class Piece{
	int col;
	int row;
	String type;

	public int getCol(){
		return col;
	}

	public void setCol(int col){
		this.col = col;
	}

	public int getRow(){
		return row;
	}

	public void setRow(int row){
		this.row = row;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
}