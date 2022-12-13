package String;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        String ls = "";
        int max = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ls.indexOf(c) == -1)  {
                ls +=  c;
            } else {
                max = Math.max(max, ls.length());
                int index = ls.indexOf(c);
                ls = ls.substring(index+1, ls.length()) + c;
            }
        }
        return Math.max(max, ls.length());
    }

    public int lengthOfLongestSubstring2(String s) {

        Queue<Character> queue = new LinkedList<>();
        int maxLength = 0;
        for (int i = 0 ; i <s.length() ; i++) {
            if (!queue.contains(s.charAt(i))) {
                queue.add(s.charAt(i));

            } else{
                if(queue.size() > maxLength){
                    maxLength = queue.size();
                }
                while(!queue.isEmpty() && queue.poll() != s.charAt(i)){
                    System.out.println("");
                }
                queue.add(s.charAt(i));
            }
        }
        return Math.max(queue.size(), maxLength );
    }
}
