package stack;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PostfixNotationCalculatorTest {

    @Test
    void test_successWithEqualSign() throws IOException {
        var calculator = new PostfixNotationCalculator();

        var result = calculator.calculate("83 2 + 5 * 9 + =");

        assertEquals(result, 434);
    }

    @Test
    void test_successWithEqualSignDivide() throws IOException {
        var calculator = new PostfixNotationCalculator();

        var result = calculator.calculate("83 2 / 5 * 9 + =");

        assertEquals(result, 216.5);
    }

    @Test
    void test_successWithoutEqualSign() throws IOException {
        var calculator = new PostfixNotationCalculator();

        var result = calculator.calculate("1 2 + 3 *");

        assertEquals(result, 9);
    }

    @Test
    void test_successWithoutEqualSign_withoutSpace() throws IOException {
        var calculator = new PostfixNotationCalculator();

        var result = calculator.calculate("1 2+3*");

        assertEquals(result, 9);
    }

    @Test
    void test_throwException_incorrectSymbol() {
        var calculator = new PostfixNotationCalculator();

        assertThrows(IOException.class, () -> calculator.calculate("1 2+3*y"));
    }

    @Test
    void test_throwException_incorrectSymbolInsteadOfOperator() {
        var calculator = new PostfixNotationCalculator();

        assertThrows(IOException.class, () -> calculator.calculate("1 2z3*"));
    }

}