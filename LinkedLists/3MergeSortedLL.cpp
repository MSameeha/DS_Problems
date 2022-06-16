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

void print(Node* root){
    Node *curr = root;
    while(curr){
        cout << curr->data << " ";
        curr = curr->next;
    }
    cout << "\n";
}

Node* merge(Node* l1, Node* l2){
    if(l1 == NULL) return l2;
    if(l2 == NULL) return l1;

    if(l1->data > l2->data) swap(l1, l2);

    Node* res = l1;
    while(l1 && l2){
        Node* temp = NULL;
        while(l1 && l1->data <= l2->data){
            temp = l1;
            l1 = l1->next;
        }
        temp->next = l2;
        swap(l1, l2);
    }
    print(res);
    return res;
}

int main(){
    Node* l1 = new Node(5);
    l1->next = new Node(9);
    l1->next->next = new Node(10);
    l1->next->next->next = new Node(22);
    l1->next->next->next->next = new Node(23);

    Node* l2 = new Node(2);
    l2->next = new Node(7);
    l2->next->next = new Node(18);
    l2->next->next->next = new Node(29);
    l2->next->next->next->next = new Node(29);

    Node* head = merge(l1, l2);
    print(head);
}