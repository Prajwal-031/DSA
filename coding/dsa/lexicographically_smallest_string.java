package dsa;
class lexicographically_smallest_string{
/*************  ✨ Windsurf Command 🌟  *************/
    /**
     * Generate a string based on the given two strings and constraints.
     * The generated string should be the lexicographically smallest possible
     * string while satisfying the given constraints.
     * 
     * @param str1 The first string, which contains 'T' and 'F' characters
     * @param str2 The second string, which contains only lowercase alphabets
     * @return The lexicographically smallest possible string that satisfies the constraints
     */
    public String generateString(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        boolean[] locked = new boolean[len];

        // Initialize the word array with 'a's
        for (int i = 0; i < len; i++)
            word[i] = 'a';

        // Apply T constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                // For each 'T' character, fill in the corresponding characters
                // in the word array with the characters from str2
                for (int j = 0; j < m; j++) {

                    int pos = i + j;

                    if (word[pos] == 'a' || word[pos] == str2.charAt(j)) {
                        word[pos] = str2.charAt(j);
                        locked[pos] = true;
                    } else {
                        // If the word array already contains a different character,
                        // return an empty string because the constraints cannot be satisfied
                        return "";
                    }
                }
            }
        }

        // Apply F constraints
        for (int i = 0; i < n; i++) {

            if (str1.charAt(i) == 'F') {

                boolean match = true;

                // For each 'F' character, check if the corresponding characters
                // in the word array match the characters from str2
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {

                    boolean changed = false;

                    // For each 'F' character, try to find a character in str2 that
                    // is not already in the word array and replace the corresponding character
                    // in the word array with the new character
                    for (int j = m - 1; j >= 0; j--) {

                        int pos = i + j;

                        if (!locked[pos]) {

                            for (char c = 'a'; c <= 'z'; c++) {

                                if (c != str2.charAt(j)) {
                                    word[pos] = c;
                                    changed = true;
                                    break;
                                }
                            }

                            if (changed)
                                break;
                        }
                    }

                    if (!changed)
                        return "";
                }
            }
        }

        return new String(word);
    }

}