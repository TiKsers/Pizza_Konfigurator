package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.jupiter.api.Test;

class PizzaServiceTest {

    @Test
    public void testConfigurePizzaValidInputs(){
    	PizzaService pizzaService = new PizzaService();
        HashSet<String> extraToppings = new HashSet<>();
        HashSet<String> specialities = new HashSet<>();
        HashSet<String> extras = new HashSet<>();

        boolean result;
		try {
			result = pizzaService.configurePizza("small", "classic", "tomato", "mozzarella", "", "", null, null, null, 220, false);
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
		} catch (PizzaException e) {} 
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
		double totalPrice = -1.0;
		
        try {
        	
			pizzaService.configurePizza("small", "classic", "tomato", "mozzarella", null, null, null, null, null, 220, false);
        } catch (PizzaException e) {
			fail("pizza couldn't be configured");
        }
        
        try {
        	totalPrice = pizzaService.total();
			
		} catch (PizzaException e) {
			fail("total() couldn't be calculated");
		}
        assertEquals(5.00, totalPrice);
	}

	@Test
	void testGetPrice() {
		PizzaService pizzaService = new PizzaService();
		
		try {
			double priceSmallPizzaElement = pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "small");
			assertEquals(6.0, priceSmallPizzaElement);
		} catch (PizzaException e) {
		}
	}
	
	@Test
	void testGetReceipt() {
		PizzaService pizzaService = new PizzaService();
		Map<String, Double> receipt; 
		
        try {
        	
			pizzaService.configurePizza("small", "classic", "tomato", "mozzarella", null, null, null, null, null, 220, false);
        } catch (PizzaException e) {
			fail("pizza couldn't be configured couldn't be calculated");
        }
        
        try {
        	receipt = pizzaService.getReceipt();
        	assertEquals(5.00, receipt.get("small"));
		} catch (PizzaException e) {
			fail("getReceipt() couldn't be calculated");
		}
        
	}

}
