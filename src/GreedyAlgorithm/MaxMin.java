package GreedyAlgorithm;

import java.util.Collections;
import java.util.List;

public class MaxMin {

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int maxMin = Integer.MAX_VALUE;
        int n = arr.size();
        for (int i = 0; i < n -k+1 ; i ++ ) {
            maxMin = Math.min(arr.get(i+k-1) - arr.get(i) , maxMin);

        }
        return maxMin;
    }
}
