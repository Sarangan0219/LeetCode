package BinaryTree;

import java.util.Collections;
import java.util.PriorityQueue;

public class InfiniteArray {


    // We can't use arr.length fn to get the size of the array.
    public static void main(String[] args) {
        int arr [] = {2,3,4,4,4,8,9,11,12};
        int target = 5;
        Integer a = 11;
        Integer b = 11;

        System.out.println(a==b);
        findElementInInfiniteArray(arr, target);
    }

    static int findElementInInfiniteArray(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (arr[end] >= target) {
            int temp = start;
            start = end + 1;
            end = temp + (end - temp + 1) * 2;
        }
        return  binarySearch(arr, target, start, end);
    }


    static int binarySearch(int[] arr, int target, int min, int max) {
        int ans  = -1;
        while(min <= max) {
            int mid = min + ((max -min) / 2);
            if (arr[mid] == target) {
                ans = mid;
            } else if (arr[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
}
