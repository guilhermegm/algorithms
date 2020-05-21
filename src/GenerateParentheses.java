import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void backtrack(List<String> r, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            r.add(str);
            return;
        }

        if (open < n) backtrack(r, str + "(", open + 1, close, n);
        if (close < open) backtrack(r, str + ")", open, close + 1, n);
    }

    public static List<String> generateParenthesis_Backtracking(int n) {
        List<String> r = new ArrayList<>();
        backtrack(r, "", 0, 0, n);
        return r;
    }

    public static void main(String[] args) {
        int n = 3;

        Helper.printList(generateParenthesis_Backtracking(n));
    }
}
