package josephus_with_cll;
// Author:    Douglas Gromek
// Creation:  5/7/22
// Purpose:   Client class used to create an instance of the Josephus circle using a custom
//            circular linked list, then determine the final survivor and output their position.

public class josephusDriver {
    public static void main(String[] args) {

        // Starting number of people in the circle. Data validation not performed. Value must be >= 2
        final int CIRCLE_SIZE = 0;
        final boolean PRINT_CIRCLE = false;
        CircularLinkedList josephusCircle = new CircularLinkedList(CIRCLE_SIZE, PRINT_CIRCLE);

        // Loops through circle until only one survivor remains'
        System.out.println("\n----Start Josephus Circle Problem----\n");
        int survivor = josephusCircle.findSurvivor();

        System.out.printf("\nCircle size of (%d) people:    Survivor at " +
                          "position (%d)", CIRCLE_SIZE, survivor);

    }
}
