package Hashmap;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.*/


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] arr = new int [2];

        for (int k = 0; k < nums.length; k++) {
            int elem = nums[k];
            if (map.containsKey(elem) && (elem*2 == target)) {
                arr[0] = map.get(elem);
                arr[1] = k;
                return arr;
            }

            map.put(elem, k);
            if (map.containsKey(target - elem) && (target - elem) != elem) {
                arr[0] = map.get(target-elem);
                arr[1] = k;
                return arr;
            }
        }

        return arr;

    }
}
