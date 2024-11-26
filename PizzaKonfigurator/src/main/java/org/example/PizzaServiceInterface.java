package org.example;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface PizzaServiceInterface {
    boolean configurePizza(String size,
                           String dough,
                           String sauce,
                           String cheese,
                           String meat,
                           String vegetables,
                           HashSet<String> extraToppings,
                           HashSet<String> specialities,
                           HashSet<String> extras,
                           int bakingDegree,
                           boolean isGlutenFree) throws PizzaException;

    double total();

    double getPrice(PizzaServiceDataTableEnum table, String name) throws PizzaException;
    List<Map<String, Double>> getReceipt();
}
