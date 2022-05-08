package josephus_with_cll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    /**
     * Check that the program is returning the correct survivor position for a few
     * known values.
     */
    @org.junit.jupiter.api.Test
    void checkSurvivor() {
        CircularLinkedList c1 = new CircularLinkedList(10, false);
        CircularLinkedList c2 = new CircularLinkedList(8, false);
        CircularLinkedList c3 = new CircularLinkedList(100, false);

        assertEquals(c1.findSurvivor(), 5);
        assertEquals(c2.findSurvivor(), 1);
        assertEquals(c3.findSurvivor(), 73);
    }

    /**
     * If a circle size of 0 0r 1 has been chosen by the user, then the circle will not be
     * initialized properly and a NullPointerException will be thrown when the user tries
     * and determine who the survivor is
     */
    @Test
    void illegalCircleSizes() {
        CircularLinkedList c1 = new CircularLinkedList(0, false);
        CircularLinkedList c2 = new CircularLinkedList(1, false);

        Exception exception1 = assertThrows(NullPointerException.class, c1::findSurvivor);
        Exception exception2 = assertThrows(NullPointerException.class, c2::findSurvivor);

    }
}