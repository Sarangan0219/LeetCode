package BinaryTree;

import java.util.*;

public class FirstAndLastPositionOfAnElement {

    public static void main(String[] args) {
        int arr [] = {2,2};
        int target = 2;
        firstAndLastPositionOfAnElement(arr, target);
    }

    public static int[] firstAndLastPositionOfAnElement(int[] nums, int target) {
        int[] ans = {-1, -1};
        // check for first occurrence if target first
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = binarySearch(nums, target, false);
        }
        return ans;

    }

    /*
     * Complete the 'predictAnswer' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stockData
     *  2. INTEGER_ARRAY queries
     */

    static int binarySearch(int[] arr, int target, boolean start) {
        int min =0 ;
        int max = arr.length -1;
        int ans  = -1;
        while(min <= max) {
            int mid = min + ((max -min) / 2);
            if (arr[mid] == target) {
                ans = mid;
                // Potential answer is found. But we need to check the left part of array to find the min index and
                // right part of array to find the maximum index.
                if (start) {
                    max = mid -1;
                } else {
                    min = mid +1;
                }
            } else if (arr[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
}
