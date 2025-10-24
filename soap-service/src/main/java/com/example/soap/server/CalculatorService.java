package com.example.soap.server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalculatorService {

    @WebMethod
    double add(@WebParam(name = "number1") double number1,
               @WebParam(name = "number2") double number2);

    @WebMethod
    double subtract(@WebParam(name = "number1") double number1,
                    @WebParam(name = "number2") double number2);

    @WebMethod
    double multiply(@WebParam(name = "number1") double number1,
                    @WebParam(name = "number2") double number2);

    @WebMethod
    double divide(@WebParam(name = "number1") double number1,
                  @WebParam(name = "number2") double number2)
            throws IllegalArgumentException;

    @WebMethod
    String sayHello(@WebParam(name = "name") String name);
}