package org.example;

import java.util.HashSet;

import static org.example.PizzaServiceDataTableEnum.*;

public class Main {
    public static void main(String[] args) throws PizzaException {
        PizzaService pizzaService = new PizzaService();
        System.out.println("tomato " + pizzaService.getPrice(SAUCE, "tomato"));
        System.out.println("mozzarella" + pizzaService.getPrice(CHEESE, "mozzarella"));
        System.out.println("classic" + pizzaService.getPrice(DOUGH, "classic"));
        System.out.println("salat" + pizzaService.getPrice(EXTRAS, "salat"));
        System.out.println("salami" + pizzaService.getPrice(MEAT, "salami"));
        System.out.println("medium" + pizzaService.getPrice(SIZE, "medium"));
        System.out.println("seafood" + pizzaService.getPrice(SPECIALITIES, "seafood"));
        System.out.println("onion" + pizzaService.getPrice(VEGETABLES, "onion"));


        HashSet<String> extras = new HashSet<>();
        extras.add("salat");
        HashSet<String> specialities = new HashSet<>();
        specialities.add("seafood");
        pizzaService.configurePizza("medium", "classic", "tomato",
                "mozzarella", "salami", "onion", null, specialities, extras, 200,false);

        System.out.println("total price: " + pizzaService.total() + "€");
        System.out.println(pizzaService.getReceipt());
    }
}