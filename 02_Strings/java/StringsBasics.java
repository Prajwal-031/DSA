/**
 * Strings - Basic Operations in Java
 * ==================================
 * This file covers fundamental Strings operations
 */

public class StringsBasics {
    
    public static void main(String[] args) {
        // String creation
        String s1 = "Hello";
        String s2 = new String("World");
        
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        
        // String concatenation
        String result = s1 + " " + s2;
        System.out.println("Concatenation: " + result);
        
        // String length
        System.out.println("Length: " + s1.length());
        
        // String indexing
        System.out.println("First char: " + s1.charAt(0));
        System.out.println("Last char: " + s1.charAt(s1.length() - 1));
        
        // Substring
        String s = "Python";
        System.out.println("Substring: " + s.substring(1, 4));
    }
}

