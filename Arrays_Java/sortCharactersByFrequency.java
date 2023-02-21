import java.util.*;
import java.util.stream.Stream;

public class sortCharactersByFrequency {
    // public record Letter(char ch, int freq){

    // }

    // public String frequencySort(String s) {
    //     List<Letter> list = new ArrayList<>();
    //     HashMap<Character, Integer> frequency = new HashMap<>();

    //     for(char ch: s.toCharArray()){
    //         int freq = frequency.getOrDefault(ch, 0);
    //         freq++;
    //         frequency.put(ch, freq);
    //         list.add(new Student(ch, freq));
    //     }

    //     return list.stream().sorted(Comparator.comparing(Letter :: freq)).toString;
    // }  
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) +1);        //putting values in hash table
        }

        List<Character> letters = new ArrayList<>(freq.keySet());
        letters.sort((a, b) -> freq.get(b) - freq.get(a));    //sorting by frequency in descending order

        StringBuilder ans = new StringBuilder();
        for(char c : letters){
            for(int i = 0; i < freq.get(c); i++){
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
