package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
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

    private  File sizePrices ;
    private  File cheesePrices;
    private  File doughPrices ;
    private  File extrasPrices ;
    private  File meatPrices ;
    private  File saucePrices ;
    private  File specialitiesPrices;
    private  File vegetablesPrices ;
 
    
    public PizzaService(){
    	try {
		sizePrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/sizePrices.csv").toURI());
        cheesePrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/cheesePrices.csv").toURI());
        doughPrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/doughPrices.csv").toURI());
        extrasPrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/extrasPrices.csv").toURI());
        meatPrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/meatPrices.csv").toURI());
        saucePrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/saucePrices.csv").toURI());
        specialitiesPrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/specialitiesPrice.csv").toURI());
        vegetablesPrices = new File(PizzaService.class.getClassLoader().getResource("databaseTextFiles/vegetablesPrices.csv").toURI());
    	} catch (URISyntaxException e) {
			e.printStackTrace();
		}
    }
    
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
    public double total() throws PizzaException {
        double totalPrice = 0.0;
        double sizePrice = getPrice(PizzaServiceDataTableEnum.SIZE, size);
        double doughPrice = getPrice(PizzaServiceDataTableEnum.DOUGH, dough);
        double saucePrice = getPrice(PizzaServiceDataTableEnum.SAUCE, sauce);
        double cheesePrice = getPrice(PizzaServiceDataTableEnum.CHEESE, cheese);
        double meatPrice = getPrice(PizzaServiceDataTableEnum.MEAT, meat);
        double vegetablePrice = getPrice(PizzaServiceDataTableEnum.VEGETABLES, vegetables);
        double extraToppingsPrice;
        if (extraToppings == null) {
            extraToppingsPrice = 0.0;
        } else {
            extraToppingsPrice = getExtraToppingsPrice();
        }
        double specialitiesPrice;
        if (specialities == null) {
            specialitiesPrice = 0.0;
        } else {
            specialitiesPrice = getPrice(PizzaServiceDataTableEnum.SPECIALITIES, specialities);
        }
        double extrasPrice;
        if (extras == null) {
            extrasPrice = 0.0;
        } else {
            extrasPrice = getPrice(PizzaServiceDataTableEnum.EXTRAS, extras);
        }
        totalPrice = sizePrice + doughPrice + saucePrice + cheesePrice +
                meatPrice + vegetablePrice + extraToppingsPrice + specialitiesPrice +
                extrasPrice;
        return totalPrice;
    }

    private double getExtraToppingsPrice() {
        HashSet<PizzaServiceDataTableEnum> extraToppingsEnumSet = new HashSet<>();
        extraToppingsEnumSet.add(PizzaServiceDataTableEnum.MEAT);
        extraToppingsEnumSet.add(PizzaServiceDataTableEnum.VEGETABLES);
        extraToppingsEnumSet.add(PizzaServiceDataTableEnum.CHEESE);
        return getPrice(extraToppingsEnumSet, extraToppings);
    }

    @Override
    public double getPrice(HashSet<PizzaServiceDataTableEnum> textFileDataTables, HashSet<String> names) {
        double price = 0.0;
        for (PizzaServiceDataTableEnum element : textFileDataTables) {
            for (String name : names) {
                try {
                    price += getPrice(element, name);
                } catch (PizzaException ignored) {
                }
            }
        }
        return price;
    }

    @Override
    public double getPrice(PizzaServiceDataTableEnum textFileDataTable, HashSet<String> names) throws PizzaException {
        double price = 0.0;
        for (String name : names) {
            price += getPrice(textFileDataTable, name);
        }
        return price;
    }

    @Override
    public double getPrice(PizzaServiceDataTableEnum textFileDatabase, String name) throws PizzaException {
        File file = getDatabase(textFileDatabase);

        List<String[]> prices = readFromTable(file);
        double price;
        for (String[] namePriceTupel : prices) {
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
//                System.out.println("Name: " + name + " , Price: " + price);
                prices.add(items);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prices;
    }

    @Override
    public Map<String, Double> getReceipt() throws PizzaException {
        TreeMap<String, Double> receipt = new TreeMap<>();
        receipt.put(size, getPrice(PizzaServiceDataTableEnum.SIZE, size));
        receipt.put(dough, getPrice(PizzaServiceDataTableEnum.DOUGH, dough));
        receipt.put(sauce, getPrice(PizzaServiceDataTableEnum.SAUCE, sauce));
        receipt.put(cheese, getPrice(PizzaServiceDataTableEnum.CHEESE, cheese));
        receipt.put(meat, getPrice(PizzaServiceDataTableEnum.MEAT, meat));
        receipt.put(vegetables, getPrice(PizzaServiceDataTableEnum.VEGETABLES, vegetables));
        if (extraToppings != null) {
            receipt.put(getReceiptStringOfSet(extraToppings), getExtraToppingsPrice());
        }
        if (specialities != null) {
            receipt.put(getReceiptStringOfSet(specialities), getPrice(PizzaServiceDataTableEnum.SPECIALITIES, specialities));
        }
        if (extras != null) {
            receipt.put(getReceiptStringOfSet(extras), getPrice(PizzaServiceDataTableEnum.EXTRAS, extras));
        }
        return receipt;
    }
    private String getReceiptStringOfSet(HashSet<String> extraSpecialitySet) {
        StringBuilder pizzaToppingsSpecialities = new StringBuilder();
        pizzaToppingsSpecialities.append("[ ");
        for (String element : extraSpecialitySet) {
            pizzaToppingsSpecialities.append(element);
            pizzaToppingsSpecialities.append(", ");
        }
        int lastIndex = pizzaToppingsSpecialities.lastIndexOf(", ");
        if (lastIndex != -1) {
            pizzaToppingsSpecialities.replace(lastIndex, lastIndex + 2, "");
        }
        pizzaToppingsSpecialities.append(" ]");
        return pizzaToppingsSpecialities.toString();
    }
}
