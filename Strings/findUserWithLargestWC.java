import java.util.*;

public class findUserWithLargestWC {

    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();

        int n = messages.length, max_wc = 0;
        for(int i = 0; i < n; i++){
            int y = messages[i].split(" ").length;
            map.merge(senders[i], y, (oldValue, newValue) -> oldValue + newValue);
            max_wc = Math.max(max_wc, map.merge(senders[i], y, (oldValue, newValue) -> oldValue + newValue));
            /*https://www.programiz.com/java-programming/library/hashmap/merge */
        }
        String ans = "";
        for(var it: map.entrySet()){
            if(it.getValue() == max_wc && (ans.compareTo(it.getKey()) < 0)){
                ans = it.getKey();
            }
        }
        return ans;
    }
    public static void main(String[] args){

    }
}
