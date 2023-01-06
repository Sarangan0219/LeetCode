package BinaryTree;

import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
        and nums[i] + nums[j] + nums[k] == 0.
*/
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> pairs = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            // To avoid the same duplicate to get processed.
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                    if (-(nums[i] + nums[j]) >= nums[j]) {
                        int indexOfRequired = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
                        if (indexOfRequired >= 0) {
                            pairs.add(Arrays.asList(nums[i], nums[j], nums[indexOfRequired]));
                        }
                    }
                }
            }
        }

        return pairs;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> outSet = new HashSet<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n-2; i++) {
            int j = i + 1;
            int k = n -1;

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (k > j) {
                if (j == i+1 || nums[j] != nums[j-1]) {
                    if (k == n-1 || nums[k] != nums[k+1]) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum == 0) {
                            outSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            j++;
                            k--;
                        } else if (sum > 0) {
                            k--;
                        } else {
                            j++;
                        }
                    } else {
                        k--;
                    }
                } else {
                    j++;
                }

            }
        }
        return new ArrayList<>(outSet);
    }

}
