package CodingChallenges.Inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MengeTest {
    @Test
    void addElement() {
        Menge myMenge = new Menge(4);
        assertTrue(myMenge.addElement(3));
        assertTrue(myMenge.addElement(8));
        assertTrue(myMenge.addElement(9));
        assertFalse(myMenge.addElement(3));
        assertTrue(myMenge.addElement(7));

    }

}