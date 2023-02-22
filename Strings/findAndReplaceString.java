import java.util.*;

public class findAndReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> index_sorted = new ArrayList<>();
        
        for(int i = 0; i < indices.length; i++){
            index_sorted.add(new int[] {indices[i], i});
        }
        Collections.sort(index_sorted, Comparator.comparing(i -> -i[0]));

        for(int i = 0; i < index_sorted.size(); i++){
            String src = sources[index_sorted.get(i)[1]];
            String target = targets[index_sorted.get(i)[1]];

            if(src.equals(s.substring(index_sorted.get(i)[0], index_sorted.get(i)[0]+src.length()))){
                s = s.substring(0, index_sorted.get(i)[0]) + target + s.substring(index_sorted.get(i)[0]+src.length());
            }
        }

        return s;
    }
}
