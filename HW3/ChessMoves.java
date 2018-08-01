//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// chessMoves.java  
// Stores a chessboard as a linked list of chess pieces, implement moves from 
// input file, and determine if king of opposite colors is under attack.
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Character;

class ChessMoves{
	
	public static void main(String args[]) throws IOException{
		if(args.length < 2){
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1); 
		}

		Scanner in = new Scanner(new File (args[0]));
		PrintWriter out = new PrintWriter(new File (args[1]));
		String data = "";
		String frontSubData = "";
		String tempBackSubData = "";
		String backSubData = "";

		while(in.hasNextLine()){
			data = in.nextLine();
			int breaker = data.indexOf(":");

			if(breaker != -1){
				frontSubData = data.substring(0, breaker);		//creates a string of the first part of the input
			}													//stores it in frontSubData

			tempBackSubData = data.substring(data.lastIndexOf(":"));	//creates string of second part of the input
			backSubData = tempBackSubData.replace(": ", "");			//stores it in backSubData	
			
			String dataArray[] = frontSubData.split(" ");

			LinkedList linkedlist = new LinkedList();					//creates linkedlist

			int counter = 0;
			String type; 		
			int col;
			int row;

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
				// if(type.equals("p")){
				// 	Piece newPawn = new Pawn();
				// 	newPawn.setCol(col);			//creates new black night
				// 	newPawn.setRow(row);
				// 	newPawn.setType(type);
											
				// 	linkedlist.insertAtStart(newPawn);	//places that object in linked list
				// }
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
				// if(type.equals("P")){
				// 	Piece newPawn = new Pawn();
				// 	newPawn.setCol(col);			//creates new black night
				// 	newPawn.setRow(row);
				// 	newPawn.setType(type);
											
				// 	linkedlist.insertAtStart(newPawn);	//places that object in linked list
				// }
			}

