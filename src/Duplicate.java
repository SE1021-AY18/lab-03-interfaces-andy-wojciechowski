/*
 * SE1021
 * Winter 2017
 * Lab Lab3
 * Name: Andrew Wojciechowski
 * Created 12/9/17
 */

import java.text.DecimalFormat;

/**
 * Represents a part made up of multiple copies of an identical part
 * @author wojciechowskia
 * @version 1
 */
public class Duplicate implements Part {
    private final DecimalFormat costFormat = new DecimalFormat("0.00");
    private final DecimalFormat weightFormat = new DecimalFormat("0.###");
    private static final double REDUCTION_FACTOR1 = 0.95;
    private static final double REDUCTION_FACTOR2 = 0.9;
    private static final int USD_THRESHOLD1 = 5;
    private static final int USD_THRESHOLD2 = 10;
    private Part identicalPart;
    private int numDuplicates;

    /**
     * Constructor for a duplicate part
     * @param identicalPart the part we are duplicating
     * @param numDuplicates the number of copies of the duplicate part
     */
    public Duplicate(Part identicalPart, int numDuplicates) {
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

    /**
     * Gets the cost for this duplicate. Applies the reduction factor if necessary
     * @return the cost of the duplicate.
     */
    @Override
    public double getCost() {
        double initialCost = numDuplicates * identicalPart.getCost();

        if(numDuplicates >= USD_THRESHOLD1 && numDuplicates < USD_THRESHOLD2) {
            return REDUCTION_FACTOR1 * initialCost;
        } else if(numDuplicates >= USD_THRESHOLD2) {
            return REDUCTION_FACTOR2 * initialCost;
        }
        return initialCost;
    }

    /**
     * Returns the name of this duplicate. Handles pluralization of the name depending on the number of duplicates
     * @return the name of the duplicate
     */
    @Override
    public String getName() {
        String result = String.format("%d %s", this.numDuplicates, this.identicalPart.getName());
        if(this.numDuplicates == 1) {
            return result;
        } else {
            return result + "s";
        }
    }

    @Override
    public double getWeight() {
        return numDuplicates * identicalPart.getWeight();
    }

    /**
     * Prints out the bill of materials for this duplicate via the console
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(this.getName());
        System.out.println("==========================");
        System.out.println(String.format("Duplicate Part: %s", this.identicalPart.getName()));
        System.out.println(String.format("Copies: %d", this.numDuplicates));
        System.out.println(String.format("Individual Cost: $%s", costFormat.format(this.identicalPart.getCost())));
        String weight = weightFormat.format(this.identicalPart.getWeight());
        System.out.println(String.format("Individual Weight: %s lbs", weight));
        System.out.println();
        System.out.println(String.format("Total Cost: $%s", costFormat.format(this.getCost())));
        System.out.println(String.format("Total Weight: %s lbs", weightFormat.format(this.getWeight())));
        System.out.println();
        this.identicalPart.printBillOfMaterials();

        //Handle extra line breaks due to a duplicate assembly
        //Since the assembly will print out the bill of materials the linebreak will be handled by the final subpart
        if(!(this.identicalPart instanceof Assembly)) {
            System.out.println();
        }
    }
}
