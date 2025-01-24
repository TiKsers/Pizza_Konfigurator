package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class SystemTest {
    @Test
    public void systemTest() throws PizzaException {
        PizzaGUI pizzaGUI = new PizzaGUI();
        JButton button = pizzaGUI.getCreatePizzaButton();
        button.doClick();
        JLabel priceLabel = pizzaGUI.getPriceLabel();
        String price = priceLabel.getText();
        Assert.assertEquals(Double.valueOf(price), 8.0, 0.01);
    }
}
