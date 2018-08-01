//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// queueClient.c 
//-----------------------------------------------------------------------------
#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<assert.h>
#include"queue.h"


int main(int argc, char* argv[]){

	FILE* in;		//in file
	FILE* out;		//out file
	FILE* inTemp;

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

		//opens reading file
	inTemp = fopen(argv[1], "r"); // "r" for read input file
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

	char type[10];
	char data[10];
	int lineCounter = 0;
	int ch = 0;
	while(!feof(inTemp)){
		ch = fgetc(inTemp);
 		if(ch == '\n'){
  			lineCounter++;
  		}
	}
	Queue final = newQueue();
	while(lineCounter > 0){  //f stands for file
		fscanf(in, "%s", type);
		if(*type == 'e'){
			fscanf(in, "%s", data);
			int dataInt = atoi(data);
			Enqueue(dataInt, final);
			fprintf(out, "enqueued %s\n", data);
		}

		if(*type == 'd'){
			Dequeue(out, final);
		}

		if(*type == 'p'){
			Print(out, final);				//prints out current queue
			fprintf(out, "\n");
		}
		lineCounter--;
	}

	//closes files
	fclose(in);
	fclose(out); 
	//close program
	return(EXIT_SUCCESS);
}