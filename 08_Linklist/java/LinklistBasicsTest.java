public class LinklistBasicsTest {

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

    private static void assertNull(Object obj, String message) {
        if (obj != null) {
            throw new AssertionError(message);
        }
    }

    public static void testReverseList() {
        LinklistBasics.ListNode head = new LinklistBasics.ListNode(1);
        head.next = new LinklistBasics.ListNode(2);
        head.next.next = new LinklistBasics.ListNode(3);
        head.next.next.next = new LinklistBasics.ListNode(4);

        LinklistBasics.ListNode reversed = LinklistBasics.reverseList(head);
        assertEquals(4, reversed.val, "reverse head");
        assertEquals(3, reversed.next.val, "reverse second");
        assertEquals(2, reversed.next.next.val, "reverse third");
        assertEquals(1, reversed.next.next.next.val, "reverse fourth");
        assertNull(reversed.next.next.next.next, "reverse end");
    }

    public static void testReverseEmptyList() {
        LinklistBasics.ListNode reversed = LinklistBasics.reverseList(null);
        assertNull(reversed, "reverse null");
    }

    public static void testReverseSingleNode() {
        LinklistBasics.ListNode head = new LinklistBasics.ListNode(5);
        LinklistBasics.ListNode reversed = LinklistBasics.reverseList(head);
        assertEquals(5, reversed.val, "single node value");
        assertNull(reversed.next, "single node next");
    }

    public static void main(String[] args) {
        testReverseList();
        testReverseEmptyList();
        testReverseSingleNode();
        System.out.println("LinklistBasicsTest passed");
    }
}