import java.util.HashMap;
import java.util.Map;

/**
 * Trie - Basic operations in Java
 * ===============================
 * Supports insert, search, and startsWith.
 */
public class TrieBasics {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String text) {
        TrieNode node = root;
        for (char ch : text.toCharArray()) {
            TrieNode next = node.children.get(ch);
            if (next == null) {
                return null;
            }
            node = next;
        }
        return node;
    }

    public static void main(String[] args) {
        TrieBasics trie = new TrieBasics();
        String[] words = {"apple", "app", "apt", "bat"};
        for (String w : words) {
            trie.insert(w);
        }

        System.out.println("search('app'): " + trie.search("app"));
        System.out.println("search('ap'): " + trie.search("ap"));
        System.out.println("startsWith('ap'): " + trie.startsWith("ap"));
        System.out.println("startsWith('cat'): " + trie.startsWith("cat"));
    }
}
