#include <bits/stdc++.h>

using namespace std;

vector<int> nextGreater(vector<int> &arr, int n) {
    stack <int> stack;
    vector <int> ans;
    
    stack.push(arr[n-1]);
    ans.push_back(-1);
    
    for(int i = n-2; i >= 0; i--){
        while(!(stack.empty()) && stack.top() <= arr[i])
            stack.pop();
        if(stack.empty())
            ans.push_back(-1);
        else
            ans.push_back(stack.top());
        
        stack.push(arr[i]);
    }
    reverse(ans.begin(), ans.end());
    return ans;

}

int main(){
    int n; 
    cin >> n;
    vector <int> arr;
    for(int i = 0; i < n; i++){
        int x; cin >> x;
        arr.push_back(x);
    }
    vector <int> ans = nextGreater(arr, n);
    for(int i = 0; i < n; i++){
        cout << ans[i] << " ";
    }
    cout << "\n";
}