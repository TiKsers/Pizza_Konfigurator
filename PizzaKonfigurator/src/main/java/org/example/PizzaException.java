package org.example;

public class PizzaException extends Exception {
    public PizzaException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
