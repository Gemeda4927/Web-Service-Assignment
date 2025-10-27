package com.example.soap.server;

import jakarta.jws.WebService;

@WebService
public class CalculatorServiceImpl {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    public int modulus(int a, int b) {
        return a % b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number.");
        }
        return Math.sqrt(value);
    }
}