//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// queue.h
//-----------------------------------------------------------------------------
#ifndef _QUEUE_H_INCLUDE_
#define _QUEUE_H_INCLUDE_

#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
//all the funtions and structs needed for queueClient.c

// struct Node;

typedef struct NodeObj* Node;

typedef struct QueueObj* Queue;

Queue newQueue(void);

Node newNode(int num);

bool DequeueChecker(Queue q);

void Dequeue(FILE *out, Queue q);

void Enqueue(int newNum, Queue q);

void Print(FILE *out, Queue q);

#endif


