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

    double total() throws PizzaException;

    double getPrice(PizzaServiceDataTableEnum table, String name) throws PizzaException;
    public double getPrice(PizzaServiceDataTableEnum textFileDataTable, HashSet<String> names) throws PizzaException;
    public double getPrice(HashSet<PizzaServiceDataTableEnum> textFileDataTables, HashSet<String> names);

    Map<String, Double> getReceipt() throws PizzaException;
}
