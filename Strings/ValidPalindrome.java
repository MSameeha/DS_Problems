//https://www.techinterviewhandbook.org/grind75?weeks=26&hours=40 -> 169 Questions. Question 5
//Except for 0-9, A-Z, a-z skip all characters and check if it is a palindrome, not case sensitive

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;

        int left = 0, right = s.length()-1;

        while(left < right){
            //skip invalid characters in front 
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            //skip invalid characters in back 
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
