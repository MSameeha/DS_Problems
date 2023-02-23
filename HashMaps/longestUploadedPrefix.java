package HashMaps;

import java.util.*;

class LUPrefix {
    int maxo;
    HashMap<Integer, Integer> map;

    public LUPrefix(int n) {
        map = new HashMap<>();
        maxo = 0;    
    }
    
    public void upload(int video) {
        map.put(video, 1);
        while(map.containsKey(maxo+1)){
            maxo++;
        }
    }
    
    public int longest() {
        return maxo;
    }
}


public class longestUploadedPrefix {
    
}
