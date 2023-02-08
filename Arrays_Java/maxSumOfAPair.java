import java.util.*;

public class maxSumOfAPair {

    static int findDigitSum(int n)
    {
        int sum;
 
        for (sum = 0; n > 0; sum += n % 10, n /= 10) ;
 
        return sum;
    }


    public static int maximumSum(int[] nums) {
        //sum of digits should be equal in chosen indices
        //have a frequency map that stores sum of digits as key and sum of numbers that have sum of digits equal to the key

        HashMap < Integer, Integer> freq = new HashMap<>(), check = new HashMap<>();

        Integer[] numsInt = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        Arrays.sort(numsInt, Collections.reverseOrder());
        int n = numsInt.length, ans = 0;
        boolean yes = false;
        for(int i = 0; i < n; i++){
            yes = false;
            int x = findDigitSum(numsInt[i]);
            int y = 0;
            if(freq.containsKey(x)){
                yes = true;
                y = freq.get(x);
            }
            y+= numsInt[i];
            if(!check.containsKey(x)){
                check.put(x, 1);
                freq.put(x, y);
                // System.out.println("Key : " + x + " Value " + y + " Added " + numsInt[i]);
            }
            else if(check.get(x) < 2){
                freq.put(x, y);
                check.put(x, 2);
                // System.out.println("Key : " + x + " Value why " + y + " Added " + numsInt[i]);
            }
            // System.out.println("Key : " + x + " Value " + y + " Added " + numsInt[i]);
            if(yes){
                ans = Math.max(ans, freq.get(x));
            }
        }
        if(ans == 0) ans = -1;
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maximumSum(arr));
        sc.close();
    }
}
