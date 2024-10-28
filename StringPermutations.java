package lab07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Java program generates all permutations of a given string using a recursive algorithm.
 */
public class StringPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        if (input.isEmpty()) {
            System.out.println("Input string is empty.");
        } else {
            List<String> permutations = generatePermutations(input);

            if (permutations.isEmpty()) {
                System.out.println("No permutations found for the input string.");
            } else {
                System.out.println("Permutations of the input string:");
                for (String permutation : permutations) {
                    System.out.println(permutation);
                }
            }
        }
    }

    /**
     * Generates all permutations of the input string.
     *
     * @param input The input string for which permutations are to be generated.
     * @return A list of all permutations of the input string.
     */
    public static List<String> generatePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsRecursive("", input, permutations);
        return permutations;
    }

    /**
     * Recursively generates permutations of the input string.
     *
     * @param prefix      The current permutation being built.
     * @param remaining   The remaining characters for permutation.
     * @param permutations The list to store generated permutations.
     */
    private static void generatePermutationsRecursive(String prefix, String remaining, List<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsRecursive(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), permutations);
            }
        }
    }
}
