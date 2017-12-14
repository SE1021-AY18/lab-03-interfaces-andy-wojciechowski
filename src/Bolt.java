/*
 * SE1021
 * Winter 2017
 * Lab Lab3
 * Name: Andrew Wojciechowski
 * Created 12/9/17
 */

import java.text.DecimalFormat;

/**
 * Represents information about a Bolt part
 * @author wojciechowskia
 * @version 1
 */
public class Bolt implements Part {
    private double diameterInches;
    private double lengthInches;
    private static final double LBS_MULTIPLIER = 0.05;
    private static final double USD_MULTIPLIER = 1.00;

    /**
     * Constructor for a bolt
     * @param diameterInches the diameter of the bolt
     * @param lengthInches the length of the bolt
     */
    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    @Override
    public double getCost() {
        return USD_MULTIPLIER * this.diameterInches * this.lengthInches;
    }

    /**
     * Gets the name for this bolt with proper numeric formatting for the diameter and the length
     * @return the name of this bolt
     */
    @Override
    public String getName() {
        DecimalFormat inchesFormat = new DecimalFormat("0.0###");
        String inches = inchesFormat.format(this.lengthInches);
        return String.format("%sx%s bolt", inchesFormat.format(this.diameterInches), inches);
    }

    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * Math.pow(this.diameterInches, 2) * this.lengthInches;
    }

    /**
     * Prints the bill of materials for this bolt via the console
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
        System.out.println(String.format("Length: %s inches", inchesFormat.format(this.lengthInches)));
        System.out.println(String.format("Cost $%s", costFormat.format(this.getCost())));
        System.out.println(String.format("Weight: %s lbs", weightFormat.format(this.getWeight())));
    }
}
