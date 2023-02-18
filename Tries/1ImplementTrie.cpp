#include <bits/stdc++.h>
using namespace std;

struct Node{
    Node* links[26];
    bool flag = false;

    bool containsKey(char ch){
        return (links[ch-'a'] != NULL);
    }

    void put(char ch, Node* node){
        links[ch - 'a'] = node;
    }

    Node* get(char ch){
        return links[ch - 'a'];
    }

    void setEnd(){
        flag = true;
    }

    bool isEnd(){
        return flag;
    }
};

class Trie{
    private: 
        Node* root;
    public: 
        Trie(){
            root = new Node();
        }

        void insert(string word){
            Node* node = root;
            for(int i = 0; i < word.length(); i++){
                if(!node->containsKey(word[i])){
                    node->put(word[i], new Node());
                }
                node = node->get(word[i]);
            }
            node->setEnd();
        }

        bool search(string word){
            Node* node = root;
            for(int i = 0; i < word.length(); i++){
                if(!node->containsKey(word[i]))
                    return false;
                node = node->get(word[i]);
            }
            return node->isEnd();
        }

        bool searchwith(string prefix){
            Node* node = root;
            for(int i = 0; i < prefix.length(); i++){
                if(!node->containsKey(prefix[i]))
                    return false;
                node = node->get(prefix[i]);
            }
            return true;
        }
};

int main(){
    Trie* obj = new Trie();
    obj->insert("apple");
    obj->insert("apps");
    obj->insert("apxl");
    obj->insert("bac");
    obj->insert("bat");

    cout << "Does 'apxl' exist?" << obj->search("apxl") << "\n";
    cout << "Does 'appl' exist?" << obj->search("appl") << "\n";
    cout << "Is there a word that starts with 'appl'?" << obj->searchwith("appl") << "\n";
    cout << "Does 'bar' exist?" << obj->search("bar") << "\n";
    cout << "Is there a word with 'ba'?" << obj->searchwith("ba") << "\n";
}