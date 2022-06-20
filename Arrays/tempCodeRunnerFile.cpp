int findDuplicate(vector<int> &arr, int n){
	for(int i = 0; i < n; i++){
        if(arr[i] < 0){
            arr[(-1*arr[i])] = -1*arr[(-1*arr[i])];
            if((-1*arr[i]) > 0 && arr[(-1*arr[i])] > 0){
                cout << "HERE?\n";
                return -1*arr[i];
            }
        }else{
            arr[arr[i]] = -1*arr[arr[i]];
            if(arr[i] > 0 && arr[arr[i]] > 0){
                cout << "Yeah, " << i << " " << arr[i] << " " << arr[arr[i]] << "\n";
                return arr[i];
            }
        }
        cout << "After " << i << "th iteration, the array is: ";
        for(int j = 0; j < n; j++){
            cout << arr[j] << " ";
        }
        cout << "\n";
    }
    return -1;
}