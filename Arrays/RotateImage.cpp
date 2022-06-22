#include <bits/stdc++.h>
using namespace std;
//Transpose and Reverse
void rotateMatrix(vector<vector<int>> &mat, int n, int m)
{
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            swap(mat[i][j], mat[j][i]);
        }
    }
    
    for(int i = 0; i < n; i++)
        reverse(mat[i].begin(), mat[i].end());

}

int main(){
    int n, m;
    cin >> n >> m;

    vector <vector <int> > mat;

    for(int i = 0; i < n; i++){
        vector <int> v;
        for(int j = 0; j < m; j++){
            int x; cin >> x;
            v.push_back(x);
        }
        mat.push_back(v);
    }

    rotateMatrix(mat, n, m);

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++)
            cout << mat[i][j] << " ";
        cout << "\n";
    }
    
}