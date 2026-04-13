import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Dynamic Programming - Interview prep (Java)
 * Reference implementations for common DP interview patterns.
 */
public class DynamicProgrammingBasics {

    private static final String TOPIC = "Dynamic Programming";

    public static String describe() {
        return "Dynamic Programming solves overlapping subproblems by storing previous answers.";
    }

    public static String[] checklist() {
        return new String[] {
            "Define the state clearly",
            "Write the recurrence relation",
            "Handle base cases and impossible states",
            "Optimize space when only recent states are needed"
        };
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n < 2) {
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        for (int i = 3; i <= n; i++) {
            int current = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }
        return oneStepBefore;
    }

    public static int houseRobber(int[] nums) {
        int robPrev = 0;
        int skipPrev = 0;

        for (int value : nums) {
            int newRob = skipPrev + value;
            skipPrev = Math.max(skipPrev, robPrev);
            robPrev = newRob;
        }
        return Math.max(robPrev, skipPrev);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int target = 1; target <= amount; target++) {
            for (int coin : coins) {
                if (coin <= target) {
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public static boolean wordBreak(String s, String[] wordDict) {
        Set<String> words = new HashSet<>(Arrays.asList(wordDict));
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && words.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("Topic: " + TOPIC);
        System.out.println(describe());
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }

        System.out.println("\nSample results:");
        System.out.println(" fibonacci(8) = " + fibonacci(8));
        System.out.println(" climbStairs(5) = " + climbStairs(5));
        System.out.println(" houseRobber([2, 7, 9, 3, 1]) = " + houseRobber(new int[] {2, 7, 9, 3, 1}));
        System.out.println(" coinChange([1, 2, 5], 11) = " + coinChange(new int[] {1, 2, 5}, 11));
        System.out.println(
            " wordBreak(\"leetcode\", [\"leet\", \"code\"]) = "
                + wordBreak("leetcode", new String[] {"leet", "code"})
        );
    }
}
