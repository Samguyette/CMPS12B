//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// charType.c
// The program two command input and output files then classifies the 
// characters on each line of the input file into the following categories:  
// alphabetic characters (upper or lower case), numeric characters (digits 0-9), 
// punctuation, and white space (space, tab, or newline).  
//-----------------------------------------------------------------------------
#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

void extract_chars(char* s, char* a, char* d, char* p, char* w);		//prototype?

int main(int argc, char* argv[]){
	FILE* in;		//in file
	FILE* out;		//out file
	char *a;
	char *d;
	char *p;
	char *w;

	int lineNum = 1;
	char input[256];

	//makes sure command line unput is correct if not error
	if(argc != 3){
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	//opens reading file
	in = fopen(argv[1], "r"); // "r" for read input file
	if(in == NULL){															//lines 19-38 taken from my lab 3
		printf("Unable to read file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	//opens writing file
	out = fopen(argv[2], "w"); // "w" for writing output file
	if(out == NULL){
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}

	//
	while(!feof(in)){  //f stands for file
		fscanf(in, "%[^\n]\n", input);					//scans one line in at a time and converts to string
		fprintf(out,"line %d contains:\n",lineNum);		//prints line numbers to out file
		lineNum++;										//increments the current line number 

		a = calloc(strlen(input), sizeof(char));
		d = calloc(strlen(input), sizeof(char));		//builds arrays of size input.length
		p = calloc(strlen(input), sizeof(char));		//for alphabetic chars), numeric chars, punctuation,
		w = calloc(strlen(input), sizeof(char));		//and white space (space, tab, or newline)

		extract_chars(input, a, d, p, w);				//calls extract_chars function
		
		if(strlen(a) == 1){
			fprintf(out,"%ld alphabetic character: %s\n", strlen(a), a);
		}
		else{
			fprintf(out,"%ld alphabetic characters: %s\n", strlen(a), a);			//prints out length and contents of each array			
		}
		//
		if(strlen(d) == 1){
			fprintf(out,"%ld numeric character: %s\n", strlen(d), d);
		}
		else{
			fprintf(out,"%ld numeric characters: %s\n", strlen(d), d);			//if and else statements for singular and plural issues		
		}
		//
		if(strlen(p) == 1){
			fprintf(out,"%ld punctuation character: %s\n", strlen(p), p);
		}
		else{
			fprintf(out,"%ld punctuation characters: %s\n", strlen(p), p);			
		}	
		//
		if(strlen(w) == 0){	
			fprintf(out,"%ld whitespace character: %s\n", strlen(w)+1, w);		
		}
		else{
			fprintf(out,"%ld whitespace characters: %s\n", strlen(w)+1, w);			
		}	

		fprintf(out,"\n");

		free(a);								//de-allocates memory of all the arrays on current line
		free(d);								//in preperation for next iteration
		free(p);
		free(w);
		a = NULL;
		d = NULL;
		p = NULL;
		w = NULL;
	}

	
	//closes files
	fclose(in);
	fclose(out); 
	//close program
	return(EXIT_SUCCESS);
}

void extract_chars(char* input, char* a, char* d, char* p, char* w){
	int aIndex = 0;
	int dIndex = 0;						
	int pIndex = 0;
	int wIndex = 0;

	for(int i = 0; i < strlen(input); i++){
		if(isalpha(input[i])){
			a[aIndex] = input[i];					//indexs are incremented ever time element
			aIndex++;								//is placed in array
		}

		if(isdigit(input[i])){
			d[dIndex] = input[i];					//input is set equal to the first avaliable
			dIndex++;								//place in array if isX tests true
		}

		if(ispunct(input[i])){
			p[pIndex] = input[i];
			pIndex++;
		}
		if(isspace(input[i])){
			w[wIndex] = input[i];
			wIndex++;
		}
	}
}


