package com.example.soap.client;

import com.example.soap.server.CalculatorService;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URL;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            URL wsdlURL = new URL("http://localhost:8081/calculator?wsdl");

            QName qname = new QName("http://server.soap.example.com/", "CalculatorServiceImplService");

            Service service = Service.create(wsdlURL, qname);

            CalculatorService calculator = service.getPort(CalculatorService.class);

            System.out.println("=== Testing SOAP Web Service ===");

            double result1 = calculator.add(10, 5);
            System.out.println("10 + 5 = " + result1);

            double result2 = calculator.subtract(10, 5);
            System.out.println("10 - 5 = " + result2);

            double result3 = calculator.multiply(10, 5);
            System.out.println("10 * 5 = " + result3);

            double result4 = calculator.divide(10, 5);
            System.out.println("10 / 5 = " + result4);

            String greeting = calculator.sayHello("John");
            System.out.println("Greeting: " + greeting);

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
