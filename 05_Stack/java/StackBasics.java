import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack - Basic operations in Java
 * ==================================
 * Prefer Deque (ArrayDeque) as a stack: push = addFirst/push, pop = removeFirst/pop.
 * Avoid legacy java.util.Stack (extends Vector; synchronized overhead).
 */
public class StackBasics {

    /** Demo: stack operations using ArrayDeque as LIFO stack. */
    public static void stackDemo() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }
        System.out.println("empty? " + stack.isEmpty());
    }

    /** LeetCode 20 style: valid parentheses. */
    public static boolean isValidParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        stackDemo();
        System.out.println("()[]{} valid? " + isValidParentheses("()[]{}"));
        System.out.println("(] valid? " + isValidParentheses("(]"));
    }
}
