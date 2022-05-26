package Uebungsaufgaben.Uebung06.A1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapMultiSetTest {

    @Test
    void add() {
        HashMapMultiSet<String> test1 = new HashMapMultiSet<>();
        assertEquals(0, test1.count("a")); //noch kein Element in Map vorhanden
        test1.add("r");
        test1.add("e");
        test1.add("g");
        test1.add("e");
        test1.add("n");
        test1.add("w");
        test1.add("e");
        test1.add("t");
        test1.add("t");
        test1.add("e");
        test1.add("r");

        assertEquals(4, test1.count("e"));
        assertEquals(1, test1.count("g"));
        assertEquals(1, test1.count("n"));
        assertEquals(2, test1.count("r"));
        assertEquals(2, test1.count("t"));
        assertEquals(1, test1.count("w"));

        assertNotEquals(2, test1.count("j"));
        assertNotEquals(2, test1.count("k"));

    }
}