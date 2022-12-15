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

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        Map<Integer, Integer> stockMap = new HashMap<>();
        Map<Integer, Integer> lowestDayMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int k=0; k<stockData.size(); k++) {
            stockMap.put(k+1, stockData.get(k));
        }

        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.ceiling(3);


        for (int m = 0 ; m < queries.size(); m++) {
            Integer query = queries.get(m);
            Integer value = stockMap.get(query);
            int j = 0;
            Integer lowestDay = -1;
            while( query -j > 0 || ((query + j) < stockMap.size() + 1) ) {
                if (query -j > 0) {
                    Integer q1 = stockMap.get(query - j);
                    if (value > q1) {
                        lowestDay = query - j;
                        break;
                    }
                }

                if (query +j < stockMap.size() +1) {
                    Integer q2 = stockMap.get(query + j);
                    if (value > q2 ){
                        lowestDay = query + j;
                        break;
                    }
                }
                j++;
            }
            ans.add(lowestDay);
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

    public static List<Integer> predictAnswer2(List<Integer> stockData, List<Integer> queries) {
        Map<Integer, Integer> stockMap = new HashMap<>();
        Map<Integer, Integer> lowestDayMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int k=0; k< stockData.size(); k++) {
            Integer value = stockData.get(k);
            Integer query = k+1;
            stockMap.put(query, value);
        }

        for (int k =0 ; k < stockData.size(); k++) {
            int j = 0;
            Integer lowestDay = -1;
            Integer value = stockData.get(k);
            Integer query = k+1;
            while( query -j > 0 || ((query + j) < stockMap.size() + 1) ) {
                if (query -j > 0) {
                    Integer q1 = stockMap.get(query - j);
                    if (value > q1) {
                        lowestDay = query - j;
                        break;
                    }
                }

                if (query +j < stockMap.size() +1) {
                    Integer q2 = stockMap.get(query + j);
                    if (value > q2 ){
                        lowestDay = query + j;
                        break;
                    }
                }
                j++;
            }
            lowestDayMap.put(query, lowestDay);
        }

        for (int m = 0 ; m < queries.size(); m++) {
            Integer query = queries.get(m);
            ans.add(lowestDayMap.get(query));

        }
        return ans;

    }

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
