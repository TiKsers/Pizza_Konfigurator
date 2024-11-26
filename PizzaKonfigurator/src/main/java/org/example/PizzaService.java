package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PizzaService implements PizzaServiceInterface {
    private String size;
    private String dough;
    private String sauce;
    private String cheese;
    private String meat;
    private String vegetables;
    private HashSet<String> extraToppings;
    private HashSet<String> specialities;
    private HashSet<String> extras;
    private int bakingDegree;
    private boolean isGlutenFree;

    private final File sizePrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\sizePrices.csv");
    private final File cheesePrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\cheesePrices.csv");
    private final File doughPrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\doughPrices.csv");
    private final File extrasPrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\extrasPrices.csv");
    private final File meatPrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\meatPrices.csv");
    private final File saucePrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\saucePrices.csv");
    private final File specialitiesPrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\specialitiesPrices.csv");
    private final File vegetablesPrices = new File("PizzaKonfigurator\\src\\main\\resources\\databaseTextFiles\\vegetablesPrices.csv");

    public PizzaService() {}

    @Override
    public boolean configurePizza(String size,
                                  String dough,
                                  String sauce,
                                  String cheese,
                                  String meat,
                                  String vegetables,
                                  HashSet<String> extraToppings,
                                  HashSet<String> specialities,
                                  HashSet<String> extras,
                                  int bakingDegree,
                                  boolean isGlutenFree) throws PizzaException {
        this.size = size;
        this.dough = dough;
        this.sauce = sauce;
        this.cheese = cheese;
        this.meat = meat;
        this.vegetables = vegetables;
        this.extraToppings = extraToppings;
        this.specialities = specialities;
        this.extras = extras;
        this.bakingDegree = bakingDegree;
        this.isGlutenFree = isGlutenFree;

        checkIfGlutenFree(isGlutenFree, dough);




        return true;
    }

    private void checkIfGlutenFree(boolean isGlutenFree, String dough) throws PizzaException {
        if ((isGlutenFree && !dough.equals("gluten free")) || (!isGlutenFree && dough.equals("gluten free"))) {
            throw new PizzaException("String in dough seems not to be gluten free, even though gluten free was given as argument", new IllegalArgumentException());
        }
    }

    @Override
    public double total() {
        return 0;
    }

    @Override
    public double getPrice(PizzaServiceDataTableEnum textFileDatabase, String name) throws PizzaException {
        File file = getDatabase(textFileDatabase);

        List<String[]> prices = readFromTable(file);
        double price;
        for(String[] namePriceTupel : prices) {
            if (namePriceTupel[0].equals(name)) {
                price = Double.parseDouble(namePriceTupel[1]);
                return price;
            }
        }
        throw new PizzaException("No entry found in database.", new NoSuchElementException());
    }

    private File getDatabase(PizzaServiceDataTableEnum textFileDatabase) throws PizzaException {
        File file;
        switch (textFileDatabase) {
            case SIZE -> file = sizePrices;
            case DOUGH -> file = doughPrices;
            case SAUCE -> file = saucePrices;
            case CHEESE -> file = cheesePrices;
            case MEAT -> file = meatPrices;
            case VEGETABLES -> file = vegetablesPrices;
            case SPECIALITIES -> file = specialitiesPrices;
            case EXTRAS -> file = extrasPrices;
            default -> throw new PizzaException("database file was not found. ", new IllegalStateException());
        }
        return file;
    }

    public List<String[]> readFromTable(File file) {
        List<String[]> prices = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                String[] items = line.split(csvSplitBy);
                String name = items[0];
                String price = items[1];
                System.out.println("Name: " + name + " , Price: " + price);
                prices.add(items);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prices;
    }

    @Override
    public List<Map<String, Double>> getReceipt() {
        return null;
    }
}
