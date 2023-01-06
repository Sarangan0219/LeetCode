package String;

import java.util.*;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in
any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
using all the original letters exactly once.
*/



public class AllAnagramsInAString {

    public static void main(String[] args) {
        findAnagrams3("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list = new ArrayList<>();
        int sn = s.length();
        int pn = p.length();

        if (pn > sn ) {
            return list;
        } else if (pn == sn) {
            if (isAnagram(s, p)) {
                list.add(0);
            }
        } else {
            for (int i = 0; i < sn - pn +1; i++) {
                char[] sArr = new char[pn];
                int k = 0;
                for (int j = i; j < i+pn ; j++) {
                    sArr[k] = s.charAt(j);
                    k++;
                }
                String orderedS = new String(sArr);
                if (isAnagram(orderedS, p)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams3(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;


        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> soln = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
            return new ArrayList<>();
        }

        int[] chars = new int[26];
        for (Character c : p.toCharArray()){
            chars[c-'a']++;
        }

        int start = 0, end = 0, len = p.length(), diff = len;

        char temp;
        for (end = 0; end < len; end++){
            temp = s.charAt(end);
            chars[temp-'a']--;
            if (chars[temp-'a'] >= 0){
                diff--;
            }
        }

        if (diff == 0){
            soln.add(0);
        }

        while (end < s.length()){
            temp = s.charAt(start);
            if (chars[temp-'a'] >= 0){
                diff++;
            }
            chars[temp-'a']++;
            start++;
            temp = s.charAt(end);
            chars[temp-'a']--;

            if (chars[temp-'a'] >= 0){
                diff--;
            }

            if (diff == 0){
                soln.add(start);
            }

            end++;

        }
        return soln;
    }
}
