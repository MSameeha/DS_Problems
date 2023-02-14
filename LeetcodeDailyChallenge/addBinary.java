package LeetcodeDailyChallenge;

import java.util.*;

public class addBinary {
    public static String addBinary(String a, String b) {
        //Will not work for large binary numbers:
        // int one = Integer.parseInt(a, 2);
        // int two = Integer.parseInt(b, 2);
        // return Integer.toBinaryString(one+two);

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length() - 1;
        int carry = 0, sum = 0;
        while(i >= 0 || j >= 0){
            sum = carry;

            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum%2);
            carry = sum/2;
        }

        if(carry != 0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(addBinary(input, input2));
        sc.close();
    }
}
