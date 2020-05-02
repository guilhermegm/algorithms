public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] A, int S) {
        int r = 0, sum = 0;
        int left = 0, right = 0;


        while (right < A.length) {
            sum += A[right];

            while (sum > S && left < right)
                sum -= A[left++];

            if (sum == S)
                r++;

            if(right < A.length - 1) right++;
            if (left >= right) break;
        }

        return r;
    }

    public static void main(String[] args) {
        /*int[] nums = {1,0,1,0,1};
        int S = 2;*/
        int[] nums = {0,1,0,0,0};
        int S = 1;

        int result = numSubarraysWithSum(nums, S);
        System.out.println(result);
    }
}
