import java.util.*;
import java.util.stream.Collectors;

public class rewardTopKOptimized {

    // public record Student(int id, int points){
    //     // record rec = new record();
    //     // return rec;
    // }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        Set<String> negative = Arrays.stream(negative_feedback).collect(Collectors.toSet());
        // List<Student> students = new ArrayList<>();

        for(int i = 0; i < report.length; i++){
            int points = Calc_Points(report[i], positive, negative);
            // students.add(new Student(student_id[i], points));
        }

        // return students.stream().sorted(Comparator.comparing(Student::points).reversed().thenComparing(Student::id)).map(Student::id).limit(k).toList();
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    public int Calc_Points(String report, Set<String> positive_feedback, Set<String> negative_feedback){
        int points = 0;
        for(String word: report.split(" ")){
            if(positive_feedback.contains(word)){
                points += 3;
            }
            if(negative_feedback.contains(word)){
                points -= 1;
            }
        }

        return points;
    }
}
