package Week8.FridayLab.coffee.test;

import Week8.FridayLab.coffee.problem.CoffeeMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeTest {
    private static CoffeeMachine machine;

    @BeforeEach
    public void setUp(){
        machine = new CoffeeMachine("Test Machine", 3.50);
    }

    @Test
    public void testPoweredOn(){
        machine.powerOn();
        Assertions.assertTrue(machine.isPoweredOn());
    }

    @Test
    public void testEmptyWater(){
        boolean result = machine.brewCoffee();
        Assertions.assertFalse(result);
    }

    @Test
    public void revenueTest(){
        machine.addWater(500);

        // Make three cups
        for(int i = 1; i <= 3; i++){
            machine.brewCoffee();
        }

        double expectedRevenue = 3 * 3.50;
        Assertions.assertEquals(expectedRevenue, machine.getTotalRevenue());
    }
}
