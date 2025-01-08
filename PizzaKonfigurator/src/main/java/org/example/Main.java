package org.example;

import java.util.HashSet;

import static org.example.PizzaServiceDataTableEnum.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws PizzaException {
        PizzaService pizzaService = new PizzaService();
        System.out.println(pizzaService.getPrice(SAUCE, "tomato"));
        System.out.println(pizzaService.getPrice(CHEESE, "mozzarella"));
        System.out.println(pizzaService.getPrice(DOUGH, "classic"));
        System.out.println(pizzaService.getPrice(EXTRAS, "salat"));
        System.out.println(pizzaService.getPrice(MEAT, "salami"));
        System.out.println(pizzaService.getPrice(SIZE, "medium"));
        System.out.println(pizzaService.getPrice(SPECIALITIES, "seafood"));
        System.out.println(pizzaService.getPrice(VEGETABLES, "onion"));


        HashSet<String> extras = new HashSet<>();
        extras.add("salat");
        HashSet<String> specialities = new HashSet<>();
        specialities.add("seafood");
        pizzaService.configurePizza("medium", "classic", "tomato",
                "mozzarella", "salami", "onion", null, specialities, extras, 200,false);

        System.out.println(pizzaService.total());
    }
}