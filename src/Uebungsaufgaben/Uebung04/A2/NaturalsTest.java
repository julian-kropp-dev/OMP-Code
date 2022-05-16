package Uebungsaufgaben.Uebung04.A2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalsTest {

    @Test
    void getNext() {
        Naturals instance = new Naturals();
        assertEquals(1, instance.getNext());
        assertEquals(2, instance.getNext());
        assertEquals(3, instance.getNext());
    }
}