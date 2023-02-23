package Queues;

import java.util.*;

class Item{
    int value;
    int label;
    Item(int value, int label){
        this.value = value;
        this.label = label;
    }
}

public class largestValuesFromlabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Item> pq = new PriorityQueue<>((i1, i2) -> i2.value - i1.value);
        HashMap<Integer, Integer> label_freq = new HashMap<>();

        for(int i = 0; i < values.length; i++){
            pq.add(new Item(values[i], labels[i]));
        }
        int ans = 0;

        for(int i = 0; i < numWanted;){
            Item it = pq.poll();
            if(label_freq.get(it.label) < useLimit){
                label_freq.put(it.label, label_freq.getOrDefault(it.label, 0)+1);
                i++;
                ans += it.value;
            }
        }
        return ans;
    }  
}
