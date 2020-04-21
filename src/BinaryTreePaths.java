import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null)
            return result;
        if (root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }

        // dfs(root, result, "", true);
        dfsStack(root, result);

        return result;
    }

    public static void dfsStack(TreeNode root, List<String> result) {
        Stack<TreeNode> stack = new Stack();
        Hashtable<Integer, String> paths = new Hashtable<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.add(root);
        //paths.put(root.val, "" + root.val);

        while (!stack.empty()) {
            TreeNode node = stack.peek();

            if (visited.contains(node.val)) {
                stack.pop();
                continue;
            }

            if (node.left == null && node.right == null) {
                /*Object[] arr = stack.toArray();
                String[] str = new String[arr.length];
                System.arraycopy(arr, 0, str, 0, arr.length)*/;
                stack.pop();
                result.add("");
                visited.add(node.val);
                continue;
            }

            if ((node.left == null || visited.contains(node.left.val)) && (node.right == null || visited.contains(node.right.val))) {
                stack.pop();
                visited.add(node.val);
                continue;
            }

            if (node.left != null && !visited.contains(node.left.val)) {
                while (node.left != null) {
                    node = node.left;
                    stack.add(node);
                }
            }
            if (node.right != null && !visited.contains(node.right.val)) {
                stack.add(node.right);
            }
       }
    }

    public static void dfs(TreeNode node, List<String> result, String path, boolean isRoot) {
        if (isRoot)
            path = "" + node.val;
        else
            path += "->" + node.val;

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        if (node.left != null) dfs(node.left, result, path, false);
        if (node.right != null) dfs(node.right, result, path, false);
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
        two.left = seven;
        two.right = five;
        five.left = four;
        five.right = six;
        seven.right = eight;

        List<String> r = binaryTreePaths(one);
        System.out.println(r);
    }
}
