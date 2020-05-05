import com.sun.source.tree.Tree;

public class BinaryTreeMaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;

    public static int helper_Recursive2(TreeNode root) {
        if(root == null)
            return 0;

        int leftGain = Math.max(helper_Recursive2(root.left),0);
        int rightGain = Math.max(helper_Recursive2(root.right),0);

        maxSum = Math.max( maxSum, leftGain + rightGain + root.val);

        return root.val + Math.max(leftGain,rightGain);
    }

    public static int maxPathSum_Recursive2(TreeNode root)   {
        helper_Recursive2(root);
        return maxSum;
    }

    public static int helper_Recursive1(TreeNode node, int[] r) {
        if (node == null) return 0;

        int left = helper_Recursive1(node.left, r);
        int right = helper_Recursive1(node.right, r);

        int maxPath = Math.max(Math.max(left, right) + node.val, node.val);
        int maxRoot = Math.max(left + right + node.val, maxPath);
        r[0] = Math.max(maxRoot, r[0]);

        return maxPath;
    }

    public static int maxPathSum_Recursive1(TreeNode root) {
        int[] r = { Integer.MIN_VALUE };
        helper_Recursive1(root, r);
        return r[0];
    }

    public static void main(String[] args) {
        /*TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;*/

        TreeNode minusTen = new TreeNode(-10);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        minusTen.left = nine;
        minusTen.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        System.out.println(maxPathSum_Recursive2(minusTen));
    }
}
