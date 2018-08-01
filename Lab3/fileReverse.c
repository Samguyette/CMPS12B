//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// fileReverse.c
// The program takes two command line arguments input and output. It reads 
// each word in the input file, then print it backwards on a line by itself 
// into the output file.
//-----------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void stringReverse(char* s){
	int length = strlen(s) - 1;
	char temp;

	for(int i = 0; i < length; i++){
		temp = s[length];
		s[length] = s[i];
		s[i] = temp;
		length--;
	}
}

int main(int argc, char* argv[]){
	FILE* in;		//in file
	FILE* out;		//out file
	char word[256];

	//makes sure command line unput is correct if not error
	if(argc != 3){
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	in = fopen(argv[1], "r"); // "r" for read input file
	if(in == NULL){
		printf("Unable to read file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	out = fopen(argv[2], "w"); // "w" for writing output file
	if(out == NULL){
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}

	//reads strings from input file and prints each on seperate line to output file
	while( fscanf(in, "%s", word) != EOF ){  		//f stands for file
		fprintf(out, "%s\n", word);
	}

	//closes files
	fclose(in);
	fclose(out);

	return(EXIT_SUCCESS);
}






