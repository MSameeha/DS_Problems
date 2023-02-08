import java.util.*;

public class integerToRoman {
    public static String intToRoman(int num) {
        String ans = "";
        List<String> lsRoman = new ArrayList<>();
        lsRoman.add("I");
        lsRoman.add("IV");
        lsRoman.add("V");
        lsRoman.add("IX");
        lsRoman.add("X");
        lsRoman.add("XL");
        lsRoman.add("L");
        lsRoman.add("XC");
        lsRoman.add("C");
        lsRoman.add("CD");
        lsRoman.add("D");
        lsRoman.add("CM");
        lsRoman.add("M");

        List<Integer> lsValue = new ArrayList<>();
        lsValue.add(1);
        lsValue.add(4);
        lsValue.add(5);
        lsValue.add(9);
        lsValue.add(10);
        lsValue.add(40);
        lsValue.add(50);
        lsValue.add(90);
        lsValue.add(100);
        lsValue.add(400);
        lsValue.add(500);
        lsValue.add(900);
        lsValue.add(1000);
        
        for(int i = lsValue.size()-1; i >= 0; i--){
            while(num >= lsValue.get(i)){
                num -= lsValue.get(i);
                ans += lsRoman.get(i);
            }
        }
        
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(intToRoman(input));
        sc.close();
    }
}
