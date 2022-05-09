package Uebungsaufgaben.Uebung03.A2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Wir haben uns gegen eine Main-Methode und für einen JUnit Test entschieden.
//Wir denken, Main Methoden sind nicht zum Testen geeignet, da wir eine geeignetere Variante (JUnit) bereits kennengelernt haben.
class VersatileLinkedListTest {
    VersatileLinkedList liste = new VersatileLinkedList();


    @Test
    void add() {
        liste.add(3);
        liste.add(4);
        liste.add(5);
        assertEquals("3",liste.get(0));
        assertEquals("4",liste.get(1));
        assertEquals("5",liste.get(2));
    }

    @Test
    void testAdd() {
        liste.add(true);
        liste.add(true);
        liste.add(false);
        assertEquals("yes", liste.get(0));
        assertEquals("yes", liste.get(1));
        assertEquals("no", liste.get(2));
    }

    @Test
    void testAdd1() {
        VersatileLinkedList liste2 = new VersatileLinkedList();
        liste2.add(7);
        liste2.add(8);
        liste2.add(9);
        liste.add(liste2);
        assertEquals("7", liste.get(0));
        assertEquals("8", liste.get(1));
        assertEquals("9", liste.get(2));


    }

    @Test
    void testAdd2() {
        VersatileLinkedList liste2 = new VersatileLinkedList();
        liste2.add("a");
        liste2.add("b");
        liste2.add("c");
        liste2.add("d");
        liste.add(liste2,1, 3);
        assertEquals("b", liste.get(0));
        assertEquals("c", liste.get(1));
        assertNull(liste.get(2));
    }

    @Test
    void reverse() {
        VersatileLinkedList liste2 = new VersatileLinkedList();
        liste2.add("a");
        liste2.add("b");
        liste2.add("c");
        liste2.add("d");
        liste.reverse(liste2);
        assertEquals("d", liste.get(0));
        assertEquals("c", liste.get(1));
        assertEquals("b", liste.get(2));
        assertEquals("a", liste.get(3));
    }

    @Test
    void testEquals() {
        VersatileLinkedList liste2 = new VersatileLinkedList();

        liste.add(3);
        liste.add(4);
        liste.add(5);

        liste2.add(3);
        liste2.add(4);
        liste2.add(5);

        assertTrue(liste2.equals(liste));


    }
}