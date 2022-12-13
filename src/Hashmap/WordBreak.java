package Hashmap;

/*

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a
valid dictionary word. Return all such possible sentences in any order. Note that the same word in the dictionary may be
reused multiple times in the segmentation.

*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

    HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Resultant List
        List<String> res = new ArrayList<>();

        // Null String
        if(s == null || s.length() == 0) {
            return res;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }


        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}
