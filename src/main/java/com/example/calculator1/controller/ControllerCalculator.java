package com.example.calculator1.controller;

import com.example.calculator1.exeptions.IllegalNumberExeption;
import com.example.calculator1.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class ControllerCalculator {
    private final CalculatorService calculatorService;
    public ControllerCalculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(value = IllegalNumberExeption.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberExeption e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Username!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = CalculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = CalculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = CalculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping("/devide")
    public String devide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = CalculatorService.devide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);
    }
}
