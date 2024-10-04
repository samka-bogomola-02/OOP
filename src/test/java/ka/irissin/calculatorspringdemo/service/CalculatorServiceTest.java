package ka.irissin.calculatorspringdemo.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private CalculatorService calculatorService;
    private int q;
    private int w;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
        int q = 78790;
        int w = 9899;
    }
    @Test
    void calculatorPrint() {
        String expected = "<b>Добро пожаловать в калькулятор</b>";
        String actual = CalculatorService.calculator();
        assertEquals(expected, actual);
    }

    @Test
    void calculatorPlusCorrect() {
        assertEquals(q + w, performAddition(q, w));
    }

    @Test
    void calculatorPlusWhenNullThrowException() {
        assertThrows(IllegalArgumentException.class, () -> performAddition(5, null));
    }

    @Test
    void calculatorMinusCorrect() {
        assertEquals(q - w, performSubtraction(q, w));
    }

    @Test
    void calculatorMinusWhenNullThrowException() {
        assertThrows(IllegalArgumentException.class, () -> performSubtraction(5, null));
    }

    @Test
    void calculatorMultiplyCorrect() {
        assertEquals(q * w, performMultiplication(q, w));
    }

    @Test
    void calculatorMultiplyWhenNullThrowException() {
        assertThrows(IllegalArgumentException.class, () -> performMultiplication(5, null));
    }

    @Test
    void calculatorDivideCorrect() {
        if (w != 0) {
            assertEquals(q / w, performDivision(q, w));
        }
    }
    @Test
    void calculatorDivideWhenZeroThrowException() {
        assertThrows(IllegalArgumentException.class, () -> performDivision(q, 0));
    }

    @Test
    void calculatorDivideWhenNullThrowException() {
        assertThrows(IllegalArgumentException.class, () -> performDivision(5, null));
    }
    @Test
    void calculatorDivideReturnsCorrectValue() {
        int num1 = 10;
        int num2 = 2;
        String expected = String.valueOf(num1 / num2);

        String actual = String.valueOf(performDivision(num1, num2));

        assertEquals(expected, actual);
    }

    // Вспомогательные методы
    private int performAddition(Integer a, Integer b) {
        return Integer.parseInt(calculatorService.getCalculatorPlus(a, b));
    }

    private int performSubtraction(Integer a, Integer b) {
        return Integer.parseInt(calculatorService.getCalculatorMinus(a, b));
    }

    private int performMultiplication(Integer a, Integer b) {
        return Integer.parseInt(calculatorService.getCalculatorMultiply(a, b));
    }

    private int performDivision(Integer a, Integer b) {
        return Integer.parseInt(calculatorService.getCalculatorDivide(a, b));
    }

}