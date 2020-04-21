import java.util.*;

public class SquaresOfASortedArray {
    public static int[] sortedSquares_NLogN(int[] A) {
        int[] result = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            result[i] = A[i] * A[i];
        }

        Arrays.sort(result);
        return result;
    }

    public static int[] sortedSquares_N(int[] A) {
        int[] result = new int[A.length];
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                result[right - left] = A[left] * A[left];
                left++;
            } else {
                result[right - left] = A[right] * A[right];
                right--;
            }
        }

        return result;
    }

    public static int[] sortedSquares_SortedMap(int[] A) {
        SortedSet<Integer> map = new TreeSet<>();

        for(int i = 0; i < A.length; i++) { // O(N)
            map.add(A[i] * A[i]); // O(logN)
        }

        int[] result = new int[A.length];
        int i = 0;
        for (Iterator<Integer> it = map.iterator(); it.hasNext(); ) {
            Integer k = it.next();
            result[i++] = k;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {-4,-1,2,3,10};

        int[] r = sortedSquares_SortedMap(A);
        System.out.println(Arrays.toString(r));
    }
}
