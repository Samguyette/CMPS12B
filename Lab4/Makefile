# Make file for charType.c
charType : charType.o
	gcc -o charType charType.o

charType.o : charType.c
	gcc -c –std=c99 -Wall charType.c

check:
	valgrind --leak-check=full charType infile outfile

clean :
	rm -f charType charType.o