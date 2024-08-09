package ika.sin.sinikaspringdemo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class CalculatorService {

    public String calculator(){
        return "<b>Добро пожаловать в калькулятор</b>";
    }
    public int calculatorPlus(@RequestParam int num1, @RequestParam int num2){
        return num1 + num2;
    }
    public int calculatorMinus(@RequestParam int num1, @RequestParam int num2){
        return num1 - num2;
    }
    public int calculatorMultiply(@RequestParam int num1, @RequestParam int num2){
        return num1 * num2;
    }
    public int calculatorDivide(@RequestParam int num1, @RequestParam int num2){
        return num1 / num2;
    }
}
