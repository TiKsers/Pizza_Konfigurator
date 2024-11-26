package org.example;

import static org.example.PizzaServiceDataTableEnum.SAUCE;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws PizzaException {
        PizzaService pizzaService = new PizzaService();
        System.out.println(pizzaService.getPrice(SAUCE, "tomato"));
    }
}