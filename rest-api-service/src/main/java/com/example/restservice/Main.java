package com.example.restservice;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) {
        try {
            final ResourceConfig rc = new ResourceConfig()
                    .packages("com.example.restservice.resource"); // IMPORTANT

            final HttpServer server = GrizzlyHttpServerFactory
                    .createHttpServer(URI.create(BASE_URI), rc);

            System.out.println("REST API Service started at: " + BASE_URI);
            System.out.println("Available endpoints:");
            System.out.println("  GET    " + BASE_URI + "products");
            System.out.println("  GET    " + BASE_URI + "products/{id}");
            System.out.println("  POST   " + BASE_URI + "products");
            System.out.println("  PUT    " + BASE_URI + "products/{id}");
            System.out.println("  DELETE " + BASE_URI + "products/{id}");
            System.out.println("Press 'Ctrl + C' to stop the server...");

            Thread.currentThread().join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