			String movementArray[] = backSubData.split(" ");	
			int counter2 = 0;
			int alternate = 0;
			boolean moveLegal = true;
			int bwCounter = 0;
			while(counter2 < movementArray.length){
				int currentX = Integer.parseInt(movementArray[counter2]);
				counter2++;
				int currentY = Integer.parseInt(movementArray[counter2]);
				counter2++;
				int newX = Integer.parseInt(movementArray[counter2]);
				counter2++;
				int newY = Integer.parseInt(movementArray[counter2]);
				counter2++;

				Piece currentPiece = new Piece();
				Piece newPiece = new Piece();
				char currentColor = 's';
				char newPieceColor = 's';
				currentPiece = LinkedList.FindPiece(currentX, currentY);
				boolean isCurrentBlack = false;			//initializes variables to hold piece colors
				boolean isNewBlack = false;

				if(LinkedList.Find(currentX,currentY) == false && moveLegal == true){
					out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
					moveLegal = false;													//insures there is a piece in spot to move
				}

				if(moveLegal == true){
					currentColor = currentPiece.type.charAt(0);
					isCurrentBlack = Character.isUpperCase(currentColor);				//finds color of piece being moved
				} 

				if(LinkedList.Find(newX,newY) && moveLegal == true){					//checks if theres a piece in move site
					newPiece = LinkedList.FindPiece(newX, newY);
					
					newPieceColor = newPiece.type.charAt(0);
					isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site

					if(isCurrentBlack == true && isNewBlack == true && moveLegal == true){					//checks if piece in move site is same color
						out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
						moveLegal = false;
					}
					if(isCurrentBlack == false && isNewBlack == false && moveLegal == true){				//checks if piece in move site is same color
						out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
						moveLegal = false;
					}
				}

				if(isCurrentBlack == true && moveLegal == true){
					alternate = alternate + 1;
				}											//insures that piece moves are white black white black...
				if(isCurrentBlack == false && moveLegal == true){
					alternate = alternate - 1;
				}
				if(alternate != -1 && alternate != 0 && moveLegal == true){
					out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
					moveLegal = false;
				}

				//System.out.println("This move is legal: "+moveLegal);
				if(moveLegal == true){		//makes sure move is legal
					newPiece = LinkedList.FindPiece(newX, newY);

					//*****Checks if pieces can move to move sites legally*****//
					
					if(currentPiece.type.equals("K")){			
						if(King.isLegal(currentX, currentY, newX, newY)){							
							//if(King.checkPath(currentX, currentY, newX, newY)){							//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newKing = new King();			//creates new pieces at new spot
								newKing.setCol(newX);			
								newKing.setRow(newY);
								newKing.setType(currentPiece.type);									
								linkedlist.insertAtStart(newKing);	//places new piece in spot	
							//}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					if(currentPiece.type.equals("Q")){
						if(Queen.isLegal(currentX, currentY, newX, newY)){
							if(Queen.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newQueen = new Queen();			//creates new pieces at new spot
								newQueen.setCol(newX);			
								newQueen.setRow(newY);
								newQueen.setType(currentPiece.type);									
								linkedlist.insertAtStart(newQueen);	//places new piece in spot
							}
							else{
								if(moveLegal == true){
									out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
									moveLegal = false;
								}
							}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					if(currentPiece.type.equals("R")){
						if(Rook.isLegal(currentX, currentY, newX, newY)){
							if(Rook.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newRook = new Rook();			//creates new pieces at new spot
								newRook.setCol(newX);			
								newRook.setRow(newY);
								newRook.setType(currentPiece.type);									
								linkedlist.insertAtStart(newRook);	//places new piece in spot	
							}
							else{
								if(moveLegal == true){
									out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
									moveLegal = false;
								}
							}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					if(currentPiece.type.equals("B")){
						if(Bishop.isLegal(currentX, currentY, newX, newY)){
							if(Bishop.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newBishop = new Bishop();			//creates new pieces at new spot
								newBishop.setCol(newX);			
								newBishop.setRow(newY);
								newBishop.setType(currentPiece.type);									
								linkedlist.insertAtStart(newBishop);	//places new piece in spot	
							}
							else{
								if(moveLegal == true){
									out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
									moveLegal = false;
								}
							}	
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					if(currentPiece.type.equals("N")){
						if(Knight.isLegal(currentX, currentY, newX, newY)){															
							if(LinkedList.Find(newX, newY)){
								newPiece = LinkedList.FindPiece(newX, newY);
								newPieceColor = newPiece.type.charAt(0);
								isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
								if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
									LinkedList.Delete(newPiece);
								}
								if(isCurrentBlack == false && isNewBlack == true){
									LinkedList.Delete(newPiece);																
								}
							}
							LinkedList.Delete(currentPiece);	//deletes current piece									
							Piece newKnight = new Knight();			//creates new pieces at new spot
							newKnight.setCol(newX);			
							newKnight.setRow(newY);
							newKnight.setType(currentPiece.type);									
							linkedlist.insertAtStart(newKnight);	//places new piece in spot
						}				
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					// if(currentPiece.type.equals("P")){


					// }

					if(currentPiece.type.equals("k")){
						if(King.isLegal(currentX, currentY, newX, newY)){
							//if(King.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
							if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}				
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newKing = new King();			//creates new pieces at new spot
								newKing.setCol(newX);			
								newKing.setRow(newY);
								newKing.setType(currentPiece.type);									
								linkedlist.insertAtStart(newKing);	//places new piece in spot
							//}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}
					if(currentPiece.type.equals("q")){
						if(Queen.isLegal(currentX, currentY, newX, newY)){	
							if(Queen.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newQueen = new Queen();			//creates new pieces at new spot
								newQueen.setCol(newX);			
								newQueen.setRow(newY);
								newQueen.setType(currentPiece.type);									
								linkedlist.insertAtStart(newQueen);	//places new piece in spot
							}
							else{
								if(moveLegal == true){
									out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
									moveLegal = false;
								}
							}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					if(currentPiece.type.equals("r")){
						if(Rook.isLegal(currentX, currentY, newX, newY)){
							if(Rook.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){					// to the move site
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newRook = new Rook();			//creates new pieces at new spot
								newRook.setCol(newX);			
								newRook.setRow(newY);
								newRook.setType(currentPiece.type);									
								linkedlist.insertAtStart(newRook);	//places new piece in spot
							}
							else{
								if(moveLegal == true){
									out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
									moveLegal = false;
								}
							}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}

					if(currentPiece.type.equals("b")){
						if(Bishop.isLegal(currentX, currentY, newX, newY)){
							if(Bishop.checkPath(currentX, currentY, newX, newY)){		//checks if piece can legally move 									
								if(LinkedList.Find(newX, newY)){
									newPiece = LinkedList.FindPiece(newX, newY);
									newPieceColor = newPiece.type.charAt(0);
									isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
									if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
										LinkedList.Delete(newPiece);
									}
									if(isCurrentBlack == false && isNewBlack == true){
										LinkedList.Delete(newPiece);																
									}
								}
								LinkedList.Delete(currentPiece);	//deletes current piece									
								Piece newBishop = new Bishop();			//creates new pieces at new spot
								newBishop.setCol(newX);			
								newBishop.setRow(newY);
								newBishop.setType(currentPiece.type);									
								linkedlist.insertAtStart(newBishop);	//places new piece in spot		
							}
							else{
								if(moveLegal == true){
									out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
									moveLegal = false;
								}
							}
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}

					}

					if(currentPiece.type.equals("n")){
						if(Knight.isLegal(currentX, currentY, newX, newY)){									
							if(LinkedList.Find(newX, newY)){
								newPiece = LinkedList.FindPiece(newX, newY);
								newPieceColor = newPiece.type.charAt(0);
								isNewBlack = Character.isUpperCase(newPieceColor);					//finds color of piece in move site
								if(isCurrentBlack == true && isNewBlack == false){					//checks if piece in move site is same color
									LinkedList.Delete(newPiece);
								}
								if(isCurrentBlack == false && isNewBlack == true){
									LinkedList.Delete(newPiece);																
								}
							}
							LinkedList.Delete(currentPiece);	//deletes current piece									
							Piece newKnight = new Knight();			//creates new pieces at new spot
							newKnight.setCol(newX);			
							newKnight.setRow(newY);
							newKnight.setType(currentPiece.type);									
							linkedlist.insertAtStart(newKnight);	//places new piece in spot
						}
						else{
							if(moveLegal == true){
								out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
								moveLegal = false;
							}
						}
					}
					
					// if(currentPiece.type.equals("p")){


					// }
					//****** Checks if King of same color as most recent move can be attaked ******//
					bwCounter++;
					if(bwCounter%2 == 0){	
						if(LinkedList.isBlackKingUnderAttack() && moveLegal){
							out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
							moveLegal = false;
						}
					}
					if(bwCounter%2 == 1){
						if(LinkedList.isWhiteKingUnderAttack() && moveLegal){
							out.println(currentX+" "+currentY+" "+newX+" "+newY+" illegal");
							moveLegal = false;
						}
					}
				}
			}
			if(moveLegal == true){
				out.println("legal");
			}

			linkedlist.resetHead();				//makes head equal to null
			//out.println("");
		}
		out.close();			//closes output stream
	}	
}


