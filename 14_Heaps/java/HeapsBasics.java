/**
 * Heaps - Interview prep (Java)
 * =============================
 * Starter layout: add real methods for Heaps as you study.
 */
public class HeapsBasics {

    private static final String TOPIC = "Heaps";

    public static String describe() {
        return "Topic: " + TOPIC + ". Add real structures and algorithms for interviews.";
    }

    public static String[] checklist() {
        return new String[] {
            "Definition and when to use Heaps",
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
    }
}