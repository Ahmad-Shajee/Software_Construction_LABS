public class SumOfDigitsCalculator {

    /**
     * Computes the sum of digits of a given integer using recursion.
     *
     * @param number the input number (can be positive or negative).
     * @return the sum of digits of the absolute value of the input number.
     */
    public static int sumOfDigits(int number) {
        // Convert negative numbers to positive
        number = Math.abs(number);

        // Base case: if the number is reduced to 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: add the last digit to the sum of digits of the remaining number
        return (number % 10) + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {
        System.out.println("Sum of digits (123): " + sumOfDigits(123));  // Output: 6
        System.out.println("Sum of digits (-456): " + sumOfDigits(-456));  // Output: 15
        System.out.println("Sum of digits (0): " + sumOfDigits(0));  // Output: 0
        System.out.println("Sum of digits (987654321): " + sumOfDigits(987654321));  // Output: 45
    }
}
