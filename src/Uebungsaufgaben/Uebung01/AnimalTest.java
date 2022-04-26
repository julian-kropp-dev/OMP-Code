//Test nur für meine Testzwecke
package Uebungsaufgaben.Uebung01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal1 = new Animal("Zebra");
    Plant plant1 = new Plant("Gras", " ist grün");
    Plant plant2 = new Plant("jbdlhgh0", " ist grün");
    @Test
    void addFood() {
        animal1.addFood(plant1);
        System.out.println(Arrays.toString(animal1.getFoodPlants()));
        animal1.addFood(plant2);
        System.out.println(Arrays.toString(animal1.getFoodPlants()));

    }
    @Test
    void getName() {
        assertEquals("Zerba", animal1.getName());
    }
}