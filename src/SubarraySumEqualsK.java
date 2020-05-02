import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum_BruteForce(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // https://leetcode.com/problems/subarray-sum-equals-k/discuss/272067/Python-99.57-(6-lines)-accumulator-+-hashtable
    public static int subarraySum_ON(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,7,0};
        int k = 11;

        int result = subarraySum_ON(nums, k);
        System.out.println(result);
    }
}

/*
sum here means the sum so far from index 0 up to the current index that you are at.
for example:
[ 3 2 7 1 6 ] k = 10
from index 0 ... index 3 sum = 13
map:
3 : 1
5: 1
12: 1
when it comes to 13 the code check if 13 -10 = 3 in the map
well it is in the map then that means we found sub array that sums to 10 which from index 1 to index 3 ==> [ 2 7 1 ]
now imagine doing the same process for a huge array with multiple 10s as sub arrays
for example consider this array [ 3 2 7 1 6 4 5 2 3 ]
This array has 3 10s
[ 2 7 1 ] ====> sum to 10
[ 6 4 ] ====> sum to 10
[ 5 2 3 ] ====> sum to 10
Now let run that snippet of code
3 : 1 ====> 3 - 10 = -7 check map is it there? NO
5: 1 ====> 5 -10 = -5 check map is it there? NO
12: 1 ====> 12 - 10 = 2 check map is it there? NO
when we reach 13 we found that 13 - 10 = 3 just like I showed above
lets continue
13: 1 =>>>> 13 - 10 = 3 check map is it there? YES so take the frequency and add it to count
19: 1 ====> 19 -10 = 9 check map is it there? NO
23: 1 =====> 23 - 10 = 13 check map is it there? Yes so take the frequency and add it to count
28: 1 =====> 28 - 10 = 18 check map is it there? NO
30: 1 =======> 30 - 10 = 20 check map is it there? NO
33:1 ========> 33 - 10 = 23 check map is it there? YES so take the frequency and add it to count
from this we can tell that there are 3 sub arrays that sum to 10
current sum - given sum = sum in map
*/
