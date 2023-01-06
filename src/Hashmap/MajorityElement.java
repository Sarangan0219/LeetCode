package Hashmap;

public class MajorityElement {
    public static void main(String[] args) {
        majorityElement(new int[]{2,2,1,1,1,2,2});
    }

    public static int majorityElement(int[] num) {
        int major = num[0];
        int count = 1;
        for(int i = 1; i < num.length; i++){
            if(count == 0) {
                count++;
                major = num[i];
            } else if(major == num[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
