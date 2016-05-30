/*
 ============================================================================
 Name        : cpract.c
 Author      : nitesh_bisht
 Version     : 1.01
 Copyright   : this is a registered project
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "linklist.h"

int main(void) {
//	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	M_NODE* headNode = createHeadNode();
	M_NODE* dataNode = createDataNode(1);
	M_NODE* visitingNode = headNode;
	M_NODE* beforeNode = NULL;

	int ctr=0;
	addNodeAtEnd(headNode, dataNode);
	dataNode = createDataNode(2);
	addNodeAtEnd(headNode, dataNode);
	dataNode = createDataNode(3);
	addNodeAtEnd(headNode, dataNode);
	beforeNode = dataNode;

	dataNode = createDataNode(4);
	addNodeAtEnd(headNode,dataNode);

	dataNode = createDataNode(5);
	addNodeAtBefore(headNode,beforeNode,dataNode);

	while (visitingNode->nlink != NULL) {
		visitingNode=visitingNode->nlink;
		printf("%s %d %d","nodeId = ",++ctr,visitingNode->data);
		printf("%s","\n");
	}

	return EXIT_SUCCESS;
}
