package HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class containDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i =0 ; i< nums.length -1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;

    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (set.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}
