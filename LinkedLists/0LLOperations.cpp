#include <bits/stdc++.h>

using namespace std;

struct Node{
    int val;
    Node* next;
    Node(int x){
        val = x;
        next = NULL;
    }
};

void insertFirst(Node* &head, int x){
    Node* newNode = new Node(x);
    if(head == NULL){
        head = newNode;
    }
    else{
        newNode->next = head;
        head = newNode;
    }
}

void insertLast(Node* head, int x){
    Node* newNode = new Node(x);
    Node* curr = head;
    while(curr->next){
        curr = curr->next;
    }
    curr->next = newNode;
}

void insertatK(Node* head, int k, int x){
    if(k == 0){
        insertFirst(head, x);
    }
    Node* temp = head;
    int i = 1;
    for(i = 1; i < k && temp->next; i++){
        temp = temp->next;
    }
    if(temp->next == NULL && i == k){
        insertLast(head, x);
    }
    else if(temp->next == NULL){
        cout << "Invalid Index\n";
        return;
    }
    Node* newNode = new Node(x);
    Node* tempp = temp->next;
    temp->next = newNode;
    newNode->next = tempp;
}

void display(Node* head){
    Node* curr = head;
    while(curr){
        cout << curr->val << " ";
        curr = curr->next;
    }
    cout << "\n"; 
}

void deleteatK(Node** head, int index){
    Node* temp = *head;
    int i = 1;
    if(index == 0){
        *head = (*head)->next;
        free(temp);
        return;
    }

    for(; i < index && temp; i++){
        temp = temp->next;
    }
    
    if(temp == NULL || temp->next == NULL){
        cout <<"Index out of bound\n";
        return;
    }

    Node* next = temp->next->next;
    free(temp->next);
    temp->next = next;
}

int main(){
    // 4 17 3 5 15 
    Node* head = new Node(5);
    insertFirst(head, 3);
    insertFirst(head, 4);
    insertLast(head, 15);
    insertatK(head, 5, 11);
    insertatK(head, 1, 17);
    display(head);
    deleteatK(&head, 0);
    display(head);
    deleteatK(&head, 3);
    display(head);
    deleteatK(&head, 3);
    display(head);
}