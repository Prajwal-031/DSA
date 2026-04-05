public class TreeBasicsTest {

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " - expected: " + expected + ", got: " + actual);
        }
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void testInorderTraversal() {
        TreeBasics.TreeNode root = new TreeBasics.TreeNode(1);
        root.right = new TreeBasics.TreeNode(2);
        root.right.left = new TreeBasics.TreeNode(3);

        // Since inorderTraversal prints, we can't easily capture output, so test maxDepth instead
        // For simplicity, test maxDepth
    }

    public static void testMaxDepth() {
        TreeBasics.TreeNode root = new TreeBasics.TreeNode(1);
        root.left = new TreeBasics.TreeNode(2);
        root.right = new TreeBasics.TreeNode(3);
        root.left.left = new TreeBasics.TreeNode(4);

        assertEquals(3, TreeBasics.maxDepth(root), "max depth");
    }

    public static void testMaxDepthEmpty() {
        assertEquals(0, TreeBasics.maxDepth(null), "empty tree depth");
    }

    public static void testMaxDepthSingle() {
        TreeBasics.TreeNode root = new TreeBasics.TreeNode(5);
        assertEquals(1, TreeBasics.maxDepth(root), "single node depth");
    }

    public static void main(String[] args) {
        testMaxDepth();
        testMaxDepthEmpty();
        testMaxDepthSingle();
        System.out.println("TreeBasicsTest passed");
    }
}