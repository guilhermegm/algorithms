import java.util.*;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            heap.offer(n);
            if(heap.size() > k)
                heap.poll();
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.offerFirst(heap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        List<Integer> r = topKFrequent(nums, k);
        System.out.println(r);
    }
}
