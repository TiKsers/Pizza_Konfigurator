package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUI {
    public static void main(String[] args) {
        new PizzaGUI();
    }

    double totalPrice, sizePrice, doughPrice, saucePrice, cheesePrice;

    JFrame pizzaFrame;
    JPanel sizePanel, doughPanel, saucePanel, cheesePanel, extraCheesePanel, toppingsPanel, summaryPanel;
    JPanel sizeOptionsPanel, doughOptionsPanel, sauceOptionsPanel, cheeseOptionsPanel, extraOptionsPanel, toppingsOptionsPanel;
    JLabel sizeLabel, doughLabel, sauceLabel, cheeseLabel, extraLabel, toppingsLabel, summaryLabel;

    ButtonGroup sizeGroup, doughGroup, sauceGroup, cheeseGroup, extraGroup;
    JRadioButton sizeSmall, sizeMedium, sizeLarge, sizeFamily;
    JRadioButton doughClassic, doughThin, doughWholegrain, doughGlutenFree, doughCheeseEdge;
    JRadioButton sauceTomato, sauceBBQ, sauceCremeCraiche, saucePesto;
    JRadioButton cheeseMozzarella, cheeseGouda, cheeseCheddar, cheeseParmesan, cheeseVegan, cheeseExtra;
    JRadioButton extraMozzarella, extraGouda, extraCheddar, extraParmesan, extraVegan;
    JComboBox toppingsMeat, toppingsVeg, toppingsExtras, toppingsSepcial;
    ActionListener sizeListener, doughListener, sauceListener, cheeseListener, extraCheeseListener, toppingsListener;

    public PizzaGUI() {
        // Basic Frame Konfiguration
        pizzaFrame = new JFrame("Pizza Konfigurator");
        pizzaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pizzaFrame.setLayout(new GridLayout(6, 1));
        pizzaFrame.setSize(800, 700);
        //pizzaFrame.setResizable(false);

        pizzaFrame.add(this.createSizePanel());
        pizzaFrame.add(this.createDoughPanel());
        pizzaFrame.add(this.createSaucePanel());
        pizzaFrame.add(this.createCheesePanel());
        pizzaFrame.add(this.createToppingsPanel());
        pizzaFrame.add(this.createOrderPanel());

        pizzaFrame.setVisible(true);
    }

    private JPanel createSizePanel() {
        // Set Basic Layout and add Label in first Row
        sizePanel = new JPanel(new GridLayout(2, 1));
        sizeLabel = new JLabel("Choose Pizza Size:");
        sizePanel.add(sizeLabel);

        // Create JPanel sizeOptions
        sizeOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sizeSmall = new JRadioButton("Klein (20cm) - 5,00 €");
        sizeMedium = new JRadioButton("Mittel (30cm) - 7,50 €");
        sizeLarge = new JRadioButton("Groß (40cm) - 10,00 €");
        sizeFamily = new JRadioButton("Familienpizza (50cm) - 13,00 €");

        // Set standart option
        sizeMedium.setSelected(true);
        doughPrice = 7.5;

        // Hinzufuegen Action Listener
        // Überarbeiten
        sizeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                switch (source.getText()) {
                    case "Klein (20cm) - 5,00 €":
                        sizePrice = 5;
                        doughCheeseEdge.setEnabled(false);
                        if (doughCheeseEdge.isSelected()) ;
                        doughClassic.setSelected(true);
                        //doughClassic.setSelected(true);
                        // Fam Pizza Enable
                        doughThin.setEnabled(true);
                        doughWholegrain.setEnabled(true);
                        break;
                    case "Mittel (30cm) - 7,50 €":
                        sizePrice = 7.5;
                        doughCheeseEdge.setEnabled(true);
                        doughThin.setEnabled(true);
                        doughWholegrain.setEnabled(true);
                        break;
                    case "Groß (40cm) - 10,00 €":
                        sizePrice = 10;
                        doughCheeseEdge.setEnabled(true);
                        doughThin.setEnabled(true);
                        doughWholegrain.setEnabled(true);
                        break;
                    case "Familienpizza (50cm)":
                        sizePrice = 13;
                        doughCheeseEdge.setEnabled(false);
                        doughCheeseEdge.setSelected(false);
                        doughThin.setEnabled(false);
                        doughThin.setSelected(false);
                        doughWholegrain.setEnabled(false);
                        doughWholegrain.setSelected(false);
                        break;
                    default:
                        sizePrice = 7.5;
                        break;
                }
                System.out.println("Selected size: " + source.getText() + sizePrice);
            }
        };

        // Create Button Group
        sizeGroup = new ButtonGroup();
        sizeGroup.add(sizeSmall);
        sizeGroup.add(sizeMedium);
        sizeGroup.add(sizeLarge);
        sizeGroup.add(sizeFamily);

        // Add Elements to Panel
        sizeOptionsPanel.add(sizeSmall);
        sizeOptionsPanel.add(sizeMedium);
        sizeOptionsPanel.add(sizeLarge);
        sizeOptionsPanel.add(sizeFamily);

        // Add ActionListener to Elements
        sizeSmall.addActionListener(sizeListener);
        sizeMedium.addActionListener(sizeListener);
        sizeLarge.addActionListener(sizeListener);
        sizeFamily.addActionListener(sizeListener);

        // Add Option Panel to main Panel
        sizePanel.add(sizeOptionsPanel);

        return sizePanel;
    }

    private JPanel createDoughPanel() {
        doughPanel = new JPanel(new GridLayout(2, 1));
        doughLabel = new JLabel("Select Pizza Dough:");
        doughPanel.add(doughLabel);

        doughOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        doughClassic = new JRadioButton("Klassischer Teig - 0 €");
        doughThin = new JRadioButton("Dünner Teig - 0,50 €");
        doughWholegrain = new JRadioButton("Vollkornteig - 1,00 €");
        doughGlutenFree = new JRadioButton("Glutenfreier Teig - 1,50 €");
        doughCheeseEdge = new JRadioButton("Käserand - 2,00 €");

        // Set standart option
        doughClassic.setSelected(true);

        // Überarbeiten
        doughListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                switch (source.getText()) {
                    case "Klassischer Teig - 0 €":
                        doughPrice = 0;
                        break;
                    case "Dünner Teig - 0,50 €":
                        doughPrice = 0.5;
                        break;
                    case "Vollkornteig - 1,00 €":
                        doughPrice = 1;
                        break;
                    case "Glutenfreier Teig - 1,50 €":
                        doughPrice = 1.5;
                        break;
                    case "Käserand - 2,00 €":
                        doughPrice = 2;
                        break;
                    default:
                        doughPrice = 0;
                        break;
                }
                if (source == doughGlutenFree) {
                    sauceCremeCraiche.setEnabled(false);
                    saucePesto.setEnabled(false);
                    if (sauceCremeCraiche.isSelected() || saucePesto.isSelected())
                        sauceTomato.setSelected(true); // Auf Basic operator zurücksetzten
                } else if (source == doughThin) {
                    sauceCremeCraiche.setEnabled(true);
                    saucePesto.setEnabled(true);
                    // Backgrad knusprig disablen
                } else {
                    sauceCremeCraiche.setEnabled(true);
                    saucePesto.setEnabled(true);
                }
            }
        };

        doughGroup = new ButtonGroup();
        doughGroup.add(doughClassic);
        doughGroup.add(doughThin);
        doughGroup.add(doughWholegrain);
        doughGroup.add(doughGlutenFree);
        doughGroup.add(doughCheeseEdge);

        doughOptionsPanel.add(doughClassic);
        doughOptionsPanel.add(doughThin);
        doughOptionsPanel.add(doughWholegrain);
        doughOptionsPanel.add(doughGlutenFree);
        doughOptionsPanel.add(doughCheeseEdge);

        doughClassic.addActionListener(doughListener);
        doughThin.addActionListener(doughListener);
        doughWholegrain.addActionListener(doughListener);
        doughGlutenFree.addActionListener(doughListener);
        doughCheeseEdge.addActionListener(doughListener);

        doughPanel.add(doughOptionsPanel);

        return doughPanel;
    }

    private JPanel createSaucePanel() {
        saucePanel = new JPanel(new GridLayout(2, 1));
        sauceLabel = new JLabel("Select Pizza Sauce:");
        saucePanel.add(sauceLabel);

        sauceOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sauceTomato = new JRadioButton("Tomate Sauce - 0 €");
        sauceBBQ = new JRadioButton("BBQ-Sauce - 0,50 €");
        sauceCremeCraiche = new JRadioButton("Creme Fraiche - 0,50 €");
        saucePesto = new JRadioButton("Pesto - 1,00 €");

        sauceTomato.setSelected(true);

        sauceListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                switch (source.getText()) {
                    case "Tomate Sauce - 0":
                        saucePrice = 0;
                        break;
                    case "BBQ-Sauce - 0,50 €":
                        saucePrice = 0.5;
                        break;
                    case "Creme Fraiche - 0,50 €":
                        saucePrice = 0.5;
                        break;
                    case "Pesto - 1,00 €":
                        saucePrice = 1;
                        break;
                    default:
                        saucePrice = 0;
                        break;

                }
                if (source == sauceTomato)
                    System.out.println("");
                else if (source == sauceBBQ)
                    System.out.println("");
                else if (source == sauceCremeCraiche)
                    System.out.println("");
                else if (source == saucePesto)
                    System.out.println("");
            }
        };

        sauceGroup = new ButtonGroup();
        sauceGroup.add(sauceTomato);
        sauceGroup.add(sauceBBQ);
        sauceGroup.add(sauceCremeCraiche);
        sauceGroup.add(saucePesto);

        sauceOptionsPanel.add(sauceTomato);
        sauceOptionsPanel.add(sauceBBQ);
        sauceOptionsPanel.add(sauceCremeCraiche);
        sauceOptionsPanel.add(saucePesto);

        sauceTomato.addActionListener(sauceListener);
        sauceBBQ.addActionListener(sauceListener);
        sauceCremeCraiche.addActionListener(sauceListener);
        saucePesto.addActionListener(sauceListener);

        saucePanel.add(sauceOptionsPanel);

        return saucePanel;
    }

    private JPanel createCheesePanel() {
        extraCheesePanel = this.createExtraCheesePanel();
        extraCheesePanel.setVisible(false);

        cheesePanel = new JPanel(new GridLayout(3, 1));
        cheeseLabel = new JLabel("Select Cheese:");
        cheesePanel.add(cheeseLabel);

        cheeseOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cheeseMozzarella = new JRadioButton("Mozzarella - 0€");
        cheeseGouda = new JRadioButton("Gouda - 0,50€");
        cheeseCheddar = new JRadioButton("Cheddar - 0,50€");
        cheeseParmesan = new JRadioButton("Parmesan - 1€");
        cheeseVegan = new JRadioButton("Vegan - 1,50€");
        cheeseExtra = new JRadioButton("Extra Cheese");

        cheeseMozzarella.setSelected(true);

        cheeseListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                switch (source.getText()) {
                    case "Mozzarella - 0":
                        cheesePrice = 0;
                        break;
                    case "Gouda - 0,50€":
                        cheesePrice = 0.5;
                        break;
                    case "Cheddar - 0,50€":
                        cheesePrice = 0.5;
                        break;
                    case "Parmesan - 1€":
                        cheesePrice = 1;
                        break;
                    case "Vegan - 1,50€":
                        cheesePrice = 1.5;
                        break;
                }

                if (source == cheeseMozzarella)
                    System.out.println("");
                else if (source == cheeseGouda)
                    System.out.println("");
                else if (source == cheeseCheddar)
                    System.out.println("");
                else if (source == cheeseParmesan)
                    System.out.println("");
                else if (source == cheeseVegan)
                    System.out.println("");
                else if (source == cheeseExtra && cheeseExtra.isSelected())
                    extraCheesePanel.setVisible(true);
                else if (source == cheeseExtra && !cheeseExtra.isSelected())
                    extraCheesePanel.setVisible(false);
            }
        };

        extraCheeseListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
            }
        };

        cheeseGroup = new ButtonGroup();
        cheeseGroup.add(cheeseMozzarella);
        cheeseGroup.add(cheeseGouda);
        cheeseGroup.add(cheeseCheddar);
        cheeseGroup.add(cheeseParmesan);
        cheeseGroup.add(cheeseVegan);

        cheeseOptionsPanel.add(cheeseMozzarella);
        cheeseOptionsPanel.add(cheeseGouda);
        cheeseOptionsPanel.add(cheeseCheddar);
        cheeseOptionsPanel.add(cheeseParmesan);
        cheeseOptionsPanel.add(cheeseVegan);
        cheeseOptionsPanel.add(cheeseExtra);

        cheeseMozzarella.addActionListener(cheeseListener);
        cheeseGouda.addActionListener(cheeseListener);
        cheeseCheddar.addActionListener(cheeseListener);
        cheeseParmesan.addActionListener(cheeseListener);
        cheeseVegan.addActionListener(cheeseListener);
        cheeseExtra.addActionListener(cheeseListener);

        cheesePanel.add(cheeseOptionsPanel);
        cheesePanel.add(extraCheesePanel);

        return cheesePanel;
    }

    private JPanel createExtraCheesePanel() {
        extraCheesePanel = new JPanel(new GridLayout(2, 1));
        extraLabel = new JLabel("Select Extra Cheese (each 1€):");
        extraCheesePanel.add(extraLabel);

        extraOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        extraMozzarella = new JRadioButton("Mozzarella");
        extraGouda = new JRadioButton("Gouda");
        extraCheddar = new JRadioButton("Cheddar");
        extraParmesan = new JRadioButton("Parmesan");
        extraVegan = new JRadioButton("Vegan");

        extraGroup = new ButtonGroup();
        extraGroup.add(extraMozzarella);
        extraGroup.add(extraGouda);
        extraGroup.add(extraCheddar);
        extraGroup.add(extraParmesan);
        extraGroup.add(extraVegan);

        extraOptionsPanel.add(extraMozzarella);
        extraOptionsPanel.add(extraGouda);
        extraOptionsPanel.add(extraCheddar);
        extraOptionsPanel.add(extraParmesan);
        extraOptionsPanel.add(extraVegan);

        extraCheesePanel.add(extraOptionsPanel);

        return extraCheesePanel;
    }

    private JPanel createToppingsPanel() {
        // toppingsPanel = new JPanel(new GridLayout(5, 4)); /4 Colls
        toppingsPanel = new JPanel(new GridLayout(2, 1));
        toppingsLabel = new JLabel("Choose Toppings:");
        toppingsPanel.add(toppingsLabel);

        String[] toppingsMeatlist = {"Fleisch", "Salami", "Schinken", "Hänchen"};
        String[] toppingsVegtableslist = {"Gemüse", "Paprika", "Zwieblen", "Spinat"};
        String[] toppingsExtraslist = {"Extras", "Jalapenos", "Knoblauch"};
        String[] toppingsSepciallist = {"Spezialitäten", "Trüffelöl", "Garnelen"};

        //toppingsOptionsPanel = new JPanel(new GridLayout(1,4));
        toppingsOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toppingsMeat = new JComboBox(toppingsMeatlist);
        toppingsVeg = new JComboBox(toppingsVegtableslist);
        toppingsExtras = new JComboBox(toppingsExtraslist);
        toppingsSepcial = new JComboBox(toppingsSepciallist);

        toppingsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String source = (String) e.getSource();
                if (source == ("Salami")) {
                    System.out.println("Salami");
                } else if (source == ("Paprika")) {
                    System.out.println("Paprika");
                } else System.out.println("Test");
            }
        };

        toppingsOptionsPanel.add(toppingsMeat);
        toppingsOptionsPanel.add(toppingsVeg);
        toppingsOptionsPanel.add(toppingsExtras);
        toppingsOptionsPanel.add(toppingsSepcial);

        toppingsPanel.add(toppingsOptionsPanel);

        return toppingsPanel;
    }

    private JPanel createOrderPanel() {
        JPanel orderPanel = new JPanel(new FlowLayout());
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField("0", 10);
        priceField.setEditable(false);

        JButton calculateButton = new JButton("Calculate Price");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPrice = sizePrice + doughPrice + saucePrice + cheesePrice;
                priceField.setText(totalPrice + " €");
            }
        });

        orderPanel.add(priceLabel);
        orderPanel.add(priceField);
        orderPanel.add(calculateButton);
        return orderPanel;
    }

}