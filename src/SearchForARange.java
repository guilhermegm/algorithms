import java.util.Arrays;

public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1)
                    result[0] = i;
                result[1] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
