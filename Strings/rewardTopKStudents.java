import java.util.*;
//BRUTE - FORCE SOLUTION
public class rewardTopKStudents {
    public static ArrayList sort_by_value(ArrayList al) {
        // 		Sorting ArrayList on the basis of values 
        
        Collections.sort(al, new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return ((Map.Entry<Integer, Integer>) o2).getValue()
                                .compareTo(((Map.Entry<Integer, Integer>) o1).getValue());
                    }
                });
                return al;
    }

    public static ArrayList transfer_elements(ArrayList al, HashMap<Integer, Integer> mp) {
		// insert element of map into arraylist
		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			al.add(entry);
		}
		return al;

	}

    private int countOccurences(String string, String string2) {
        return 0;
    }     
    public static int countOccurrences(String str, String word)
    {
        // split the string by spaces in a
        String a[] = str.split(" ");
    
        // search for pattern in a
        int count = 0;
        for (int i = 0; i < a.length; i++)
        {
        // if match found increase count
        if (word.equals(a[i]))
            count++;
        }
    
        return count;
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashMap <Integer, Integer> ranking = new HashMap<>(); //ID - POINTS
        //WILL SORT BASED ON VALUE THEN RETURN ID

        for(int i = 0; i < report.length; i++){
            ranking.put(student_id[i], 0);

            //First we check if report[i] has any negative_feedback word -> check if a word exists in a string
            //if yes, then points - 1
            for(int j = 0; j < negative_feedback.length; j++){
                if(report[i].contains(negative_feedback[j])){
                    int x = ranking.get(student_id[i]);
                    int y = countOccurences(report[i], negative_feedback[i]);
                    ranking.put(student_id[i], x-y);
                }
            }

            for(int j = 0; j < positive_feedback.length; j++){
                if(report[i].contains(positive_feedback[j])){
                    int x = ranking.get(student_id[i]);
                    int y = countOccurences(report[i], negative_feedback[i]);
                    ranking.put(student_id[i], x+3);
                }
            }
        }
        ArrayList list = new ArrayList<>();

        list = transfer_elements(list, ranking);
        list = sort_by_value(list);

        List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) list.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
            ans.add(entry.getKey());
        }
        // Collections.reverse(ans);
        return ans;
        
    }
  
}