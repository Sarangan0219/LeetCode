package PriorotyQueue;


import java.util.PriorityQueue;


// Given an integer array nums and an integer k, return the kth largest element in the array.

//        add() comes from Collection.
//        offer() comes from Queue.

//        For a capacity-constrained queue, the difference is that add() always returns true and throws an exception if
//        it can't add the element, whereas offer() is allowed to return false if it can't add the element.
//        However, this doesn't apply to PriorityQueue; the two functions are synonymous.

public class KthLargestNumber {

    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
