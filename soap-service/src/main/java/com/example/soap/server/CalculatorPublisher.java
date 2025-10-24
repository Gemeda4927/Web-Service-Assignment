package com.example.soap.server;

import jakarta.xml.ws.Endpoint;

public class CalculatorPublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8081/calculator";

        System.out.println("Publishing SOAP Web Service at: " + url);
        System.out.println("WSDL will be available at: " + url + "?wsdl");

        Endpoint endpoint = Endpoint.publish(url, new CalculatorServiceImpl());

        System.out.println("SOAP Web Service is running...");
        System.out.println("Press any key to stop the service...");

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        endpoint.stop();
        System.out.println("SOAP Web Service stopped.");
    }
}