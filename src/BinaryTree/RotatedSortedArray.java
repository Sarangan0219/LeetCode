package BinaryTree;
/*

        There is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
        such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        Given the array nums after the possible rotation and an integer target, return the index of target if it is
        in nums, or -1 if it is not in nums.

 */

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        for (int i = 1; i < n; i++){
            if (nums[i] < nums[i-1]) {
                if (target >= nums[0]) {
                    return binarySearch(nums, 0, i -1, target);
                } else if (target <= nums[n-1]) {
                    return binarySearch(nums, i, n-1, target);
                } else {

                }
                break;
            }
        }
        return binarySearch(nums, 0, n-1, target);
    }

    static int binarySearch(int[] arr, int min, int max, int target) {
        int ans  = -1;
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
        return ans;
    }
}
