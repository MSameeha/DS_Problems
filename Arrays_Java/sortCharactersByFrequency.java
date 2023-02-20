import java.util.*;
import java.util.stream.Stream;

public class sortCharactersByFrequency {
    public record Letter(char ch, int freq){

    }

    public String frequencySort(String s) {
        List<Letter> list = new ArrayList<>();
        HashMap<Character, Integer> frequency = new HashMap<>();

        for(char ch: s.toCharArray()){
            int freq = frequency.getOrDefault(ch, 0);
            freq++;
            frequency.put(ch, freq);
            list.add(new Student(ch, freq));
        }

        return list.stream().sorted(Comparator.comparing(Letter :: freq)).toString;
    }    
}
