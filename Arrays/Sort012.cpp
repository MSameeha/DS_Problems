//Dutch national flag algorithm

#include <bits/stdc++.h>
using namespace std;

void sortall(vector <int> &a, int n){
    int low = 0, mid = 0, high = n-1;
    for(int i = 0; i < n; i++){
        if(a[mid] == 0){
            swap(a[low], a[mid]);
            low++;
            mid++;
        }else if(a[mid] == 1){
            mid++;
        }else{
            swap(a[mid], a[high]);
            high--;
        }
    }
}

int main(){
    int n;
    cin >> n;
    vector <int> vec;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        vec.push_back(x);
    }
    sortall(vec, n);
    for(int i = 0; i < n; i++){
        cout << vec[i] << " ";
    }cout << "\n";
}