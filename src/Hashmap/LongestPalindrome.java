package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int['z' - 'A' + 1];
        int sum = 0;
        int oddCount = 0;
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        for (int n : count) {
            sum += n / 2;
            if (n % 2 != 0) {
                oddCount++;
            }
        }
        sum *= 2;
        if (oddCount != 0) {
            sum++;
        }
        return sum;
    }

    public int longestPalindrome2(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c)%2 == 0) count++;
        }

        if(count*2 == s.length()) return count*2;
        if(count*2 < s.length()) return count*2 + 1;

        return count;
    }
}
