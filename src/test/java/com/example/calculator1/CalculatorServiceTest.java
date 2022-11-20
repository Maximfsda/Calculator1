package com.example.calculator1;


import com.example.calculator1.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("plusTestSuites")
    public void plus(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));

    }

    @ParameterizedTest
    @MethodSource("minusTestSuites")
    public void minus(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.minus(num1, num2));

    }

    @ParameterizedTest
    @MethodSource("multiplyTestSuites")
    public void multiply(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.multiply(num1, num2));

    }

    @ParameterizedTest
    @MethodSource("devideTestSuites")
    public void devide(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.devide(num1, num2));

    }

    @Test
    public void divideByZeroThrowsExeption() {
        Assertions.assertThrows(Exception.class, () -> {
            calculatorService.devide(1, 0);
        });
    }

    public static List<Arguments> plusTestSuites() {
        return List.of(
                Arguments.of(10, 10, 20),
                Arguments.of(3, -1, 2),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> minusTestSuites() {
        return List.of(
                Arguments.of(10, 10, 0),
                Arguments.of(3, -1, 4),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> multiplyTestSuites() {
        return List.of(
                Arguments.of(10, 2, 20),
                Arguments.of(3, -1, -3),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> devideTestSuites() {
        return List.of(
                Arguments.of(10, 2, 5),
                Arguments.of(3, -1, -3),
                Arguments.of(3, -1, -3)

        );
    }
}
