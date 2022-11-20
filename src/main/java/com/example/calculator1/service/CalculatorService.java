package com.example.calculator1.service;

import com.example.calculator1.exeptions.IllegalNumberExeption;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int devide(int num1, int num2) {
        if(num2 == 0){
            try {
                throw new IllegalNumberExeption("Нельзя делить на ноль!");
            } catch (IllegalNumberExeption e) {
                throw new RuntimeException(e);
            }
        }
        return num1 / num2;
    }
}

