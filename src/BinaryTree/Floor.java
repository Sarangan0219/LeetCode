package BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class Floor {

    public static void main(String[] args) {
        int arr [] = {2,3,4,5,6,8,9,11,12};
        int target = 7;
        System.out.println(floor(arr, target));
    }

    //Greatest element in the array which is <= target
    static int floor(int[] arr, int target) {
        Arrays.sort(arr);
        int min = 0;
        int max = arr.length -1;

        while(min <= max) {
            int mid = min + ((max -min) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return arr[max];
    }

}
