import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Greedy Algorithms - Interview prep (Java)
 * ========================================
 *
 * Greedy solutions make the locally best safe choice at each step. The proof
 * usually matters more than the amount of code.
 */
public class GreedyAlgorithmsBasics {

    private static final String TOPIC = "Greedy Algorithms";

    public static String describe() {
        return "Greedy algorithms build an answer one safe local choice at a time. "
                + "Use them when a local optimum can be proven to produce a global optimum.";
    }

    public static String[] checklist() {
        return new String[] {
                "Identify the local greedy choice",
                "Choose a useful ordering, often by sorting",
                "Prove the greedy choice with an exchange argument or invariant",
                "Test small counterexamples before coding",
                "Compare against DP when the local choice is not safe"
        };
    }

    /**
     * LeetCode 122: Best Time to Buy and Sell Stock II.
     * Time: O(n), Space: O(1)
     */
    public static int maxProfitUnlimitedTransactions(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * LeetCode 455: Assign Cookies.
     * Time: O(n log n + m log m), Space: O(1) excluding sort internals
     */
    public static int assignCookies(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int child = 0;
        int cookie = 0;
        int satisfied = 0;

        while (child < greed.length && cookie < cookies.length) {
            if (cookies[cookie] >= greed[child]) {
                satisfied++;
                child++;
            }
            cookie++;
        }

        return satisfied;
    }

    /**
     * LeetCode 55: Jump Game.
     * Time: O(n), Space: O(1)
     */
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

    /**
     * LeetCode 45: Jump Game II.
     * Time: O(n), Space: O(1)
     */
    public static int minimumJumps(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    /**
     * LeetCode 435: Non-overlapping Intervals.
     * Time: O(n log n), Space: O(1) excluding sort internals
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int removals = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                removals++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return removals;
    }

    /**
     * LeetCode 763: Partition Labels.
     * Time: O(n), Space: O(1) for bounded lowercase alphabet input
     */
    public static List<Integer> partitionLabels(String text) {
        Map<Character, Integer> lastPosition = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            lastPosition.put(text.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < text.length(); i++) {
            end = Math.max(end, lastPosition.get(text.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(TOPIC);
        System.out.println(describe());
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }

        System.out.println();
        System.out.println("Stock II: " + maxProfitUnlimitedTransactions(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println("Assign Cookies: " + assignCookies(new int[] {1, 2, 3}, new int[] {1, 1}));
        System.out.println("Can Jump: " + canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println("Minimum Jumps: " + minimumJumps(new int[] {2, 3, 1, 1, 4}));
        System.out.println("Erase Overlaps: " + eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println("Partition Labels: " + partitionLabels("ababcbacadefegdehijhklij"));
    }
}
