public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums.length < 2)
            return 0;

        int i = 0;
        for(; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i])
                return i;
        }

        return i;
    }

    public static int findPeakElementRecursive(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public static int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public static int findPeakElementIterative(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};

        int r = findPeakElementIterative(nums);
        System.out.println(r);
    }
}
