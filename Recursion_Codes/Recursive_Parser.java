import java.util.Stack;

public class ExpressionEvaluator {
    /**
     * Evaluates a mathematical expression represented as a string.
     *
     * @param expression The input mathematical expression (e.g., "3 + 5 * 2").
     * @return The result of the evaluated expression.
     * @throws IllegalArgumentException if the expression is invalid.
     */
    public static double evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty.");
        }

        return evaluate(expression.replaceAll("\\s+", ""));
    }

    private static double evaluate(String expression) {
        // Base case: If the expression is a single number
        if (expression.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            return Double.parseDouble(expression);
        }

        // Handle parentheses recursively
        if (expression.contains("(")) {
            int openIndex = expression.lastIndexOf('(');
            int closeIndex = expression.indexOf(')', openIndex);
            if (closeIndex == -1) {
                throw new IllegalArgumentException("Mismatched parentheses.");
            }

            String innerExpression = expression.substring(openIndex + 1, closeIndex);
            double innerResult = evaluate(innerExpression);
            return evaluate(expression.substring(0, openIndex) + innerResult + expression.substring(closeIndex + 1));
        }

        // Handle operators with precedence (multiplication/division first, addition/subtraction second)
        for (char operator : new char[]{'+', '-', '*', '/'}) {
            int index = findOperatorIndex(expression, operator);
            if (index != -1) {
                double left = evaluate(expression.substring(0, index));
                double right = evaluate(expression.substring(index + 1));
                switch (operator) {
                    case '+': return left + right;
                    case '-': return left - right;
                    case '*': return left * right;
                    case '/': 
                        if (right == 0) throw new ArithmeticException("Division by zero.");
                        return left / right;
                }
            }
        }

        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    private static int findOperatorIndex(String expression, char operator) {
        int balance = 0; // Keeps track of parentheses
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == ')') balance++;
            else if (c == '(') balance--;
            else if (c == operator && balance == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(evaluateExpression("3 + 5 * 2")); // Output: 13.0
        System.out.println(evaluateExpression("(3 + 5) * 2")); // Output: 16.0
        System.out.println(evaluateExpression("10 / 2 - 3")); // Output: 2.0
        System.out.println(evaluateExpression("3.5 + 2.5 * 2")); // Output: 8.5
        System.out.println(evaluateExpression("10 / (5 - 5)")); // Throws ArithmeticException
    }
}
