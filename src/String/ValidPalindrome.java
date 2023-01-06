package String;

/*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
    non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
    numbers. Given a string s, return true if it is a palindrome, or false otherwise.
*/

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s =  s.toLowerCase();

        int i = 0;
        int j =  s.length();

        while(i < j) {
            if (!s.substring(i, i+1).equals(s.substring(j-1, j))) {
                System.out.println(s.charAt(i));
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
