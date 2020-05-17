import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams_SlidingWindow(String s, String p) {
        List<Integer> r = new ArrayList<>();
        int[] charCounts = new int[26];

        for (char c : p.toCharArray())
            charCounts[c - 'a']++;

        int left = 0, right = 0, counter = p.length();

        while (right < s.length()) {
            int cRight = s.charAt(right) - 'a';
            if (charCounts[cRight] >= 1)
                counter--;
            charCounts[cRight]--;
            right++;

            if (counter == 0)
                r.add(left);


            if (right - left == p.length()) {
                int cLeft = s.charAt(left) - 'a';
                if (charCounts[s.charAt(left) - 'a'] >= 0)
                    counter++;
                charCounts[cLeft]++;
                left++;

            }
        }

        return r;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(Arrays.toString(findAnagrams_SlidingWindow(s, p).toArray()));
    }
}
