import org.example.PizzaException;
import org.example.PizzaService;
import org.junit.jupiter.api.Test;

import static org.example.PizzaServiceDataTableEnum.SAUCE;
import static org.junit.Assert.assertEquals;

public class PizzaServiceTest {

    @Test
    public void testGetPrice() throws PizzaException {
        PizzaService pizzaService = new PizzaService();
        double price = pizzaService.getPrice(SAUCE, "tomato");
        assertEquals(price, 0.5);

    }
}
