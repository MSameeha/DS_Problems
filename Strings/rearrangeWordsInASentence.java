import java.util.*;

public class rearrangeWordsInASentence {
    public static String arrangeWords(String text) {
        String[] arr = text.split(" ");
        arr[0] = arr[0].toLowerCase();
        Arrays.sort(arr, Comparator.comparing((raj->raj.length())));
        int i = 0;
        StringBuilder sb=new StringBuilder();
        for(i = 0; i < arr.length-1; i++){
            if(i == 0){
                arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
                sb.append(arr[i]);
                continue;
            }
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[i]);
        return sb.toString();
    }    
}
