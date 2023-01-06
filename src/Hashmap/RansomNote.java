package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] arRansom = magazine.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : arRansom) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] arMag = ransomNote.toCharArray();
        for (char c : arMag) {
            if (map.containsKey(c)) {
                int freq = map.get(c);
                if (freq == 1) {
                    map.remove(c);
                } else {
                    map.put (c, freq-1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
