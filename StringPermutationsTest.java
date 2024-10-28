package lab07;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StringPermutationsTest {
    private StringPermutations stringPermutations;

    @Before
    public void setUp() {
        stringPermutations = new StringPermutations();
    }

    @Test
    public void testPermutationsForEmptyString() {
        String input = "";
        String[] expected = { "" };
        assertPermutations(input, expected);
    }

    @Test
    public void testPermutationsForSingleCharacterString() {
        String input = "a";
        String[] expected = { "a" };
        assertPermutations(input, expected);
    }

    @Test
    public void testPermutationsForShortString() {
        String input = "abc";
        String[] expected = { "abc", "acb", "bac", "bca", "cab", "cba" };
        assertPermutations(input, expected);
    }

    @Test
    public void testPermutationsForLongerString() {
        String input = "abcd";
        String[] expected = { "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                              "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                              "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                              "dabc", "dacb", "dbac", "dbca", "dcab", "dcba" };
        assertPermutations(input, expected);
    }

    private void assertPermutations(String input, String[] expected) {
        String[] actualPermutations = stringPermutations.generatePermutations(input).toArray(new String[0]);
        assertArrayEquals(expected, actualPermutations);
    }
}
