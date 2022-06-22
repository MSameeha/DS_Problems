#include <bits/stdc++.h>

using namespace std;

int maxprofit(vector <int> vec, int n){
    int res = 0, mi = vec[0];
    for(int i = 0; i < n; i++){
        mi = min(mi, vec[0]);
        if(vec[i] > mi){
            res = max(res, vec[i]-mi);
        }
    }
    return res;
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
    cout << maxprofit(vec, n) << "\n";
}