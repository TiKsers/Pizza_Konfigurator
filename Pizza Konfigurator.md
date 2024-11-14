# Aufgabe 1 - Analyse der Anforderungen
## Anforderungen
### Konfigurations Anforderungen
- **A1**: Der Benutzer soll die Pizzagröße wählen können: klein, mittel, groß, oder Familienpizza.
- **A2**: Der Benutzer soll die Teigart wählen können: klassisch, dünn, Vollkorn, glutenfrei, oder Käserand.
- **A3**: Der Benutzer soll eine Saucenbasis wählen können: Tomatensauce, BBQ-Sauce, Creme Fraiche, oder Pesto.
- **A4**: Der Benutzer soll eine Käsesorte wählen können: Mozzarella, Gouda, Cheddar, Parmesan oder veganer Käse. Option für extra Käse.
- **A5**: Der Benutzer soll Toppings hinzufügen können, die in die Kategorien Fleisch, Gemüse, Extras und Spezialitäten unterteilt sind.
- **A6**: Der Benutzer soll Extras wie Saucen oder Beilagen hinzufügen können, z. B. Knoblauchbrot, Salat, Dip-Saucen.
- **A7**: Der Benutzer kann den Backgrad der Pizza festlegen: z. B. knusprig oder weich.
- **A8**: Der Preis soll auf Basis der gewählten Optionen automatisch kalkuliert werden.

- **A9**: Familienpizza darf nur mit klassischen oder glutenfreien Teig gemacht werdden
- **A10**: Kleine Pizzen können keine Käserand haben
- **A11**: Bei Glutenfreiem Teig kann als Sauce nur BBQ oder Tomatensauce ausgewählt werden
- **A12**:  Wenn veganer Käse gewählt wird, sind keine weiteren Käsesorten und die Option 'extra Käse' nicht verfügbar.
	- Bedingung Ungenau (Klar wenn V. Käse als erstes gewähl wird. Unklar wenn er als Zusatz genommen werden soll)
- **A13**: Es ist max. ein Fleisch und ein Gemüse Topping erlaubt
- **A14**: Spezialitäten sind als einzel Topping zu behandeln (Keine anderen erlaubt) 
- **A15**: Beim Extra Jalapenos ist Frisches Gemüse (Paprika, Ziwebeln) nicht mehr möglich - Unklar: Was ist "Frisches" Gemüse
- **A16**: Die Auswahl zusätzlicher Soßen wird erst nach Konfiguration der Hauptpizza möglich
- **A17**: Gewisse Backarten sind für Gewisse Teigarten nicht möglich (Z.b. Knusprig und dünner Teig) - Bedingung nicht Eindeutig
- **A18**: Extras werden Seperat zur Pizza berechnet.

### Nicht Funktionale Anforderungen
- **F1**: Die Konfiguration sollte intuitiv sein und nicht länger wie 5 Minuten dauern
- **F2**: Die Anwendung soll individuell innerhalb von 2 Sekunden reagieren können
- **F3**: Die Anwendung soll individuell von mehreren Benutzern gleichzeitig benutzt werden sollen
- **F4**: Kundendaten sollen sicher und richtig gespeichert werden
- **F5**: Die Datenbank muss gegen SQL-Injection geschützt sein
- **F6**: Die Anwendung muss 99,9% Verfügbarkeit haben

## User Story
Als Kunde möchte ich die Möglichkeit haben, eine eigene Pizza schnell und einfach zusammenzustellen, und bestellen.

John Doe öffnet den Pizza-Konfigurator und wählt zunächst die Größe seiner Pizza. Er entscheidet sich für eine mittelgroße Pizza. Danach wählt er Vollkornteig und eine BBQ-Sauce als Saucenbasis. Für den Käse entscheidet er sich für Gouda und fügt extra Käse hinzu. John wählt Salami als Fleisch und Paprika als Gemüse. Zusätzlich möchte er Rucola als Extra hinzufügen. Er stellt den Backgrad auf „knusprig“ und fügt schließlich Knoblauchbrot als Beilage hinzu. Die App zeigt ihm den Gesamtpreis von 13,75€ für die Pizza + 2,50 € für das Knoblauchbrot an. John überprüft die Konfiguration und gibt die Bestellung auf.