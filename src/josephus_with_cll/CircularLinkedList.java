package josephus_with_cll;

// Author:   Douglas Gromek
// Creation: 5/6/22
// Purpose:  Provide an internal, circular linked list that will hold
//           all the people standing in the circle.


public class CircularLinkedList {

    /**
     * Internal Node class where each person is represented by a Node and
     * has a forward pointer to the next person at their original starting
     * position.
     */
    private static class Node {
        private final int POSITION;
        private Node next;

        public Node(int position) {
            this.POSITION = position;
        }
    }


    private Node firstPerson;      // Person located at position 1 who starts the killing
    private int circleSize;        // # of people originally located in the circle
    private boolean printCircle;   // if True, the remaining circle will be printed after each iteration

    public CircularLinkedList(int circleSize, boolean printCircle) {
        this.circleSize = circleSize;
        this.printCircle = printCircle;
        createCircle();        // Call internal method to create the initial circle
    }

    /**
     * Internal method called once to create the CLL of the size specified by the client.
     */
    private void createCircle() {
        // Create entrance to circle and create pointer for iteration
        firstPerson = new Node(1);
        Node curr = firstPerson;

        // Add all other people to the circle with a position value equal to their
        // starting spot in the circle
        for (int i = 2; i <= circleSize;  i++) {
            Node newPerson = new Node(i);
            curr.next = newPerson;
            newPerson.next = firstPerson;
            curr = newPerson;
        }
    }

    public int findSurvivor() {
        // Iterator that will hold the person who is currently about the kill the next person in front of them
        Node killer = firstPerson;

        while (killer.next != killer) {

            // Check if a new loop is starting, if so, re-print the remaining people
            // Only print if client selected True for print variable
            if (printCircle) {
                int killerPos = killer.POSITION;
                int killedPos = killer.next.POSITION;
                if ((killerPos > killedPos) || (killer.equals(firstPerson)))
                    printCLL(killer);
            }

            // Remove the next person from the CLL as they are killed and decrement size
            killer.next = killer.next.next;
            killer = killer.next;
            circleSize--;
        }
        // Print final CLL with one person if client wanted it and return the position
        if (printCircle)
            System.out.println(killer.POSITION + " -> ");

        return killer.POSITION;
    }

    /**
     * Internal print method that will show the remaining survivors after a full loop.
     * IMPORTANT: in the case where a new loop is about to start, where the starting
     * person (ex. position 1) is about to be killed, the person before them will be
     * shown at the start of the circle to signify this.
     * @param start Person who is about to kill next at start of one cycle
     */
    private void printCLL(Node start) {
        Node curr = start;
        do {
            System.out.print(curr.POSITION + " -> ");
            curr = curr.next;
        }
        while (curr.POSITION != start.POSITION);
        System.out.println();
    }

    /**
     * Print method accessible by client that can only print out the starting
     * configuration of the circle if they choose to do so.
     */
    public void printCLL() {
        Node curr = firstPerson;
        do {
            System.out.print(curr.POSITION + " -> ");
            curr = curr.next;
        }
        while (curr != firstPerson);
    }
}
