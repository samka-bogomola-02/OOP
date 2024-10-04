package ka.irissin.calculatorspringdemo.controller;

import ka.irissin.calculatorspringdemo.service.CalculatorService;
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
        return "%s".formatted(calculatorService.getCalculatorPlus(num1,num2));
    }
    @GetMapping("/minus")
    public String calculatorMinus(@RequestParam(value = "num1", required = false) Integer num1,
                                  @RequestParam(value = "num2", required = false) Integer num2){
        return "%s".formatted(calculatorService.getCalculatorMinus(num1,num2));
    }
    @GetMapping("/multiply")
    public String calculatorMultiply(@RequestParam(value = "num1", required = false) Integer num1,
                                     @RequestParam(value = "num2", required = false) Integer num2){
        return "%s".formatted(calculatorService.getCalculatorMultiply(num1,num2));
    }
    @GetMapping("/divide")
    public String calculatorDivide(@RequestParam(value = "num1", required = false) Integer num1,
                                   @RequestParam(value = "num2", required = false) Integer num2){
        return "%s".formatted(calculatorService.getCalculatorDivide(num1,num2));
    }
}
