import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public static int deepestLeavesSumBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int levelSum = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return levelSum;
    }

    // https://leetcode.com/problems/deepest-leaves-sum/discuss/592664/Java-0-ms-100-O(n)-single-tree-traversal-no-global-vars-explained
    public static int deepestLeavesSumRecursive(TreeNode root) {
        int[] levelsSum = new int[10000];
        int i = calculateLevelSum(root, levelsSum, 0);
        return levelsSum[i];
    };

    public static int calculateLevelSum(TreeNode node, int[] levelsSum, int i) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            levelsSum[i] += node.val;
            return i;
        }

        int left = calculateLevelSum(node.left, levelsSum, i + 1);
        int right = calculateLevelSum(node.right, levelsSum, i + 1);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        four.left = seven;
        six.right = eight;

        int r = deepestLeavesSumRecursive(one);
        System.out.println(r);
    }
}
