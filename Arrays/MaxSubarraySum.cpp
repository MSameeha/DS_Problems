//Kadane's algo

#include <bits/stdc++.h>
using namespace std;

int maxsum(vector <int> vec, int n){
    int sum = 0, res = 0;
    for(int i = 0; i < n; i++){
        sum += vec[i];
        res = max(res, sum);
        if(sum < 0){
            sum = 0; //new subarray
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
    cout << maxsum(vec, n) << "\n";
}