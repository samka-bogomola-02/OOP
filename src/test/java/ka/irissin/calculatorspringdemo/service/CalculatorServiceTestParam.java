package ka.irissin.calculatorspringdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTestParam {

    private CalculatorService calculatorService;
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }


    @ParameterizedTest
    @MethodSource("calculatorCorrectParameters")
    protected void calculatorPlusCorrect(int q, int w) {
        int expected = q + w;
        int actual = Integer.parseInt(calculatorService.getCalculatorPlus(6, 8));
        assertEquals(expected, performAddition(q, w));
    }

    @ParameterizedTest
    @MethodSource("calculatorCorrectParameters")
    protected void calculatorMinusCorrect(int q, int w) {
        int expected = q - w;
        int actual = Integer.parseInt(calculatorService.getCalculatorMinus(6, 8));
        assertEquals(expected, performSubtraction(q, w));
    }

    @ParameterizedTest
    @MethodSource("calculatorCorrectParameters")
    protected void calculatorMultiplyCorrect(int q, int w) {
        int expected = q * w;
        int actual = Integer.parseInt(calculatorService.getCalculatorMultiply(6, 8));
        assertEquals(expected, performMultiplication(q, w));
    }

    @ParameterizedTest
    @MethodSource("calculatorCorrectParameters")
    protected void calculatorDivideCorrect(int q, int w) {
        if (w != 0) {
            int expected = q / w;
            int actual = Integer.parseInt(calculatorService.getCalculatorDivide(6, 8));
            assertEquals(expected, performDivision(q, w));
        }
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

    public static Stream<Arguments> calculatorCorrectParameters() {
        return Stream.of(
                Arguments.of(78790, 9899),
                Arguments.of(12345, 67890),
                Arguments.of(0, 9899),
                Arguments.of(9899, 0)
        );
    }
}
