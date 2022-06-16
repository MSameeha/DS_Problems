//If two middle elements are present it gives the value of second middle element

#include <bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    Node* next;
    Node(int x){
        data = x;
        next = NULL;
    }
};

void middle(Node* head){
    Node* fast = head, *slow = head;

    while(fast && fast->next){
        slow = slow->next;
        fast = fast->next->next;
    } 
    cout << slow->data << "\n";
}

int main(){
    Node* head = new Node(10);
    head->next = new Node(20);
    head->next->next = new Node(30);
    head->next->next->next = new Node(40);
    head->next->next->next->next = new Node(50);

    middle(head);
}