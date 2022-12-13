import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
         String s = "abqef";
         System.out.println(s.charAt(1) - 'a');
//        sherlockAndAnagrams("abba");
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineMap = new HashMap<>();
        for (String mag: magazine){
            if (magazineMap.containsKey(mag)) {
                magazineMap.put(mag, magazineMap.get(mag) + 1);
            } else {
                magazineMap.put(mag, 1);
            }
        }
    }

    public static String twoStrings(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println("YES");
        }
        Map<Character, Integer> s1map = new HashMap<>();
       for (int k =0 ; k < s1.length(); k ++) {
           Character c  = s1.charAt(k);
           if (s1map.containsKey(c)) {
               s1map.put(c, s1map.get(c) +1);
           } else {
               s1map.put(c, 1);
           }
       }

        boolean flag = false;
        for (int k =0 ; k < s2.length(); k ++) {
            Character c  = s2.charAt(k);
            if (s1map.containsKey(c)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            return "YES";
        } else {
            return "NO";
        }
    }

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static String twoStrings2(String s1, String s2) {
        Set<String> s1array = new HashSet<>(Arrays.asList(s1.split("")));
        String[] array = s1array.stream().toArray(String[]::new);
        Set<String> s2array = new HashSet<>(Arrays.asList(s2.split("")));
        String[] array2 = s2array.stream().toArray(String[]::new);

        for (String s3: array){
            for(String s4: array2) {
                if (s3.equals(s4)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

//    public static int sherlockAndAnagrams(String s) {
//        int count = 0;
//        Map <String, Integer> anagramMap = new HashMap<>();
//
//        for (int i = 0 ; i < s.length() ; i++) {
//            for (int j = i ; j < s.length() ; j++) {
//                char[] charArray = s.substring(i, j +1).toCharArray();
//                Arrays.sort(charArray);
//                String val = new String(charArray);
//                putMap();Map(anagramMap, val);
//            }
//        }
//
//        for(String key: anagramMap.keySet()) {
//            int n = anagramMap.get(key);
//            count = count + ( n * (n-1) ) / 2;
//        }
//        return count;
//    }

    public static void putMap(Map <Integer, Integer> s2map, Integer c) {
        if (s2map.containsKey(c)) {
            s2map.put(c, s2map.get(c) +1);
        } else {
            s2map.put(c, 1);
        }
    }

    public static void removeMap(Map <Integer, Integer> s2map, Integer c) {
        if (s2map.containsKey(c)) {
            int count  = s2map.get(c)- 1;
            if (count == 1) {
                s2map.remove(c);
            } else {
                s2map.put(c, s2map.get(c)- 1);
            }
        }
    }

    public static int isFrequencyExists(Map <Integer, Integer> anagramMap, int pointer) {
        for(Integer key: anagramMap.keySet()) {
            int n = anagramMap.get(key);
            if (n == pointer) {
               return 1;
            }
        }
        return 0;
    }


    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        Map <Integer, Integer> freqMap = new HashMap<>();

        String s  = "";

        int  f = (int) Math.sqrt(12);







         for (List<Integer> query: queries) {
             int op = query.get(0);
             int value = query.get(1);
             if (op == 1) {
                 array.add(value);
                 putMap(freqMap, value);
             } else if (op == 2) {
                 array.remove(value);
                 removeMap(freqMap, value);
             } else if (op == 3) {
                 output.add(isFrequencyExists(freqMap, value));
             }
         }
        return output;
    }

    public static void plusMinus(List<Integer> arr) {
        int len = arr.size();
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for (Integer i : arr) {
            if (i > 0 ) {
                pos++;
            } else if (i < 0) {
                neg++;
            } else {
                zero ++;
            }
        }
        final DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format((double)pos/len));
        System.out.println(df.format((double)neg/len));
        System.out.println(df.format((double)zero/len));


    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int size = expenditure.size();
        int noticeDays = 0;

        if (d >= size) {
            return 0;
        }
        "hg".length();
        PriorityQueue pq = new PriorityQueue();
        for (int n = 0; n < d ; n++) {
            pq.add(expenditure.get(n));
        }
        pq.forEach(s ->  System.out.println(s));

        for (int k = d; k < size ; k++) {
            if (k > d) {
                pq.add(expenditure.get( k-1));
            }
            int median = median(new ArrayList<>(pq));
            if (expenditure.get(k) >= (median*2)) {
                noticeDays ++;
            }
            pq.remove(expenditure.get(k-d));
        }
        Optional<String> something = Optional.of("ef");
        return noticeDays;

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }



    public static int median(List<Integer> expenditure) {
        int median;
        int size = expenditure.size();

        if (size % 2 == 1) {
            median = expenditure.get((size/2));
        } else {
            median =  expenditure.get((size/2)) + expenditure.get((size/2) -1);
        }
        return median;
    }

    static int[] buildSortedSet(int[] x) {
        return Arrays.stream(x).distinct().sorted().toArray();
    }

    static long minTime(long[] daysForMachine, long goal) {
        Arrays.sort(daysForMachine);

        // Starts from the least number of days to finish the task.
        long min = daysForMachine[0];
        // Assume all the machines except the greater load machine is not working.
        long max = daysForMachine[daysForMachine.length -1] * goal;

        long mid = 0;
        while (max > min) {
            mid = (max + min) / 2;
            if (isGoalAchieved(goal, mid, daysForMachine)) {
                min = mid +1;
            } else {
                max = mid;
            }
        }
        return mid;
    }



    // Search in rotated sorted array.
    public int search(int[] nums, int target) {
        int pivot = 0;
        int min = 0;
        int max = nums.length -1;
        if (max  == 0) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        if (max  == 1) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[1] == target) {
                return 1;
            } else {
                return -1;
            }
        }

        int [] newnums = new int [nums.length];

        for (int k =0; k < nums.length -1; k++) {
            if (nums[k] > nums[k+1]) {
                pivot = k+1;
            }
        }
        for (int k =0; k < nums.length; k++) {
            int index = k+ pivot;
            if (index > nums.length -1) {
                index  = index % nums.length;
            }
            newnums[k] = nums [index];

        }


        while (max >= min) {
            int mid = min + (max - min)/2;
            if (target < newnums[mid]) {
                max = mid -1;
            } else if (target > newnums[mid]) {
                min = mid +1;
            } else {
                int index =  mid + pivot;
                if (index > nums.length -1) {
                    index = index % nums.length;
                    return index;
                } else {
                    return index;
                }
            }
        }

        return -1;
    }

    static boolean isGoalAchieved (long goal, long days, long [] daysForMachine) {
        long items = 0;
        for (int k = 0; k < daysForMachine.length; k++) {
            items += days / daysForMachine[k];
        }
        return goal > items;
    }

    public static String isBalanced(String s) {
        Stack<String> stk = new Stack<>();
        String [] stackElem = s.split("");

        for (String s1: stackElem) {
            if (stk.isEmpty()) {
                stk.add(s1);
            } else {
                String topElem = stk.peek();
                if (s1.equals("}")) {
                    if (!topElem.equals("{")) {
                        return "NO";
                    } else {
                        stk.pop();
                    }
                } else if (s1.equals("]")) {
                    if (!topElem.equals("[")) {
                        return "NO";
                    } else {
                        stk.pop();
                    }
                } else if (s1.equals(")")) {
                    if (!topElem.equals("(")) {
                        return "NO";
                    } else {
                        stk.pop();
                    }
                }
            }
        }

        if (stk.isEmpty()) {
            return  "YES";
        } else {
            return "NO";
        }

    }

