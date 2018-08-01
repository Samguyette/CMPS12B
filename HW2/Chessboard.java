//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// chessPiece.java  
// Takes input of an entire chess board 8x8 and verify that two pieces do not 
// occupy the same square, given a square, determines (if any) the chess piece at that
// square, and determines if the piece found above
// attacks another piece.  
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Character;

class ChessBoard{
	
	public static void main(String args[]) throws IOException{
		if(args.length < 2){
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1); 
		}
		Scanner in = new Scanner(new File (args[0]));
		PrintWriter out = new PrintWriter(new File (args[1]));
		String data = "";
		while(in.hasNextLine()){

			data = in.nextLine();

			data = data.replace(':', ' ');		//places all unput into an array
			String dataArray[] = data.split(" ");

			int xPiecePosition = Integer.parseInt(dataArray[0]);	//changes strings into arrays 
			int yPiecePosition = Integer.parseInt(dataArray[1]);	//and holds the x y position for desired piece

			LinkedList linkedlist = new LinkedList();

			int counter = 3;
			String type; 		
			int col;
			int row;
			boolean breakBreak = false;

			while(counter < dataArray.length){
				type = dataArray[counter];	
				counter++;											//holds piece in temp variables to turn into objects
				col = Integer.parseInt(dataArray[counter]);			//loops through all until all are placed
				counter++;
				row = Integer.parseInt(dataArray[counter]);
				counter++;
				if(type.equals("k")){
					Piece newKing = new King();
					newKing.setCol(col);			//creates new white king
					newKing.setRow(row);
					newKing.setType(type);
											
					linkedlist.insertAtStart(newKing);	//places that object in linked list
				}
				if(type.equals("q")){			
					Piece newQueen = new Queen();
					newQueen.setCol(col);			//creates new white queen
					newQueen.setRow(row);
					newQueen.setType(type);
											
					linkedlist.insertAtStart(newQueen);	//places that object in linked list
				}
				if(type.equals("r")){
					Piece newRook = new Rook();
					newRook.setCol(col);			//creates new white rook
					newRook.setRow(row);
					newRook.setType(type);
											
					linkedlist.insertAtStart(newRook);	//places that object in linked list
				}
				if(type.equals("b")){
					Piece newBishop = new Bishop();
					newBishop.setCol(col);			//creates new white bishop
					newBishop.setRow(row);
					newBishop.setType(type);
											
					linkedlist.insertAtStart(newBishop);	//places that object in linked list
				}
				if(type.equals("n")){
					Piece newKnight = new Knight();
					newKnight.setCol(col);			//creates new white knight
					newKnight.setRow(row);
					newKnight.setType(type);
											
					linkedlist.insertAtStart(newKnight);	//places that object in linked list
				}
				if(type.equals("p")){
					Piece newPawn = new Pawn();
					newPawn.setCol(col);			//creates new black night
					newPawn.setRow(row);
					newPawn.setType(type);
											
					linkedlist.insertAtStart(newPawn);	//places that object in linked list
				}
				if(type.equals("K")){
					Piece newKing = new King();
					newKing.setCol(col);			//creates new black king
					newKing.setRow(row);
					newKing.setType(type);
											
					linkedlist.insertAtStart(newKing);	//places that object in linked list
				}
				if(type.equals("Q")){
					Piece newQueen = new Queen();
					newQueen.setCol(col);			//creates new black queen
					newQueen.setRow(row);
					newQueen.setType(type);
											
					linkedlist.insertAtStart(newQueen);	//places that object in linked list
				}
				if(type.equals("R")){
					Piece newRook = new Rook();
					newRook.setCol(col);			//creates new black rook
					newRook.setRow(row);
					newRook.setType(type);
											
					linkedlist.insertAtStart(newRook);	//places that object in linked list
				}
				if(type.equals("B")){
					Piece newBishop = new Bishop();
					newBishop.setCol(col);			//creates new black bishop
					newBishop.setRow(row);
					newBishop.setType(type);
											
					linkedlist.insertAtStart(newBishop);	//places that object in linked list
				}
				if(type.equals("N")){
					Piece newKnight = new Knight();
					newKnight.setCol(col);			//creates new black night
					newKnight.setRow(row);
					newKnight.setType(type);
											
					linkedlist.insertAtStart(newKnight);	//places that object in linked list
				}
				if(type.equals("P")){
					Piece newPawn = new Pawn();
					newPawn.setCol(col);			//creates new black night
					newPawn.setRow(row);
					newPawn.setType(type);
											
					linkedlist.insertAtStart(newPawn);	//places that object in linked list
				}
			}
			if(linkedlist.Invalid() == true){
				out.println("Invalid");
				breakBreak = true;								//prints Invalid if two pieces share same spot
			}

			if(linkedlist.Find(xPiecePosition,yPiecePosition) == false && breakBreak == false){
				out.println("-");
				breakBreak = true;												//finds if there is a piece placed on location
			}
			if(breakBreak == false){
				Piece target = new Piece();
				target = linkedlist.FindPiece(xPiecePosition,yPiecePosition);		//checks if the piece is attacking anything

				if(target.type.equals("K") || target.type.equals("k")){
					if(linkedlist.King(target.col,target.row,target.type) == true){
						out.print(target.type+" y");
					}
					if(linkedlist.King(target.col,target.row,target.type) == false){
						out.print(target.type+" n");
					}
				}

				if(target.type.equals("Q") || target.type.equals("q")){
					if(linkedlist.Queen(target.col,target.row,target.type) == true){
						out.print(target.type+" y");
					}
					if(linkedlist.Queen(target.col,target.row,target.type) == false){
						out.print(target.type+" n");
					}
				}

				if(target.type.equals("R") || target.type.equals("r")){
					if(linkedlist.Rook(target.col,target.row,target.type) == true){
						out.print(target.type+" y");
					}
					if(linkedlist.Rook(target.col,target.row,target.type) == false){
						out.print(target.type+" n");
					}
				}

				if(target.type.equals("B") || target.type.equals("b")){
					if(linkedlist.Bishop(target.col,target.row,target.type) == true){
						out.print(target.type+" y");
					}
					if(linkedlist.Bishop(target.col,target.row,target.type) == false){
						out.print(target.type+" n");
					}
				}

				if(target.type.equals("N") || target.type.equals("n")){
					if(linkedlist.Knight(target.col,target.row,target.type) == true){
						out.print(target.type+" y");
					}
					if(linkedlist.Knight(target.col,target.row,target.type) == false){
						out.print(target.type+" n");
					}
				}

				if(target.type.equals("P") || target.type.equals("p")){
					if(linkedlist.Pawn(target.col,target.row,target.type) == true){
						out.print(target.type+" y");
					}
					if(linkedlist.Pawn(target.col,target.row,target.type) == false){
						out.print(target.type+" n");
					}
				}
				linkedlist.resetHead();				//makes head equal to null
				out.println("");
			}

		}
		out.close();			//closes output stream
	}
}


