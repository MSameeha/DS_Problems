// only one element is repeated, all elements are in the range [1,N-1]

#include <bits/stdc++.h>

using namespace std;

int findDuplicate(vector<int> &arr, int n){
    for(int i = 0; i < n; i++){
        if(arr[i] < 0)
            arr[(-1*arr[i])] = -1*arr[(-1*arr[i])];
        else
            arr[arr[i]] = -1*arr[arr[i]];
 
        if(arr[i] > 0 && arr[arr[i]] > 0) return arr[i];
        
        if((-1*arr[i]) > 0 && arr[(-1*arr[i])] > 0) return -1*arr[i];
    }
    return -1;
}

int main(){
    int n;
    cin >> n;
    vector <int> arr;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        arr.push_back(x);
    }
    cout << "Repeated Element is " << findDuplicate(arr, n) << "\n";
}