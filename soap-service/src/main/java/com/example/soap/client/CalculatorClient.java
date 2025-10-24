package com.example.soap.client;

import com.example.soap.server.CalculatorService;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URL;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // URL of the WSDL
            URL wsdlURL = new URL("http://localhost:8081/calculator?wsdl");

            // QName representing the service
            QName qname = new QName("http://server.soap.example.com/", "CalculatorServiceImplService");

            // Create service
            Service service = Service.create(wsdlURL, qname);

            // Get the port
            CalculatorService calculator = service.getPort(CalculatorService.class);

            // Test the service operations
            System.out.println("=== Testing SOAP Web Service ===");

            // Test addition
            double result1 = calculator.add(10, 5);
            System.out.println("10 + 5 = " + result1);

            // Test subtraction
            double result2 = calculator.subtract(10, 5);
            System.out.println("10 - 5 = " + result2);

            // Test multiplication
            double result3 = calculator.multiply(10, 5);
            System.out.println("10 * 5 = " + result3);

            // Test division
            double result4 = calculator.divide(10, 5);
            System.out.println("10 / 5 = " + result4);

            // Test hello method
            String greeting = calculator.sayHello("John");
            System.out.println("Greeting: " + greeting);

            // Test error case
            try {
                calculator.divide(10, 0);
            } catch (IllegalArgumentException e) {
                System.out.println("Error handled: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}