package ka.irissin.calculatorspringdemo.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {


    public static String calculator(){
        return "<b>Добро пожаловать в калькулятор</b>";
    }

    public String getCalculatorPlus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        return String.valueOf(num1 + num2);
    }

    public String getCalculatorMinus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        return String.valueOf(num1 - num2);
    }

    public String getCalculatorMultiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        return String.valueOf(num1 * num2);
    }

    public String getCalculatorDivide(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        if (num2 == 0) {
            throw new IllegalArgumentException("На 0 делить нельзя");
        }
        return String.valueOf(num1 / num2);
    }
}
