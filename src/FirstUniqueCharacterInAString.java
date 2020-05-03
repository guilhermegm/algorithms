import java.util.HashMap;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar_HashMap(String s) {
        if (s == null || s.isEmpty()) return -1;

        int r = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1)
                return i;

        return r;
    }

    public static int firstUniqChar_Array(String s) {
        int r = -1;
        int[] counts = new int[26];

        for (Character c : s.toCharArray())
            counts[c - 'a'] += 1;

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return r;
    }

    public static int firstUniqChar_ArrayFaster(String s) {
        if (s.length() < 1) {
            return -1;
        }

        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        //search the first unique char
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar_IndexOf(String s) {
        int r = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        }

        return r;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";

        System.out.println(firstUniqChar_HashMap(s));
        System.out.println(firstUniqChar_Array(s));
        System.out.println(firstUniqChar_ArrayFaster(s));
        System.out.println(firstUniqChar_IndexOf(s));
    }
}
