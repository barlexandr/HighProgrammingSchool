package stack;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PostfixNotationCalculator {

    private final Stack<Double> operand;

    public PostfixNotationCalculator() {
        this.operand = new Stack<>();
    }

    public double calculate(String expression) throws IOException {
        var array = expression.toCharArray();
        StringBuilder tempDigit = new StringBuilder();

        for (char c : array) {
            if (Character.isDigit(c)) {
                tempDigit.append(c);
                continue;
            }
            if ((c == ' ' || c == '+' || c == '-' || c == '*' || c == '/')
                    && !tempDigit.toString().isEmpty()) {
                operand.push(Double.parseDouble(tempDigit.toString()));
                tempDigit.setLength(0);
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                var secondElement = operand.pop();
                var firstElement = operand.pop();
                operand.push(getResult(firstElement, secondElement, c));
                continue;
            }
            if (c == '=') {
                return operand.pop();
            }
            if (!(c == ' ')) {
                throw new IOException("The above expression contains invalid characters.\" +\n" +
                        "\\nUse only numbers and operators * / + -");
            }
        }
        return operand.pop();
    }

    private double getResult(double one, double two, char operator) throws IOException {
        BigDecimal oneBd = BigDecimal.valueOf(one);
        BigDecimal twoBd = BigDecimal.valueOf(two);
        if (operator == '+') {
            return oneBd.add(twoBd).doubleValue();
        }
        if (operator == '-') {
            return oneBd.subtract(twoBd).doubleValue();
        }
        if (operator == '*') {
            return oneBd.multiply(twoBd).doubleValue();
        }
        if (operator == '/' && twoBd.equals(BigDecimal.ZERO)) {
            throw new IOException("Division by zero is not allowed");
        }
        if (operator == '/') {
            return oneBd.divide(twoBd, 5, RoundingMode.CEILING).doubleValue();
        }
        throw new IOException("The above expression contains invalid characters.\" +\n" +
                "\\nUse only numbers and operators * / + -");
    }

}