//    public static int pairs(int k, List<Integer> arr) {
//        int count =0 ;
//        Integer [] arrA = arr.toArray(new Integer[arr.size()]);
//        Arrays.sort(arrA);
//        for ( int r : arrA) {
//            if (arr.contains(r+k)) {
//                count ++;
//            }
//        }
//        return count;
//    }

    public static int pairs(int k, List<Integer> arr, int counter) {
        int count =0 ;

        Set<Integer>hs = new HashSet<>(arr.stream().map(x -> x + k).collect(Collectors.toList()));

        for (int r : arr) {
            if (hs.contains(r)) {
                count ++;
            }
        }

        Set<Integer> brr = new HashSet<>();
        for (Integer i : arr){
            brr.add(i+k);
        }
        for (Integer i : arr){
            if (brr.contains(i)){
                counter++;
            }
        }

        return counter;


    }


    public static long triplets(List<Integer> a, List<Integer> b, List<Integer> c) {

        Integer[] newA = a.toArray(new Integer[a.size()]);
        Integer[] newB = a.toArray(new Integer[b.size()]);
        Integer[] newC = a.toArray(new Integer[c.size()]);
        Arrays.binarySearch(newA, 3);

        Arrays.stream(newA).distinct().sorted().toArray();

        Arrays.stream(newB).distinct().sorted().toArray();

        Arrays.stream(newC).distinct().sorted().toArray();

//        Set<Integer> tempA = new HashSet<>(a);
//        Integer[] newA = tempA.toArray(new Integer[tempA.size()]);
//
//        Set<Integer> tempB = new HashSet<>(b);
//        Integer[] newB = tempB.toArray(new Integer[tempB.size()]);
//
//        Set<Integer> tempC = new HashSet<>(c);
//        Integer[] newC = tempC.toArray(new Integer[tempC.size()]);


        long count = 0;
        for (int i = 0; i < newA.length; i ++) {
            long first = newA[i];
            for (int j = 0; j < newB.length; j ++) {
                long second = newB[j];
                if (second < first) {
                    continue;
                }
                for (int k = 0; k < newC.length; k ++) {
                    long third = newC[k];
                    if (second < third) {
                        break;
                    }
                    System.out.println(first + " " + second + " " + third);
                    count ++;
                }
            }
        }
        return count;
    }

    public static void countSwaps(List<Integer> a) {
        Set<Integer> temp = new HashSet<Integer>(a);
        int swaps = 0;
        int  len = a.size();
        for (int  i = 0 ; i < len-1 ; i++) {
            int pivotElement  = a.get(i);
            for (int j = i; j < len ; j++) {
                if (pivotElement > a.get(j)) {
                    int temp2 = a.get(j);
                    a.set(j-1, temp2);
                    a.set(j, pivotElement);
                    swaps ++;
                }

            }
        }

        System.out.println("Array is sorted in " +  swaps + "swaps.");
        System.out.println("First Element: " +  a.get(0));
        System.out.println("First Element: " +  a.get(len -1));


    }


//    public static void miniMaxSum(List<Integer> arr) {
//        Integer [] gh = new Integer[arr.size()];
//        gh =  arr.toArray(gh);
//        Integer [] gh = (Integer[]) arr.toArray();
//        Ars.sort(arr.toArray());
//        int min = 0;
//        int max =0 ;
//        int tot = 0;
//        for (int i =1; i < arr.size() -1; i ++) {
//            tot = tot + arr.get(i);
//        }
//        System.out.println(tot+arr.get(0) + " " + arr.get(1));
//
//
//    }
}