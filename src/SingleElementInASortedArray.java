public class SingleElementInASortedArray {
    public static int singleNonDuplicate_BruteForce(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }

        return -1;
    }

    public static int singleNonDuplicate_LogN(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        if (nums[0] != nums[1]) return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;

            if (!(nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1])) {
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                    return nums[mid];
                if (nums[mid] != nums[mid - 1])
                    return nums[mid - 1];
                if (nums[mid] != nums[mid + 1])
                    return nums[mid + 1];
            }

            if ((nums[mid] == nums[mid - 1] && mid % 2 == 0) || (nums[mid] == nums[mid + 1] && mid % 2 != 0)) right = mid;
            else left = mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,5,5,6,6,7,7,8,8};
        int[] nums2 = {3,3,7,7,10,11,11};
        int[] nums3 = new int[199];

        for (int i = 0, j = 1; i < nums3.length; i++) {
            if (j == 43) {
                nums3[i] = j;
                j++;
            } else {
                nums3[i] = j;
                nums3[i + 1] = j;
                i++;
                j++;
            }
        }

        System.out.println(singleNonDuplicate_BruteForce(nums));
        System.out.println(singleNonDuplicate_BruteForce(nums2));

        System.out.println(singleNonDuplicate_LogN(nums3));
        System.out.println(singleNonDuplicate_LogN(nums2));
    }
}
