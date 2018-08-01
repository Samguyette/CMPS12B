//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// LinkedLIst.java 
// LinkedList that stores Piece objects
//-----------------------------------------------------------------------------
public class LinkedList{

	Node head;

	public void insertAtStart(Piece data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
		}
		else{
			newNode.next = head;
			head = newNode;
		}
	}

	public boolean Invalid(){		//checks if there are two pieces placed in one spot
		boolean Invalid = false;
		int currentCol;
		int currentRow;
		int currentTesterCol;
		int currentTesterRow;
		int checkCounter;
		if(head != null){
			Node current = head;
			Node currentTester = head;
			while(current != null){
				currentCol = current.data.col;
				currentRow = current.data.row;
				currentTester = head;
				checkCounter = 0;
				
				while(currentTester != null){
				currentTesterCol = currentTester.data.col;
				currentTesterRow = currentTester.data.row;
					if(currentCol == currentTesterCol && currentRow == currentTesterRow){
						checkCounter++;			//has to equal a piece more than once because it enters for loop when 
						if(checkCounter > 1){	// it hits itself
							Invalid = true;
						}						
					}
					currentTester = currentTester.next;
				}
				current = current.next;
			}
		}
		return Invalid;
	}
	
	
	public boolean Find(int col, int row){		//checks if there is a piece in the spot of chosen location
		boolean doesExist = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				if(current.data.col == col && current.data.row == row){
					return true;
				}
				current = current.next;
			}
		}
		return doesExist;
	}

	public Piece FindPiece(int col, int row){		//checks if there is a piece in the spot of chosen location
		Piece temp = new Piece();
		if(head.next != null){
			Node current = head;
			while(current != null){
				if(current.data.col == col && current.data.row == row){
					temp = current.data;
				}
				current = current.next;
			}
		}
		return temp;
	}

	public boolean King(int xPos, int yPos, String type){
		boolean Attacking = true;
		boolean result = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece temp = new Piece();
				temp = current.data;
				if(Attacking = King.isAttacking(xPos, yPos, type, temp) == true){
					result = true;
				}
				current = current.next;
			}
		}
		return result;
	}

	public boolean Queen(int xPos, int yPos, String type){
		boolean Attacking = true;
		boolean result = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece temp = new Piece();
				temp = current.data;
				if(Attacking = Queen.isAttacking(xPos, yPos, type, temp) == true){
					result = true;
				}
				current = current.next;
			}
		}
		return result;
	}

	public boolean Rook(int xPos, int yPos, String type){
		boolean Attacking = true;
		boolean result = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece temp = new Piece();
				temp = current.data;
				if(Attacking = Rook.isAttacking(xPos, yPos, type, temp) == true){
					result = true;
				}
				current = current.next;
			}
		}
		return result;
	}

	public boolean Bishop(int xPos, int yPos, String type){
		boolean Attacking = true;
		boolean result = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece temp = new Piece();
				temp = current.data;
				if(Attacking = Bishop.isAttacking(xPos, yPos, type, temp) == true){
					result = true;
				}
				current = current.next;
			}
		}
		return result;
	}

	public boolean Knight(int xPos, int yPos, String type){
		boolean Attacking = true;
		boolean result = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece temp = new Piece();
				temp = current.data;
				if(Attacking = Knight.isAttacking(xPos, yPos, type, temp) == true){
					result = true;
				}
				current = current.next;
			}
		}
		return result;
	}

	public boolean Pawn(int xPos, int yPos, String type){
		boolean Attacking = true;
		boolean result = false;
		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece temp = new Piece();
				temp = current.data;
				if(Attacking = Pawn.isAttacking(xPos, yPos, type, temp) == true){
					result = true;
				}
				current = current.next;
			}
		}
		return result;
	}

	public void resetHead(){
		head = null;
	}
}










