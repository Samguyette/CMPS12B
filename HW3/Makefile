#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = ChessMoves.java LinkedList.java Node.java Piece.java King.java Queen.java Rook.java Bishop.java Knight.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = ChessMoves
CLASSES    = ChessMoves.class LinkedList.class Node.class Piece.class King.class Queen.class Rook.class Bishop.class Knight.class
JARFILE    = ChessMoves.jar

all: $(JARFILE)
 
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)







