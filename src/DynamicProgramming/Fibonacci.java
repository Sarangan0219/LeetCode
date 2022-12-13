package DynamicProgramming;

public class Fibonacci {



    public static void main(String[] args) {
        System.out.println(bottomUpApproach(10));
    }

    public static int bottomUpApproach(int n) {
        int [] fibArray = new int[n];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int k = 2;  k < n ; k ++) {
            fibArray[k] = fibArray[k -1] + fibArray [k -2];
        }
        return fibArray[n-1];
    }


}
