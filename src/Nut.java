/*
 * SE1021
 * Winter 2017
 * Lab Lab3
 * Name: Andrew Wojciechowski
 * Created 12/9/17
 */

import java.text.DecimalFormat;

/**
 * Represents information about a nut part
 * @author wojciechowskia
 * @version 1
 */
public class Nut implements Part {
    private double diameterInches;
    private static final double LBS_MULTIPLIER = 0.01;
    private static final double USD_MULTIPLIER = 0.5;

    /**
     * Constructor for a nut
     * @param diameterInches the diameter of the nut
     */
    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
    }

    @Override
    public double getCost() {
        return USD_MULTIPLIER * this.diameterInches;
    }

    /**
     * Gets the name for this nut with a proper numeric format for the diameter
     * @return the name of the nut
     */
    @Override
    public String getName() {
        DecimalFormat diameterFormat = new DecimalFormat("0.0###");
        return String.format("%s inch nut", diameterFormat.format(this.diameterInches));
    }

    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * Math.pow(this.diameterInches, 2);
    }

    /**
     * Prints the bill of materials for this nut via the console
     */
    @Override
    public void printBillOfMaterials() {
        DecimalFormat inchesFormat = new DecimalFormat("0.0###");
        DecimalFormat weightFormat = new DecimalFormat("0.###");
        DecimalFormat costFormat = new DecimalFormat("0.00");
        System.out.println("==========================");
        System.out.println(this.getName());
        System.out.println("==========================");
        System.out.println(String.format("Diameter: %s inches", inchesFormat.format(this.diameterInches)));
        System.out.println(String.format("Cost: $%s", costFormat.format(this.getCost())));
        System.out.println(String.format("Weight: %s lbs", weightFormat.format(this.getWeight())));
    }
}
