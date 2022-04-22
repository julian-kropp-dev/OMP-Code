//Test nur für meine Testzwecke
package Uebungsaufgaben.Uebung01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal1 = new Animal("Zebra");
    Plant plant1 = new Plant("Gras", " ist grün");
    @Test
    void addFood() {
        animal1.addFood(plant1);
        System.out.println(Arrays.toString(animal1.getFoodPlants()));
    }
}