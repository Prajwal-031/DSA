public class QueueBasicsTest {

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " - expected: " + expected + ", got: " + actual);
        }
    }

    private static void assertArrayEquals(int[] expected, int[] actual, String message) {
        if (expected == null || actual == null) {
            if (expected != actual) {
                throw new AssertionError(message + " - one array is null");
            }
            return;
        }
        if (expected.length != actual.length) {
            throw new AssertionError(message + " - different lengths: " + expected.length + " vs " + actual.length);
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionError(message + " - index " + i + " expected " + expected[i] + " got " + actual[i]);
            }
        }
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    public static void testDescribeAndChecklist() {
        assertEquals("Topic: Queue. Includes API, big-O, and example problems.", QueueBasics.describe(), "describe() mismatch");
        String[] checklist = QueueBasics.checklist();
        assertEquals(4, checklist.length, "checklist length");
        assertEquals("Definition and when to use Queue", checklist[0], "checklist item 0");
    }

    public static void testSlidingWindowMaximum() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, QueueBasics.slidingWindowMaximum(input, 3), "slidingWindowMaximum");
    }

    public static void testQueueBasicsOperations() {
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.add(10);
        q.offer(20);
        q.offer(30);

        assertFalse(q.isEmpty(), "queue should not be empty");
        assertEquals(3, q.size(), "queue size");
        assertEquals(10, q.peek().intValue(), "peek value");
        assertEquals(10, q.poll().intValue(), "poll value");
        assertEquals(20, q.peek().intValue(), "peek after poll");
    }

    public static void testEmptySlidingWindow() {
        assertArrayEquals(new int[0], QueueBasics.slidingWindowMaximum(new int[0], 3), "empty input evaluation");
        assertArrayEquals(new int[0], QueueBasics.slidingWindowMaximum(new int[]{1, 2, 3}, 0), "k=0 evaluation");
    }

    public static void main(String[] args) {
        testDescribeAndChecklist();
        testSlidingWindowMaximum();
        testQueueBasicsOperations();
        testEmptySlidingWindow();
        System.out.println("QueueBasicsTest passed");
    }
}
