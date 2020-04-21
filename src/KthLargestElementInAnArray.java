import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for(int n : nums) {
            if (heap.size() < k || heap.isEmpty()) {
                heap.add(n);
            } else {
                if (heap.peek() < n){
                    // System.out.println("peek " + heap.peek() + ", n " + n);
                    heap.poll();
                    heap.add(n);
                }
            }
        }

        return heap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        findKthLargest(nums, k);
    }
}
