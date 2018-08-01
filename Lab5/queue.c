//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// queue.c 
// Implements a Queue of ints in C and depending on commands Dequeues, Enqueues
// or prints, the Queue to an output file.
//-----------------------------------------------------------------------------
#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<assert.h>
#include"queue.h"

typedef struct NodeObj{			//node struct
	int data;
	struct NodeObj* next;
}NodeObj;

typedef struct QueueObj{
	Node front;		//global nodes to store the front and back references
	Node back;
}QueueObj;

Queue newQueue(void){
   Queue temp = malloc(sizeof(QueueObj));
   assert(temp != NULL );

	temp->front = NULL;		//global nodes to store the front and back references
	temp->back = NULL;
  	return temp;								 // initialize the fields of the Queue structure
}


Node newNode(int num){
	Node temp = malloc(sizeof(struct NodeObj));
	assert(temp!=NULL);
	temp->data = num;
	temp->next = NULL;	
	return temp;
}


int counter = 0;
void Dequeue(FILE *out, Queue q){
	Node temp = q->front;
	if((q->front == NULL) && (q->back == NULL)){		//checks if there is a front 
		fprintf(out, "empty\n");
		return;
	}
	if(q->front == q->back){
		fprintf(out, "%d\n", q->front->data);
		q->front = NULL;		//checks if theres only one element in list
		q->back = NULL;
	}
	if(q->front != q->back && q->front != NULL){
		fprintf(out, "%d\n", q->front->data);
		q->front = q->front->next;		//deletes the front node
	}
	counter--;
	free(temp);								//de-allocates memory of all the arrays on current line
	temp = NULL;								//in preperation for next iteration
}

void Enqueue(int newNum, Queue q){
	counter++;
	Node temp = newNode(newNum);

	if(q->front == NULL && q->back == NULL){		//checks if theres nothing in list
		q->front = temp;						//inserts first element 
		q->back = temp;
		return;
	}

	q->back->next = temp;						//insets element in the back of the list
	q->back = temp;
	return;									//prints out what was added
}


void Print(FILE *out, Queue q){						//prints the current queue
	Node temp = q->front;
	while(temp != NULL) {
		char str[12];
		int tempData = temp->data;
		
		sprintf(str, "%d", tempData);

		fprintf(out, "%s ",str);
		temp = temp->next;
	}
}

