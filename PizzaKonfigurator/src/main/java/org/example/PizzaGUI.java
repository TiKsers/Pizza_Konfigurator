package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class PizzaGUI {
    public static void main(String[] args) throws PizzaException {
        PizzaService pizzaService = new PizzaService();

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        GridLayout grid = new GridLayout(8, 2);
        JPanel pizzaGUI = new JPanel(grid);
        pizzaGUI.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel sizeLabel = new JLabel("size:");
        JPanel sizePanel = new JPanel(new GridLayout(0, 4));

        JLabel doughLabel = new JLabel("dough:");
        JPanel doughPanel = new JPanel(new GridLayout(0, 5));

        JLabel sauceLabel = new JLabel("sauce:");
        JPanel saucePanel = new JPanel(new GridLayout(0, 4));

        JLabel cheeseLabel = new JLabel("cheese:");
        JPanel cheesePanel = new JPanel(new GridLayout(0, 5));

        JLabel meatLabel = new JLabel("meat:");
        JPanel meatPanel = new JPanel(new GridLayout(0, 4));

        JLabel vegetablesLabel = new JLabel("vegetables:");
        JPanel vegetablesPanel = new JPanel(new GridLayout(0, 7));

        JLabel extrasLabel = new JLabel("extras:");
        JPanel extrasPanel = new JPanel(new GridLayout(0, 6));

        JLabel specialitiesLabel = new JLabel("specialties:");
        JPanel specialtiesPanel = new JPanel(new GridLayout(0, 1));

        //Sizes Radio Panel
        JRadioButton smallRadio = new JRadioButton("small" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "small") + "€");
        smallRadio.setActionCommand("small");
        JRadioButton mediumRadio = new JRadioButton("medium" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "medium") + "€");
        mediumRadio.setActionCommand("medium");
        JRadioButton largeRadio = new JRadioButton("large" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "large") + "€");
        largeRadio.setActionCommand("large");
        JRadioButton familyRadio = new JRadioButton("family" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SIZE, "family") + "€");
        familyRadio.setActionCommand("family");
        sizePanel.add(smallRadio);
        sizePanel.add(mediumRadio);
        sizePanel.add(largeRadio);
        sizePanel.add(familyRadio);
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallRadio);
        sizeGroup.add(mediumRadio);
        sizeGroup.add(largeRadio);
        sizeGroup.add(familyRadio);

        //Dough Radio Panel
        JRadioButton classicRadio = new JRadioButton("classic" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.DOUGH, "classic") + "€");
        classicRadio.setActionCommand("classic");
        JRadioButton thinRadio = new JRadioButton("thin" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.DOUGH, "thin") + "€");
        thinRadio.setActionCommand("thin");
        JRadioButton wholeGrainRadio = new JRadioButton("whole grain" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.DOUGH, "whole grain") + "€");
        wholeGrainRadio.setActionCommand("whole grain");
        JRadioButton glutenFreeRadio = new JRadioButton("gluten free" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.DOUGH, "gluten free") + "€");
        glutenFreeRadio.setActionCommand("gluten free");
        JRadioButton cheeseEdgeRadio = new JRadioButton("cheese edge" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.DOUGH, "cheese edge") + "€");
        cheeseEdgeRadio.setActionCommand("cheese edge");
        doughPanel.add(classicRadio);
        doughPanel.add(thinRadio);
        doughPanel.add(wholeGrainRadio);
        doughPanel.add(glutenFreeRadio);
        doughPanel.add(cheeseEdgeRadio);
        ButtonGroup doughGroup = new ButtonGroup();
        doughGroup.add(classicRadio);
        doughGroup.add(thinRadio);
        doughGroup.add(wholeGrainRadio);
        doughGroup.add(glutenFreeRadio);
        doughGroup.add(cheeseEdgeRadio);

        //Sauces Radio Panel
        JRadioButton tomatoRadio = new JRadioButton("tomato" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SAUCE, "tomato") + "€");
        tomatoRadio.setActionCommand("tomato");
        JRadioButton cremeFraicheRadio = new JRadioButton("creme fraiche" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SAUCE, "creme fraiche") + "€");
        cremeFraicheRadio.setActionCommand("creme fraiche");
        JRadioButton bbqRadio = new JRadioButton("bbq" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SAUCE, "bbq") + "€");
        bbqRadio.setActionCommand("bbq");
        JRadioButton pestoRadio = new JRadioButton("pesto" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SAUCE, "pesto") + "€");
        pestoRadio.setActionCommand("pesto");
        saucePanel.add(tomatoRadio);
        saucePanel.add(cremeFraicheRadio);
        saucePanel.add(bbqRadio);
        saucePanel.add(pestoRadio);
        ButtonGroup sauceGroup = new ButtonGroup();
        sauceGroup.add(tomatoRadio);
        sauceGroup.add(cremeFraicheRadio);
        sauceGroup.add(bbqRadio);
        sauceGroup.add(pestoRadio);

        //Cheese Radio Panel
        JRadioButton mozzarellaRadio = new JRadioButton("mozzarella" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.CHEESE, "mozzarella") + "€");
        mozzarellaRadio.setActionCommand("mozzarella");
        JRadioButton goudaRadio = new JRadioButton("gouda" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.CHEESE, "gouda") + "€");
        goudaRadio.setActionCommand("gouda");
        JRadioButton cheddarRadio = new JRadioButton("cheddar" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.CHEESE, "cheddar") + "€");
        cheddarRadio.setActionCommand("cheddar");
        JRadioButton parmesanRadio = new JRadioButton("parmesan" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.CHEESE, "parmesan") + "€");
        parmesanRadio.setActionCommand("parmesan");
        JRadioButton veganRadio = new JRadioButton("vegan" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.CHEESE, "vegan") + "€");
        veganRadio.setActionCommand("vegan");
        cheesePanel.add(mozzarellaRadio);
        cheesePanel.add(goudaRadio);
        cheesePanel.add(cheddarRadio);
        cheesePanel.add(parmesanRadio);
        cheesePanel.add(veganRadio);
        ButtonGroup cheeseGroup = new ButtonGroup();
        cheeseGroup.add(mozzarellaRadio);
        cheeseGroup.add(goudaRadio);
        cheeseGroup.add(cheddarRadio);
        cheeseGroup.add(parmesanRadio);
        cheeseGroup.add(veganRadio);

        //Meat Radio Panel
        JRadioButton salamiRadio = new JRadioButton("salami" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.MEAT, "salami") + "€");
        salamiRadio.setActionCommand("salami");
        JRadioButton hamRadio = new JRadioButton("ham" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.MEAT, "ham") + "€");
        hamRadio.setActionCommand("ham");
        JRadioButton chickenRadio = new JRadioButton("chicken" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.MEAT, "chicken") + "€");
        chickenRadio.setActionCommand("chicken");
        JRadioButton kebabRadio = new JRadioButton("kebab" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.MEAT, "kebab") + "€");
        kebabRadio.setActionCommand("kebab");
        meatPanel.add(salamiRadio);
        meatPanel.add(hamRadio);
        meatPanel.add(chickenRadio);
        meatPanel.add(kebabRadio);
        ButtonGroup meatGroup = new ButtonGroup();
        meatGroup.add(salamiRadio);
        meatGroup.add(hamRadio);
        meatGroup.add(chickenRadio);
        meatGroup.add(kebabRadio);

        //Vegetables Radio Panel
        JRadioButton tomatoVegRadio = new JRadioButton("tomato" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "tomato") + "€");
        tomatoVegRadio.setActionCommand("tomato");
        JRadioButton onionVegRadio = new JRadioButton("onion" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "onion") + "€");
        onionVegRadio.setActionCommand("onion");
        JRadioButton paprikaVegRadio = new JRadioButton("paprika" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "paprika") + "€");
        paprikaVegRadio.setActionCommand("paprika");
        JRadioButton broccoliVegRadio = new JRadioButton("broccoli" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "broccoli") + "€");
        broccoliVegRadio.setActionCommand("broccoli");
        JRadioButton champignonsVegRadio = new JRadioButton("champignons" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "champignons") + "€");
        champignonsVegRadio.setActionCommand("champignons");
        JRadioButton pepperoniVegRadio = new JRadioButton("pepperoni" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "pepperoni") + "€");
        pepperoniVegRadio.setActionCommand("pepperoni");
        JRadioButton oliveVegRadio = new JRadioButton("olive" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.VEGETABLES, "olive") + "€");
        oliveVegRadio.setActionCommand("olive");
        vegetablesPanel.add(tomatoVegRadio);
        vegetablesPanel.add(onionVegRadio);
        vegetablesPanel.add(paprikaVegRadio);
        vegetablesPanel.add(broccoliVegRadio);
        vegetablesPanel.add(champignonsVegRadio);
        vegetablesPanel.add(pepperoniVegRadio);
        vegetablesPanel.add(oliveVegRadio);
        ButtonGroup vegetablesGroup = new ButtonGroup();
        vegetablesGroup.add(tomatoVegRadio);
        vegetablesGroup.add(onionVegRadio);
        vegetablesGroup.add(paprikaVegRadio);
        vegetablesGroup.add(broccoliVegRadio);
        vegetablesGroup.add(champignonsVegRadio);
        vegetablesGroup.add(pepperoniVegRadio);
        vegetablesGroup.add(oliveVegRadio);

        //Extras Radio Panel
        JRadioButton garlicBreadRadio = new JRadioButton("garlic bread" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "garlic bread") + "€");
        garlicBreadRadio.setActionCommand("garlic bread");
        JRadioButton salatRadio = new JRadioButton("salat" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "salat") + "€");
        salatRadio.setActionCommand("salat");
        JRadioButton bbqDipRadio = new JRadioButton("bbq dip" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "bbq dip") + "€");
        bbqDipRadio.setActionCommand("bbq dip");
        JRadioButton cremeFraicheDipRadio = new JRadioButton("creme fraiche dip" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "creme fraiche dip") + "€");
        cremeFraicheDipRadio.setActionCommand("creme fraiche dip");
        JRadioButton tomatoDipRadio = new JRadioButton("tomato dip" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "tomato dip") + "€");
        tomatoDipRadio.setActionCommand("tomato dip");
        JRadioButton pestoDipRadio = new JRadioButton("pesto" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.EXTRAS, "pesto") + "€");
        pestoDipRadio.setActionCommand("pesto");
        extrasPanel.add(garlicBreadRadio);
        extrasPanel.add(salatRadio);
        extrasPanel.add(bbqDipRadio);
        extrasPanel.add(cremeFraicheDipRadio);
        extrasPanel.add(tomatoDipRadio);
        extrasPanel.add(pestoDipRadio);

        //Specialities Radio Panel
        JRadioButton seafoodRadio = new JRadioButton("seafood" + " " + pizzaService.getPrice(PizzaServiceDataTableEnum.SPECIALITIES, "seafood") + "€");
        seafoodRadio.setActionCommand("seafood");
        specialtiesPanel.add(seafoodRadio);

        //Create Pizza Button
        JButton createPizzaButton = new JButton("Total");
        specialtiesPanel.add(createPizzaButton);
        JLabel priceLabel = new JLabel();
        createPizzaButton.addActionListener(e -> {
            String sizeVal = sizeGroup.getSelection().getActionCommand();
            String doughVal = doughGroup.getSelection().getActionCommand();
            String sauceVal = sauceGroup.getSelection().getActionCommand();
            String cheeseVal = cheeseGroup.getSelection().getActionCommand();
            String meatVal = meatGroup.getSelection().getActionCommand();
            String vegetablesVal = vegetablesGroup.getSelection().getActionCommand();
            HashSet<String> extrasVal = new HashSet<>();
            // Get all JRadioButtons from the panel
            for (Component component : extrasPanel.getComponents()) {
                if (component instanceof JRadioButton) {
                    JRadioButton radioButton = (JRadioButton) component;
                    if (radioButton.isSelected()) {
                        extrasVal.add(((JRadioButton) component).getActionCommand());
                    }
                }
            }
            HashSet<String> specialtiesVal = new HashSet<>();
            for (Component component : specialtiesPanel.getComponents()) {
                if (component instanceof JRadioButton) {
                    JRadioButton radioButton = (JRadioButton) component;
                    if (radioButton.isSelected()) {
                        specialtiesVal.add(((JRadioButton) component).getActionCommand());
                    }
                }
            }
            if (doughGroup.getSelection().getActionCommand().equals("glutenfree")) {
                try {
                    pizzaService.configurePizza(sizeVal, doughVal, sauceVal, cheeseVal, meatVal, vegetablesVal, HashSet.newHashSet(0), specialtiesVal, extrasVal, 200, true);
                    priceLabel.setText(String.valueOf(pizzaService.total()));
                } catch (PizzaException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    pizzaService.configurePizza(sizeVal, doughVal, sauceVal, cheeseVal, meatVal, vegetablesVal, HashSet.newHashSet(0), specialtiesVal, extrasVal, 200, false);
                    priceLabel.setText(String.valueOf(pizzaService.total()));
                } catch (PizzaException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        specialtiesPanel.add(priceLabel);

        pizzaGUI.add(sizeLabel);
        pizzaGUI.add(sizePanel);

        pizzaGUI.add(doughLabel);
        pizzaGUI.add(doughPanel);

        pizzaGUI.add(sauceLabel);
        pizzaGUI.add(saucePanel);

        pizzaGUI.add(cheeseLabel);
        pizzaGUI.add(cheesePanel);

        pizzaGUI.add(meatLabel);
        pizzaGUI.add(meatPanel);

        pizzaGUI.add(vegetablesLabel);
        pizzaGUI.add(vegetablesPanel);

        pizzaGUI.add(extrasLabel);
        pizzaGUI.add(extrasPanel);

        pizzaGUI.add(specialitiesLabel);
        pizzaGUI.add(specialtiesPanel);

        frame.getContentPane().add(pizzaGUI);
        frame.setVisible(true);
        pizzaGUI.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
