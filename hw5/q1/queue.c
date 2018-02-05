//Jacob Vargo

#include <stdlib.h>

typedef struct{
	void **list;
	int front;
	int size;
	int maxSize;
} Queue;

void *queue_new(int numItems){
	//create a queue that can hold the indicated number of items
	Queue *q;
	q = (Queue *) malloc(sizeof(Queue));
	q->front = 0;
	q->size = 0;
	q->maxSize = numItems;
	q->list = (void **) malloc(sizeof(void *) * numItems);
	return (void *)q;
}

void queue_enqueue(void *queue, void *item){
	//add the element to the back of the queue
	Queue *q = queue;
	if (q->size >= q->maxSize) return;
	q->list[(q->front + q->size) % q->maxSize] = item;
	q->size++;
}

void *queue_dequeue(void *queue){
	//remove and return the element at the front of the queue
	void *rv;
	Queue *q = queue;
	rv = q->list[q->front];
	q->size--;
	q->front = (q->front+1) % q->maxSize;
	return rv;
}

int queue_isEmpty(void *q){
	//1 if empty and 0 otherwise
	if (((Queue *)q)->size == 0) return 1;
	return 0;
}
