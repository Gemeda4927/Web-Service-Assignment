package com.example.soap.server;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.example.soap.server.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double add(double number1, double number2) {
        System.out.println("Adding: " + number1 + " + " + number2);
        return number1 + number2;
    }

    @Override
    public double subtract(double number1, double number2) {
        System.out.println("Subtracting: " + number1 + " - " + number2);
        return number1 - number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        System.out.println("Multiplying: " + number1 + " * " + number2);
        return number1 * number2;
    }

    @Override
    public double divide(double number1, double number2) throws IllegalArgumentException {
        System.out.println("Dividing: " + number1 + " / " + number2);
        if (number2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return number1 / number2;
    }

    @Override
    public String sayHello(String name) {
        String message = "Hello, " + name + "! Welcome to SOAP Web Service.";
        System.out.println("Saying hello to: " + name);
        return message;
    }
}
