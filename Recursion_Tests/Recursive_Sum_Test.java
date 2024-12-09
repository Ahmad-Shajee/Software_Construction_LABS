import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsCalculatorTest {

    @Test
    void testPositiveNumbers() {
        assertEquals(6, SumOfDigitsCalculator.sumOfDigits(123));
        assertEquals(15, SumOfDigitsCalculator.sumOfDigits(456));
        assertEquals(45, SumOfDigitsCalculator.sumOfDigits(987654321));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(6, SumOfDigitsCalculator.sumOfDigits(-123));
        assertEquals(15, SumOfDigitsCalculator.sumOfDigits(-456));
        assertEquals(45, SumOfDigitsCalculator.sumOfDigits(-987654321));
    }

    @Test
    void testZero() {
        assertEquals(0, SumOfDigitsCalculator.sumOfDigits(0));
    }

    @Test
    void testEdgeCases() {
        assertEquals(1, SumOfDigitsCalculator.sumOfDigits(1000000000));
        assertEquals(9, SumOfDigitsCalculator.sumOfDigits(-9));
    }
}
