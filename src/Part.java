/*
 * SE1021
 * Winter 2017
 * Lab Lab3
 * Name: Andrew Wojciechowski
 * Created 12/9/17
 */

/**
 * Interface to represent information about a machine part
 * @author wojciechowskia
 * @version 1
 */
public interface Part {
    /**
     * Get the cost of the part
     * @return cost of this item
     */
    double getCost();

    /**
     * Get he name of this part
     * @return name of this item
     */
    String getName();

    /**
     * Get the weight of this part
     * @return weight of this item
     */
    double getWeight();

    /**
     * Prints the billing information for this part via the console
     */
    void printBillOfMaterials();
}
