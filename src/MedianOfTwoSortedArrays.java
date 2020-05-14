import java.util.Arrays;
import java.util.Stack;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays_BruteForce(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0, i = 0;

        for (; i < arr.length; i++) {
            if (i1 == nums1.length) {
                arr[i] = nums2[i2++];
                continue;
            }

            if (i2 == nums2.length) {
                arr[i] = nums1[i1++];
                continue;
            }

            if (nums1[i1] <= nums2[i2])
                arr[i] = nums1[i1++];
            else
                arr[i] = nums2[i2++];
        }

        double median = arr.length % 2 == 0
                ? (double)(arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2
                : arr[arr.length / 2];

        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double r = findMedianSortedArrays_BruteForce(nums1, nums2);
        System.out.println(r);
    }
}
