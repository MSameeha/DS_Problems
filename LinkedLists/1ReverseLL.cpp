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

Node* reverse(Node* root){
    Node *curr = NULL;
    while(root){
        Node* next = root->next;
        root->next = curr;
        curr = root;
        root = next;
    }
    return curr;
}

void print(Node* root){
    Node *curr = root;
    while(curr){
        cout << curr->data << " ";
        curr = curr->next;
    }
    cout << "\n";
}

int main(){
    Node* root = new Node(5);
    root->next = new Node(3);
    root->next->next = new Node(10);
    root->next->next->next = new Node(22);
    root->next->next->next->next = new Node(13);
    cout << "Before Reversal\n";
    print(root);
    root = reverse(root);
    cout << "Reversed LL\n";
    print(root);
}