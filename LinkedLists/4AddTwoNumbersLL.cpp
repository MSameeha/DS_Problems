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

Node* add(Node* n1, Node* n2){
    if(n1 == NULL) return n2;
    if(n2 == NULL) return n1;

    Node* curr = NULL, *head;
    int carry = 0;

    while(n1 && n2){
        int val = n1->data + n2->data + carry;

        if(val/10 != 0){
            carry = val/10;
            val = val%10;
        }else{
            carry = 0;
        }

        Node* temp = new Node(val);
        if(curr == NULL){
            curr = temp;
            head = curr;
        }else{
            curr->next = temp;
            curr = curr->next;
        }
        n1 = n1->next;
        n2 = n2->next;
    }

    while(n1){
        int val = n1->data + carry;
        if(val/10 != 0){
            carry = val/10;
            val = val%10;
        }else{
            carry = 0;
        }
        Node* temp = new Node(val);
        curr->next = temp;
        curr = curr->next;
        n1 = n1->next;
    }

    while(n2){
        int val = n2->data + carry;
        if(val/10 != 0){
            carry = val/10;
            val = val%10;
        }else{
            carry = 0;
        }
        Node *temp = new Node(val);
        curr->next = temp;
        curr = curr->next;
        n2 = n2->next;
    }

    while(carry){
        int val = carry%10;
        carry = carry/10;
        Node* temp = new Node(val);
        curr->next = temp;
        curr = curr->next;
    }

    return head;
}

int main(){
    Node* n1 = new Node(5);
    n1->next = new Node(1);
    n1->next->next = new Node(0);
    n1->next->next->next = new Node(9);

    Node* n2 = new Node(6);
    n2->next = new Node(7);
    n2->next->next = new Node(3);
    n2->next->next->next = new Node(9);

    Node* head = add(n1, n2);
    print(head);
}
 
// //TC: 
// 5 1 0 9 
// 6 7 3 9 
// Expected output: 1 9 3 0 8 1