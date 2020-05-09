import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum_HashTable(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (cache.get(delta) != null && cache.get(delta) != i)
                return new int[] { cache.get(delta), i };
            cache.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum_HashTable(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
