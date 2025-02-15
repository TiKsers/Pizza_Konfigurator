package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {

    @Test
    public void testConfigurePizzaValidInputs(){
        PizzaService pizzaService = new PizzaService();
        HashSet<String> extraToppings = new HashSet<>();
        HashSet<String> specialities = new HashSet<>();
        HashSet<String> extras = new HashSet<>();

        boolean result;
        try {
            result = pizzaService.configurePizza("small", "classic", "tomato", "mozzarella", "", "", extraToppings, specialities, extras, 220, false);
            assertTrue(result);
        } catch (PizzaException e) {}
    }

    @Test
    public void testConfigurePizzaFalseInputs(){
        PizzaService pizzaService = new PizzaService();
        HashSet<String> extraToppings = new HashSet<>();
        HashSet<String> specialities = new HashSet<>();
        HashSet<String> extras = new HashSet<>();

        boolean result;
        try {
            result = pizzaService.configurePizza("This", "is", "a", "completely", "false", "pizza input", null, null, null, 1000000, false);
            assertEquals(false, result);
        } catch (PizzaException e) {
        }
    }

    @Test
    public void testConfigurePizzaInvalidInputs() throws PizzaException {
        PizzaService pizzaService = new PizzaService();
        HashSet<String> extraToppings = new HashSet<>();
        HashSet<String> specialities = new HashSet<>();
        HashSet<String> extras = new HashSet<>();


        try {
            pizzaService.configurePizza("Large", "gluten free", "Tomato", "Mozzarella", "Pepperoni", "Olives", extraToppings, specialities, extras, 220, false);
            fail();
        } catch (PizzaException e) {
            assertTrue(true);
        }
        try {
            pizzaService.configurePizza("Large", "thin", "Tomato", "Mozzarella", "Pepperoni", "Olives", extraToppings, specialities, extras, 220, true);
            fail();
        } catch (PizzaException e) {
            assertTrue(true);
        }
    }

    @Test
    void testTotal() {
        PizzaService pizzaService = new PizzaService();
        Map<String, Double> receipt;
        double totalPrice = 0.0;

        HashSet<String> extraToppings= new HashSet<>();
        extraToppings.add("mozzarella");
        HashSet<String> specialities= new HashSet<>();
        specialities.add("seafood");
        HashSet<String> extras = new HashSet<>();
        extras.add("salat");


        try {

            pizzaService.configurePizza("small", "classic", "tomato", "mozzarella", "ham", "champignons", extraToppings, specialities, extras, 220, false);
        } catch (PizzaException e) {
            fail("pizza couldn't be configured");
        }

        try {
            totalPrice = pizzaService.total();

        } catch (PizzaException e) {
            fail("total() couldn't be calculated");
        }
        assertEquals(14.5, totalPrice);
    }

    @Test
    void testGetPrice() {
        PizzaService pizzaService = new PizzaService();

        try {
            double priceSmallPizzaElement = pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "small");
            assertEquals(6.0, priceSmallPizzaElement);
        } catch (PizzaException e) {
            Assert.fail();
        }
    }


    @Test
    void testGetReceipt() {
        PizzaService pizzaService = new PizzaService();
        Map<String, Double> receipt;

        HashSet<String> extraToppings= new HashSet<>();
        extraToppings.add("mozzarella");
        HashSet<String> specialities= new HashSet<>();
        specialities.add("seafood");
        HashSet<String> extras = new HashSet<>();
        extras.add("salat");


        try {

            pizzaService.configurePizza("small", "classic", "tomato", "mozzarella", "ham", "champignons", extraToppings, specialities, extras, 220, false);
        } catch (PizzaException e) {
            fail("pizza couldn't be configured");
        }

        try {
            receipt = pizzaService.getReceipt();

            double total = 0.0;
            for (Map.Entry<String, Double> entry : receipt.entrySet()) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
                total += entry.getValue();
            }

            assertEquals(14.5, total);
            assertEquals(6.0, receipt.get("small"));
//        	System.out.println("#### total: "+pizzaService.total());

        } catch (PizzaException e) {
            fail();
        }

    }


    @Test
    void testGetDatabase() {
        PizzaService pizzaService = new PizzaService();


        try {

            double SIZE = pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "small");
            // small = 6.0
            double CHEESE = pizzaService.getPrice(PizzaServiceDataTableEnum.CHEESE, "parmesan");
            // parmesan = 1.0
            double DOUGH = pizzaService.getPrice(PizzaServiceDataTableEnum.DOUGH, "cheese edge");
            // cheese edge = 0.5
            double EXTRAS = pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "salat");
            // salat = 4.0
            double MEAT = pizzaService.getPrice(PizzaServiceDataTableEnum.MEAT, "kebab");
            // kebab = 1.0
            double SAUCE = pizzaService.getPrice(PizzaServiceDataTableEnum.SAUCE, "bbq");
            // bbq = 0.5
            double SPECIALITIES = pizzaService.getPrice(PizzaServiceDataTableEnum.SPECIALITIES, "seafood");
            // seafood = 2
            double VEGETABLES = pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "champignons");
            // champignons = 0.5


            assertEquals(6.0, SIZE);
            assertEquals(1.0, CHEESE);
            assertEquals(0.5, DOUGH);
            assertEquals(4.0, EXTRAS);
            assertEquals(1.0, MEAT);
            assertEquals(0.5, SAUCE);
            assertEquals(2.0, SPECIALITIES);
            assertEquals(0.5, VEGETABLES);

        } catch (PizzaException e) {
            Assert.fail();
        }
    }


}
