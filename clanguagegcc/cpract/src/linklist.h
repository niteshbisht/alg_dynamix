/*
 * linklist.c
 *
 *  Created on: 30-May-2016
 *      Author: nitesh
 */

#include<stdio.h>
#include<stdlib.h>
#ifndef LINKLIST_H_
#define LINKLIST_H_

#endif /* LINKLIST_H_ */
typedef struct node {
	struct node *nlink;
	struct node *plink;
	int data;
} M_NODE;

M_NODE* createHeadNode() {
	M_NODE* headNode = malloc(sizeof(M_NODE));
	headNode->nlink = NULL;
	headNode->plink = NULL;
	headNode->data = -1;
	return headNode;
}

M_NODE* createDataNode(int data) {
	M_NODE* dataNode = malloc(sizeof(M_NODE));
	dataNode->data = data;
	return dataNode;
}

void addNodeAtEnd(M_NODE* startNode, M_NODE* dataNode) {
	M_NODE* temp = startNode;
	while (temp->nlink != NULL) {
		temp = temp->nlink;
	}

	temp->nlink = dataNode;
	dataNode->plink = temp;
}

void addNodeAtAfter(M_NODE* startNode, M_NODE* afterNode, M_NODE* dataNode) {
	M_NODE* temp = startNode;
	M_NODE* tempLink;
	while (temp->nlink != NULL) {
		if (temp->nlink == afterNode)
			break;
		temp = temp->nlink;
	}

	tempLink = temp->nlink;
	dataNode->plink = temp;
	dataNode->nlink = tempLink;
	temp->nlink = dataNode;
	tempLink->plink = dataNode;

}

void addNodeAtBeginning(M_NODE* startNode, M_NODE* dataNode) {
	M_NODE* temp = startNode->nlink;
	temp->plink = dataNode;
	startNode->nlink = dataNode;
	dataNode->plink = startNode;
	dataNode->nlink = temp;
}

