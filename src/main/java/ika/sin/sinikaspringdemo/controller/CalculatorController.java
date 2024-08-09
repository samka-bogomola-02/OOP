package ika.sin.sinikaspringdemo.controller;

import ika.sin.sinikaspringdemo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String calculator(){
        return calculatorService.calculator();
    }
    @GetMapping("/plus")
    public String calculatorPlus(@RequestParam(value = "num1", required = false) Integer num1,
                              @RequestParam(value = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null){
            return "не передан параметр";
        }
        return "%s".formatted(calculatorService.calculatorPlus(num1,num2));
    }
    @GetMapping("/minus")
    public String calculatorMinus(@RequestParam(value = "num1", required = false) Integer num1,
                                  @RequestParam(value = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        return "%s".formatted(calculatorService.calculatorMinus(num1,num2));
    }
    @GetMapping("/multiply")
    public String calculatorMultiply(@RequestParam(value = "num1", required = false) Integer num1,
                                  @RequestParam(value = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        return "%s".formatted(calculatorService.calculatorMultiply(num1,num2));
    }
    @GetMapping("/divide")
    public String calculatorDivide(@RequestParam(value = "num1", required = false) Integer num1,
                                @RequestParam(value = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null) {
            return "не передан параметр";
        }
        if (num2 == 0){
            return "делить на 0 нельзя";
        }
        return "%s".formatted(calculatorService.calculatorDivide(num1,num2));
    }
}
