//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// LinkedList.java 
// LinkedList that stores Piece objects
// Custom classes that take and add information from linkedlist
//-----------------------------------------------------------------------------
public class LinkedList{

	public static Node head;

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

	public static void Delete(Piece remove){
		int targetPosition = FindPosition(remove);
		if(head == null){		//checks if list is empty
			return;
		}
		Node temp = head;
		if(targetPosition == 0){
			head = temp.next;		//if piece is at the the head 
			return;					//remove head
		}
		for(int i = 0; temp != null && i < targetPosition - 1; i++){
			temp = temp.next;				//finds the privious node of node to be deleted
		}

		Node nextNode = temp.next.next;		//store pointer
		temp.next = nextNode;					//unlink target node
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
	
	
	public static boolean Find(int col, int row){		//checks if there is a piece in the spot of chosen location
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

	public static Piece FindPiece(int col, int row){		//checks if there is a piece in the spot of chosen location
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

	public static Piece FindPiece(char type){		//checks if there is a piece in the list of same type
		Piece temp = new Piece();
		if(head.next != null){
			Node current = head;
			while(current != null){
				char listType = current.data.type.charAt(0);
				if(listType == type){
					temp = current.data;
				}
				current = current.next;
			}
		}
		return temp;
	}


	public static int FindPosition(Piece target){
		int counter = 0;
		int counterTwo = 0;
		int result = 0;
		Node nodeCounter = head;
		Node nodeCounterTwo = head;

		while(nodeCounter != null){							//finds how many links until target
			if(nodeCounter.data.type == target.type && nodeCounter.data.col == target.col && nodeCounter.data.row == target.row){
				result = counter;		//subtracts total from links until target
			}
			counter++;	
			nodeCounter = nodeCounter.next;
		}
		return result;
	}

	public static void Display(){
		if(head == null){
			return;
		}
		Node current = head;
		while(current != null){
			System.out.println(current.data.type+" "+current.data.col+" "+current.data.row);
			current = current.next;
		}
	}

	public static boolean isBlackKingUnderAttack(){
		boolean result = false;
		Piece target = new Piece();
		target = FindPiece('K');

		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece potentialAttacker = new Piece();
				potentialAttacker = current.data;
				char potentialAttackerType = potentialAttacker.type.charAt(0);
				
				if(potentialAttackerType == 'k'){
					if(King.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(King.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}
				}
				
				if(potentialAttackerType == 'q'){
					if(Queen.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(Queen.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}
				}
				
				if(potentialAttackerType == 'r'){
					if(Rook.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(Rook.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}		
				}
				
				if(potentialAttackerType == 'b'){
					if(Bishop.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(Bishop.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}		
				}
				
				if(potentialAttackerType == 'n'){
					if(Knight.isAttacking(target.col, target.row, potentialAttacker) == true){
						result = true;
					}		
				}
				
				current = current.next;
			}
		}
		return result;
	}


	public static boolean isWhiteKingUnderAttack(){
		boolean result = false;
		Piece target = new Piece();
		target = FindPiece('k');

		if(head.next != null){
			Node current = head;
			while(current != null){
				Piece potentialAttacker = new Piece();
				potentialAttacker = current.data;
				char potentialAttackerType = potentialAttacker.type.charAt(0);
				
				if(potentialAttackerType == 'K'){
					if(King.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(King.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}
				}
				
				if(potentialAttackerType == 'Q'){
					if(Queen.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(Queen.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}
				}
				
				if(potentialAttackerType == 'R'){
					if(Rook.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(Rook.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}		
				}
				
				if(potentialAttackerType == 'B'){
					if(Bishop.isAttacking(target.col, target.row, potentialAttacker) == true){
						if(Bishop.checkPath(target.col, target.row, potentialAttacker.col, potentialAttacker.row)){
							result = true;
						}
					}		
				}
				
				if(potentialAttackerType == 'N'){
					if(Knight.isAttacking(target.col, target.row, potentialAttacker) == true){
						result = true;
					}		
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










