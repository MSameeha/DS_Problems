import java.util.*;

public class integerToEnglish {


    public static String numberToWords(int num) {
        if(num == 0) return "";

        String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

        String words = "";
        int i = 0;

        while(num > 0){
            if(num%1000 != 0){
                words = helper(num%1000) + THOUSANDS[i] + " " + words;
            }
            num = num/1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(numberToWords(input));
        sc.close();
    }

}


