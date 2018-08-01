#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = ChessBoard.java LinkedList.java Node.java Piece.java Pawn.java King.java Queen.java Rook.java Bishop.java Knight.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = ChessBoard
CLASSES    = ChessBoard.class LinkedList.class Node.class Piece.class Pawn.class King.class Queen.class Rook.class Bishop.class Knight.class
JARFILE    = ChessBoard.jar

all: $(JARFILE)
 
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)







