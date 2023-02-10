import java.util.*;

class Allocator {
    //Have two lists
    int[] mem_array, next_free;
    int N;

    public Allocator(int n) {
        N = n;
        mem_array = new int[N];
        next_free = new int[N];
        for(int i = 0; i < N; i++){
            mem_array[i] = -1;
            next_free[i] = N-i;
        }
    }
    
    public int allocate(int size, int mID) {
        int f = -1;
        for(int i = 0; i < N; i++){
            if(next_free[i] >= size){
                for(int j = 0; j < size; j++){
                    mem_array[i+j] = mID;
                    next_free[i+j] = 0; 
                }
                f = i;
                break;
            }
        }
        if(f == -1){
            return -1;
        }return f;
    }
    
    public int free(int mID) {
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(mem_array[i] == mID){
                mem_array[i] = -1;
                ans++;
            }
        }
        int c = 1;
        for(int i = N-1; i >= 0; i--){
            if(mem_array[i] == -1){
                next_free[i] = c;
                c++;
            }else{
                c = 1;
            }
        }
        return ans;
    }
}

public class designMemoryAllocator {

}


