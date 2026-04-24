import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Backtracking - Interview prep (Java)
 * Reference implementations for common backtracking interview patterns.
 */
public class BacktrackingBasics {

    private static final String TOPIC = "Backtracking";

    public static String describe() {
        return "Backtracking systematically explores candidates by building solutions incrementally "
                + "and abandoning partial candidates that cannot be completed to a valid solution.";
    }

    public static String[] checklist() {
        return new String[] {
                "Define state: current path, indices used, constraints",
                "Write the base case: when to add to results",
                "Write the recursive step: loop over valid choices",
                "Add pruning to skip impossible branches early",
                "Backtrack: undo the choice before returning"
        };
    }

    /**
     * LeetCode 78: all subsets of nums.
     * Time: O(n * 2^n), Space: O(n) recursion depth
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * LeetCode 46: all permutations of nums.
     * Time: O(n * n!), Space: O(n) recursion depth
     */
    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackPermutations(nums, new ArrayList<>(), used, result);
        return result;
    }

    private static void backtrackPermutations(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrackPermutations(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    /**
     * LeetCode 39: combinations that sum to target, reuse allowed.
     * Time: O(n^(t/m)), Space: O(t/m) depth where t=target, m=min candidate
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackCombinationSum(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }

    private static void backtrackCombinationSum(int[] candidates, int start, List<Integer> current, int remaining, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0) return;
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrackCombinationSum(candidates, i, current, remaining - candidates[i], result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * LeetCode 22: all valid combinations of n pairs of parentheses.
     * Time: O(4^n / sqrt(n)), Space: O(n)
     */
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrackParentheses(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    private static void backtrackParentheses(StringBuilder current, int openCount, int closeCount, int n, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        if (openCount < n) {
            current.append("(");
            backtrackParentheses(current, openCount + 1, closeCount, n, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (closeCount < openCount) {
            current.append(")");
            backtrackParentheses(current, openCount, closeCount + 1, n, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * LeetCode 51: all distinct solutions to the n-queens puzzle.
     * Time: O(n!), Space: O(n) board state
     */
    public static List<List<String>> nQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrackNQueens(board, 0, n, result);
        return result;
    }

    private static void backtrackNQueens(char[][] board, int row, int n, List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrackNQueens(board, row + 1, n, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Topic: " + TOPIC);
        System.out.println(describe());
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }

        System.out.println();
        System.out.println("Subsets [1,2,3]: " + subsets(new int[] {1, 2, 3}));
        System.out.println("Permutations [1,2,3]: " + permutations(new int[] {1, 2, 3}));
        System.out.println("CombinationSum [2,3,6,7] target 7: " + combinationSum(new int[] {2, 3, 6, 7}, 7));
        System.out.println("GenerateParentheses n=3: " + generateParentheses(3));
        System.out.println("NQueens n=4 solutions: " + nQueens(4).size());
    }
}
