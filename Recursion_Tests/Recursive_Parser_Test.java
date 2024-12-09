import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    @Test
    void testSimpleExpressions() {
        assertEquals(13.0, ExpressionEvaluator.evaluateExpression("3 + 5 * 2"));
        assertEquals(8.0, ExpressionEvaluator.evaluateExpression("10 - 2"));
        assertEquals(15.0, ExpressionEvaluator.evaluateExpression("5 * 3"));
    }

    @Test
    void testExpressionsWithParentheses() {
        assertEquals(16.0, ExpressionEvaluator.evaluateExpression("(3 + 5) * 2"));
        assertEquals(10.0, ExpressionEvaluator.evaluateExpression("(2 + 3) * (4 / 2)"));
    }

    @Test
    void testExpressionsWithFloatingPointNumbers() {
        assertEquals(8.5, ExpressionEvaluator.evaluateExpression("3.5 + 2.5 * 2"));
        assertEquals(5.0, ExpressionEvaluator.evaluateExpression("10.0 / 2"));
    }

    @Test
    void testInvalidExpressions() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionEvaluator.evaluateExpression(null));
        assertThrows(IllegalArgumentException.class, () -> ExpressionEvaluator.evaluateExpression(""));
        assertThrows(IllegalArgumentException.class, () -> ExpressionEvaluator.evaluateExpression("3 + + 5"));
        assertThrows(IllegalArgumentException.class, () -> ExpressionEvaluator.evaluateExpression("5 + (3 * 2"));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ExpressionEvaluator.evaluateExpression("10 / 0"));
        assertThrows(ArithmeticException.class, () -> ExpressionEvaluator.evaluateExpression("10 / (5 - 5)"));
    }
}
