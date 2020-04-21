import java.util.*;

public class KthSmallestElementInABST {
    public static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return arr;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);

        return arr;
    }

    public static int kthSmallestInorder(TreeNode root, int k) {
        // Time complexity: O(N) to build a traversal.
        // Space complexity: O(N) to keep an inorder traversal.
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    public static int kthSmallestStack(TreeNode root, int k) {
        // Time complexity: O(H + k), where H is a tree height. This complexity is defined by the stack, which contains at least H + k elements, since before starting to pop out one has to go down to a leaf. This results in O(logN + k) for the balanced tree and O(N + k) for completely unbalanced tree with all the nodes in the left subtree.
        // Space complexity: O(H + k), the same as for time complexity, O(N + k) in the worst case, and O(logN + k) in the average case.
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        five.left = three;
        five.right = six;
        three.left = two;
        three.right = four;
        two.left = one;

        int k = 4;

        int result = kthSmallestStack(five, k);
        System.out.println(result);
    }
}
