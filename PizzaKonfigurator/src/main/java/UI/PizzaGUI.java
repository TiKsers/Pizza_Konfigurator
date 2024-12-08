package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUI {
    public static void main(String[] args) {
        new PizzaGUI();
    }

    JFrame pizzaFrame;
    JPanel sizePanel, doughPanel, saucePanel, cheesePanel, toppingsPanel, summaryPanel;
    JLabel sizeLabel, doughLabel, sauceLabel, cheeseLabel, toppingsLabel, summaryLabel;
    ButtonGroup sizeGroup, doughGroup, sauceGroup, cheeseGroup;
    JRadioButton sizeSmall, sizeMedium, sizeLarge, sizeFamily;
    JRadioButton doughClassic, doughThin, doughWholegrain, doughGlutenFree, doughCheeseEdge;
    JRadioButton sauceTomate, sauceBBQ, sauceCremeCraiche, saucePesto;
    JRadioButton cheeseMozzarella, cheeseGouda, cheeseCheddar, cheeseParmesan, cheeseVegan, cheeseExtra;

    public PizzaGUI() {
        // Basic Frame Konfiguration
        pizzaFrame = new JFrame("Pizza Konfigurator");
        pizzaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pizzaFrame.setLayout(new GridLayout(4, 1));
        pizzaFrame.setSize(800, 700);
        pizzaFrame.setResizable(false);

        // Pizza Size Config
        {
            sizePanel = new JPanel(new GridLayout(2, 1));
            // Füge Label in erste Reihe ein
            sizeLabel = new JLabel("Choose Piza Size:");
            sizePanel.add(sizeLabel);

            // JPanel sizeOptions erzeugen
            JPanel sizeOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            sizeSmall = new JRadioButton("Klein (20cm) - 5,00 €");
            sizeMedium = new JRadioButton("Mittel (30cm) - 7,50 €");
            sizeLarge = new JRadioButton("Groß (40cm) - 10,00 €");
            sizeFamily = new JRadioButton("Familienpizza (50cm) - 13,00 €");

            sizeGroup = new ButtonGroup();
            sizeGroup.add(sizeSmall);
            sizeGroup.add(sizeMedium);
            sizeGroup.add(sizeLarge);
            sizeGroup.add(sizeFamily);

            sizeOptionsPanel.add(sizeSmall);
            sizeOptionsPanel.add(sizeMedium);
            sizeOptionsPanel.add(sizeLarge);
            sizeOptionsPanel.add(sizeFamily);
            // Fügt das Panel in 2te reihe von sizePanel ein
            sizePanel.add(sizeOptionsPanel);
        }

        // Pizza Dough Config
        {
            doughPanel = new JPanel(new GridLayout(2, 1));
            doughLabel = new JLabel("Select Pizza Dough:");
            doughPanel.add(doughLabel);

            JPanel doughOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            doughClassic = new JRadioButton("Klassischer Teig - 0 €");
            doughThin = new JRadioButton("Dünner Teig - 0,50 €");
            doughWholegrain = new JRadioButton("Vollkornteig - 1,00 €");
            doughGlutenFree = new JRadioButton("Glutenfreier Teig - 1,50 €");
            doughCheeseEdge = new JRadioButton("Käserand - 2,00 €");

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

            doughPanel.add(doughOptionsPanel);
        }

        // Pizza Sauce
        {
            saucePanel = new JPanel(new GridLayout(2, 1));
            sauceLabel = new JLabel("Select Pizza Sauce:");
            saucePanel.add(sauceLabel);

            JPanel sauceOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            sauceTomate = new JRadioButton("Tomate Sauce - 0 €");
            sauceBBQ = new JRadioButton("BBQ-Sauce - 0,50 €");
            sauceCremeCraiche = new JRadioButton("Creme Fraiche - 0,50 €");
            saucePesto = new JRadioButton("Pesto - 1,00 €");

            sauceGroup = new ButtonGroup();
            sauceGroup.add(sauceTomate);
            sauceGroup.add(sauceBBQ);
            sauceGroup.add(sauceCremeCraiche);
            sauceGroup.add(saucePesto);

            sauceOptionsPanel.add(sauceTomate);
            sauceOptionsPanel.add(sauceBBQ);
            sauceOptionsPanel.add(sauceCremeCraiche);
            sauceOptionsPanel.add(saucePesto);

            saucePanel.add(sauceOptionsPanel);
            //pizzaFrame.add(saucePanel);
        }

        // Pizza Chesse
        {
            cheesePanel = new JPanel(new GridLayout(2, 1));
            cheeseLabel = new JLabel("Select Cheese:");
            cheesePanel.add(cheeseLabel);

            JPanel cheeseOptionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            cheeseMozzarella = new JRadioButton("Mozzarella - 0€");
            cheeseGouda = new JRadioButton("Gouda - 0,50€");
            cheeseCheddar = new JRadioButton("Cheddar - 0,50€");
            cheeseParmesan = new JRadioButton("Parmesan - 1€");
            cheeseVegan = new JRadioButton("Vegan - 1,50€");
            //cheeseExtra = new JRadioButton("Extra"); // BEachten ....

            cheeseGroup = new ButtonGroup();
            cheeseGroup.add(cheeseMozzarella);
            cheeseGroup.add(cheeseGouda);
            cheeseGroup.add(cheeseCheddar);
            cheeseGroup.add(cheeseParmesan);
            cheeseGroup.add(cheeseVegan);
            //cheeseGroup.add(cheeseExtra);

            cheeseOptionsPanel.add(cheeseMozzarella);
            cheeseOptionsPanel.add(cheeseGouda);
            cheeseOptionsPanel.add(cheeseCheddar);
            cheeseOptionsPanel.add(cheeseParmesan);
            cheeseOptionsPanel.add(cheeseVegan);

            cheesePanel.add(cheeseOptionsPanel);
        }

        pizzaFrame.add(sizePanel);
        pizzaFrame.add(doughPanel);
        pizzaFrame.add(saucePanel);
        pizzaFrame.add(cheesePanel);

        pizzaFrame.setVisible(true);
    }
}