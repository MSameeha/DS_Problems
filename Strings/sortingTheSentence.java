import java.util.*;


public class sortingTheSentence {
    public String sortSentence(String s) {
        String[] splited = s.split(" ");
        String[] arr = new String[splited.length];
        StringBuilder sb = new StringBuilder(); 
        int i;

        for(String check : splited){
            i = (int) (check.charAt(check.length()-1) - '0');
            arr[i-1] = check.substring(0, check.length()-1);
            // System.out.println(str.substring(0, str.length()-1));
        }
        for (i = 0; i < arr.length - 1; i++)
            sb.append(arr[i]).append(" ");
        sb.append(arr[i]);
        return sb.toString();
    }  
}
