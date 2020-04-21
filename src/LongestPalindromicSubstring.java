public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int maxSubLen = 0;
        int maxSubIndex = 0;

        for(int i = 0; i < s.length(); i++) {
            int len1 = expandFromMid(s, i, i);
            int len2 = expandFromMid(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxSubLen) {
                maxSubIndex = i;
                maxSubLen = len;
            }
        }

        return s.substring(maxSubIndex - (maxSubLen - 1) / 2, maxSubIndex + maxSubLen / 2 + 1);
    }

    public static int expandFromMid(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "racecar";

        String r = longestPalindrome(s);
        System.out.println(r);
    }
}
