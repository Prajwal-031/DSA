//This file is part of the 15_Dynamic Programming module, which is licensed under the MIT License (MIT).
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicProgrammingBasicsTest {

    @Test
    public void testFibonacci() {
        assertEquals(0, DynamicProgrammingBasics.fibonacci(0));
        assertEquals(1, DynamicProgrammingBasics.fibonacci(1));
        assertEquals(13, DynamicProgrammingBasics.fibonacci(7));
    }

    @Test
    public void testClimbStairs() {
        assertEquals(1, DynamicProgrammingBasics.climbStairs(1));
        assertEquals(2, DynamicProgrammingBasics.climbStairs(2));
        assertEquals(8, DynamicProgrammingBasics.climbStairs(5));
    }

    @Test
    public void testHouseRobber() {
        assertEquals(4, DynamicProgrammingBasics.houseRobber(new int[] {1, 2, 3, 1}));
        assertEquals(12, DynamicProgrammingBasics.houseRobber(new int[] {2, 7, 9, 3, 1}));
        assertEquals(0, DynamicProgrammingBasics.houseRobber(new int[] {}));
    }

    @Test
    public void testCoinChange() {
        assertEquals(3, DynamicProgrammingBasics.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, DynamicProgrammingBasics.coinChange(new int[] {2}, 3));
        assertEquals(0, DynamicProgrammingBasics.coinChange(new int[] {1}, 0));
    }

    @Test
    public void testWordBreak() {
        assertTrue(DynamicProgrammingBasics.wordBreak("leetcode", new String[] {"leet", "code"}));
        assertTrue(DynamicProgrammingBasics.wordBreak("applepenapple", new String[] {"apple", "pen"}));
        assertFalse(
            DynamicProgrammingBasics.wordBreak(
                "catsandog",
                new String[] {"cats", "dog", "sand", "and", "cat"}
            )
        );
    }
}
