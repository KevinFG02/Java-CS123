package Week8.FridayLab.coffee.demo;

import Week8.FridayLab.coffee.problem.CoffeeMachine;

/**
 * Demo for Coffee Machine Demo.
 *
 * @author Kevin Flores
 * @version 1.0
 */
public class CoffeeMachineDemo {

    private static final double PRICE = 3.50;
    private static final int WATER = 500;
    private static final int BEANS = 50;

    /**
     * Entry point for application
     * @param args command line args
     */
    public static void main(String[] args) {

        System.out.println("=== Coffee Machine Demo ===\n");

        CoffeeMachine machine = new CoffeeMachine("BrewBot 3000", PRICE);

        // Try brewing before powering on
        System.out.println("-- Attempting brew before power on --");
        machine.brewCoffee();

        // Power on and fill up
        System.out.println("\n-- Starting up --");
        machine.powerOn();
        machine.addWater(WATER);
        machine.addBeans(BEANS);

        // Brew a couple of cups
        System.out.println("\n-- Brewing --");
        if(machine.brewCoffee()){
            System.out.println("Coffee was brewed.");
        }
        machine.brewCoffee();
        machine.brewCoffee();

        // Check revenue and status
        System.out.println("\n-- Status report --");
        System.out.println(machine.getStatus());
        System.out.printf("Total revenue: $%.2f%n", machine.getTotalRevenue());

        // Drain the water and try to brew
        System.out.println("\n-- Running low --");
        machine.addWater(100);
        machine.brewCoffee();
        machine.brewCoffee(); // should fail — not enough water

        // Reset and check state
        System.out.println("\n-- Resetting --");
        machine.reset();
        System.out.println(machine.getStatus());

        System.out.println("\n=== End of Demo ===");
    }
}