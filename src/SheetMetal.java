/*
 * SE1021
 * Winter 2017
 * Lab Lab3
 * Name: Andrew Wojciechowski
 * Created 12/9/17
 */

import java.text.DecimalFormat;

/**
 * Represents information about a sheet metal part
 * @author wojciechowskia
 * @version 1
 */
public class SheetMetal implements Part {
    private double lengthInches;
    private double widthInches;
    private double thicknessInches;
    private static final double LBS_MULTIPLIER = 0.1;
    private static final double USD_MULTIPLIER = 0.50;

    /**
     * Constructor for a sheet metal part
     * @param lengthInches The length of the sheet metal
     * @param widthInches The width of the sheet metal
     * @param thicknessInches The thickness of the sheet metal
     */
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }

    @Override
    public double getCost() {
        return USD_MULTIPLIER * this.thicknessInches * this.widthInches * this.lengthInches;
    }

    /**
     * Gets the name of this sheet metal with proper numeric formatting for the length, width and thickness
     * @return the name of this sheet metal
     */
    @Override
    public String getName() {
        DecimalFormat inchesFormat = new DecimalFormat("0.0###");
        String length = inchesFormat.format(this.lengthInches);
        String width = inchesFormat.format(this.widthInches);
        String thickness = inchesFormat.format(this.thicknessInches);
        return String.format("%sx%sx%s sheet", length, width, thickness);
    }

    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * this.thicknessInches * this.widthInches * this.lengthInches;
    }

    /**
     * Prints the bill of materials for this sheet metal via the console
     */
    @Override
    public void printBillOfMaterials() {
        DecimalFormat inchesFormat = new DecimalFormat("0.0###");
        DecimalFormat weightFormat = new DecimalFormat("0.###");
        DecimalFormat costFormat = new DecimalFormat("0.00");

        System.out.println("==========================");
        System.out.println(this.getName());
        System.out.println("==========================");
        System.out.println(String.format("Length: %s inches", inchesFormat.format(this.lengthInches)));
        System.out.println(String.format("Width: %s inches", inchesFormat.format(this.widthInches)));
        System.out.println(String.format("Thickness: %s inches", inchesFormat.format(this.thicknessInches)));
        System.out.println(String.format("Cost: $%s", costFormat.format(this.getCost())));
        System.out.println(String.format("Weight: %s lbs", weightFormat.format(this.getWeight())));
    }
}
