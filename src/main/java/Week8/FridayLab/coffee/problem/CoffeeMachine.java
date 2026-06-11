package Week8.FridayLab.coffee.problem;

/**
 * Represents a coffee machine.
 *
 * @author Kevin Flores
 * @version 1.0
 */
public class CoffeeMachine {
    private static final int MIN_WATER = 150;
    private int waterLevel;
    private int beansGrams;
    private boolean isPoweredOn;
    private String machineName;
    private int cupsMade;
    private double pricePerCup;

    /**
     * Creates a coffee machine
     *
     * @param name name of machine
     * @param price price per cup
     */
    public CoffeeMachine(String name, double price) {
        machineName = name;
        pricePerCup = price;
        waterLevel = 0;
        beansGrams = 0;
        isPoweredOn = false;
        cupsMade = 0;
    }

    /**
     * Turns the machine on.
     */
    public void powerOn() {
        isPoweredOn = true;
        System.out.println(machineName + " is now ON.");
    }

    /**
     * adds water to the machine.
     * 
     * @param millileters the amount of water.
     */
    public void addWater(int millileters) {
        waterLevel = waterLevel + millileters;
        System.out.println("Added " + millileters + "millileters. Water level: " + waterLevel + "millileters");
    }

    /**
     * Adds beans to the machine.
     * @param grams the amount of beans.
     */
    public void addBeans(int grams) {
        beansGrams = beansGrams + grams;
        System.out.println("Added " + grams + "g beans. Total: " + beansGrams + "g");
    }

    /**
     * Brews coffee
     * @return returns true if the coffee was brewed successfully, otherwise returns false.
     */
    public boolean brewCoffee() {
        if (waterLevel < MIN_WATER) {
            System.out.println("Not enough water!");
            return false;
        }
        waterLevel = waterLevel - MIN_WATER;
        cupsMade = cupsMade + 1;
        System.out.println("Brewing cup #" + cupsMade + ". Enjoy!");
        return true;
    }

    /**
     * Returns the total revenue.
     *
     * @return returns revenue.
     */
    public double getTotalRevenue() {
        return cupsMade * pricePerCup;
    }

    /**
     * Returns the state of the machine.
     *
     * @return Returns the state of the machine as a string.
     */
    public String getStatus() {
        return "Machine: " + machineName +
                " | On: " + isPoweredOn +
                " | Water: " + waterLevel + "ml" +
                " | Cups made: " + cupsMade;
    }

    /**
     * Reset the machine.
     */
    public void reset() {
        isPoweredOn = false;
        waterLevel = 0;
        System.out.println(machineName + " has been reset.");
    }

    public String toString() {
        return "CoffeeMachine{" +
                "WaterLevel=" + waterLevel +
                ", beansGrams=" + beansGrams +
                ", isPoweredOn=" + isPoweredOn +
                ", MachineName='" + machineName + '\'' +
                ", cupsMADE=" + cupsMade +
                ", pricePerCup=" + pricePerCup +
                '}';
    }

    /**
     * Getter for the water level.
     *
     * @return the water level
     */
    public int getWaterLevel() {
        return waterLevel;
    }

    /**
     * Getter for price.
     *
     * @return the price.
     */
    public double getPricePerCup() {
        return pricePerCup;
    }

    /**
     * Getter for cups made.
     *
     * @return cups made.
     */
    public int getCupsMade() {
        return cupsMade;
    }

    /**
     * Getter for the machine name.
     *
     * @return name of machine.
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     * Getter for status of coffee machine.
     *
     * @return power status.
     */
    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    /**
     * Getter for beans in grams.
     *
     * @return beans in grams.
     */
    public int getBeansGrams() {
        return beansGrams;
    }
}