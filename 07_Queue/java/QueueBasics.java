/**
 * Queue - Interview prep (Java)
 * =============================
 * Real queue examples and algorithm patterns.
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {

    private static final String TOPIC = "Queue";

    public static String describe() {
        return "Topic: " + TOPIC + ". Includes API, big-O, and example problems.";
    }

    public static String[] checklist() {
        return new String[] {
            "Definition and when to use Queue",
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

        demoQueueOperations();
        demoSlidingWindowMax();
    }

    private static void demoQueueOperations() {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.offer(20);
        q.offer(30);
        System.out.println("Java Queue example (linked list backing): " + q);

        System.out.println("peek()=" + q.peek());
        System.out.println("poll()=" + q.poll());
        System.out.println("After poll: " + q);
    }

    public static int[] slidingWindowMaximum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] out = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // indices of elements in descending order

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                out[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return out;
    }

    private static void demoSlidingWindowMax() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = slidingWindowMaximum(nums, k);
        System.out.print("Sliding window maximum for " + java.util.Arrays.toString(nums) + " with k=" + k + ": ");
        System.out.println(java.util.Arrays.toString(ans));
    }
}
