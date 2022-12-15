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

    //Greatest element in the array which is =< target
    static int floor(int[] arr, int target) {
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int k = 0 ; k < arr.length; k ++) {
            pq.add(arr[k]);
        }
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



        /* prints element and NSE pair for all
        elements of arr[] of size n */
        public static void printNSE(int arr[], int n) {
            Stack<Integer> s = new Stack<Integer>();
            HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

            /* push the first element to stack */
            s.push(arr[0]);

            // iterate for rest of the elements
            for (int i = 1; i < n; i++) {

                if (s.empty()) {
                    s.push(arr[i]);
                    continue;
                }

                    /* if stack is not empty, then
            pop an element from stack.
            If the popped element is greater
            than next, then
            a) print the pair
            b) keep popping while elements are
            greater and stack is not empty */

                while (s.empty() == false
                        && s.peek() > arr[i]) {
                    mp.put(s.peek(), arr[i]);
                    s.pop();
                }

			/* push next to stack so that we can find
			next smaller for it */
                s.push(arr[i]);
            }

		/* After iterating over the loop, the remaining
		elements in stack do not have the next smaller
		element, so print -1 for them */
            while (s.empty() == false) {
                mp.put(s.peek(), -1);
                s.pop();
            }

            for (int i = 0; i < n; i++)
                System.out.println(arr[i] + " ---> "
                        + mp.get(arr[i]));
        }

}
