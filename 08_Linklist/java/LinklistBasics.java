/**
 * Linklist - Interview prep (Java)
 * =============================
 * Real linked list examples and algorithm patterns.
 */

public class LinklistBasics {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static final String TOPIC = "Linklist";

    public static String describe() {
        return "Topic: " + TOPIC + ". Includes node class, operations, and example problems.";
    }

    public static String[] checklist() {
        return new String[] {
            "Definition and when to use Linklist",
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

        demoLinkedListOperations();
        demoReverseList();
    }

    private static void demoLinkedListOperations() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Original list: ");
        printList(head);

        // Insert at head
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        System.out.print("After insert at head: ");
        printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static void demoReverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Before reverse: ");
        printList(head);

        ListNode reversed = reverseList(head);
        System.out.print("After reverse: ");
        printList(reversed);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
