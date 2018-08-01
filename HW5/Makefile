#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = Bard.java WordObject.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = Bard
CLASSES    = Bard.class WordObject.class
JARFILE    = Bard.jar

all: $(JARFILE)
 
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)







