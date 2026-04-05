/**
 * Tree - Interview prep (Java)
 * =============================
 * Real tree examples and algorithm patterns.
 */

public class TreeBasics {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static final String TOPIC = "Tree";

    public static String describe() {
        return "Topic: " + TOPIC + ". Includes TreeNode class, traversals, and example problems.";
    }

    public static String[] checklist() {
        return new String[] {
            "Definition and when to use Tree",
            "Core operations and complexities",
            "Two easy + two medium problems solved",
            "One hard attempted with analysis"
        };
    }

    public static void main(String[] args) {
        System.out.println(describe());
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }

        demoTreeOperations();
        demoMaxDepth();
    }

    private static void demoTreeOperations() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.print("Inorder traversal: ");
        inorderTraversal(root);
        System.out.println();
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static void demoMaxDepth() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println("Max depth: " + maxDepth(root));
    }
}
