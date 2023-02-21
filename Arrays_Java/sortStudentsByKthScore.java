import java.util.*;

public class sortStudentsByKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (row1, row2) -> row2[k]-row1[k]);

        return score;
    }
}
