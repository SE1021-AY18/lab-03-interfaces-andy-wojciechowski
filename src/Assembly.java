/*
 * SE1021
 * Winter 2017
 * Lab Lab3
 * Name: Andrew Wojciechowski
 * Created 12/9/17
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a part made up of different subparts
 * @author wojciechowskia
 * @version 1
 */
public class Assembly implements Part {
    private final DecimalFormat costFormat = new DecimalFormat("0.00");
    private final DecimalFormat weightFormat = new DecimalFormat("0.###");
    private static final double USD_PER_SUB_PART = 0.25;
    private String name;
    private List<Part> subParts = new ArrayList<Part>();

    /**
     * Constructor for an assembly
     * @param name the name of the assembly
     */
    public Assembly(String name) {
        this.name = name;
    }

    /**
     * Gets the cost for this duplicate. Adds on an additional construction charge per sub part.
     * @return the cost of the assembly
     */
    @Override
    public double getCost() {
        double initialCost = this.subParts.stream().mapToDouble(Part::getCost).sum();
        return initialCost + (USD_PER_SUB_PART * this.subParts.size());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.subParts.stream().mapToDouble(Part::getWeight).sum();
    }

    /**
     * Prints the bill of the materials for this assembly via the console
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(this.getName());
        System.out.println("==========================");

        for(Part part : subParts) {
            System.out.println(String.format("Part: %s", part.getName()));
            System.out.println(String.format("Cost: $%s", costFormat.format(part.getCost())));
            System.out.println(String.format("Weight: %s lbs", weightFormat.format(part.getWeight())));
            System.out.println();
        }

        System.out.println(String.format("Total Cost: $%s", costFormat.format(this.getCost())));
        System.out.println(String.format("Total Weight: %s lbs", weightFormat.format(this.getWeight())));
        System.out.println();

        for(Part part : subParts) {
            part.printBillOfMaterials();

            //This type check here is to prevent extra line breaks from being printed to the console
            //This case is to handle a duplicate as a subpart
            // if that's the case then the duplicate class will handle the space.
            if(!(part instanceof Duplicate)) {
                System.out.println();
            }
        }
    }

    public void addPart(Part part) {
        this.subParts.add(part);
    }
}
