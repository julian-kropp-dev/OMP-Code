package Uebungsaufgaben.Uebung01;

public class BioTest {
    public static void main(String[] args) {
        Plant gras = new Plant("Gras ", "ist grün");
        Plant beeren = new Plant("Beeren ", "sind rot");
        Animal zebras = new Animal("Zebra");
        Animal loewe = new Animal("Löwe");
        Animal baer = new Animal("Bär");
        Animal fisch = new Animal("Fisch");

        zebras.addFood(gras);
        loewe.addFood(zebras);
        baer.addFood(beeren);
        baer.addFood(fisch);

        System.out.println(getFoodDescription(zebras));
        System.out.println(getFoodDescription(baer));
        System.out.println(getFoodDescription(loewe));

    }

    private static String getFoodDescription(Animal animal) {
        if(animal.isHerbivore()) {
            return animal.getName() + " ist ein Pflanzenfresser";
        } else if(animal.isCarnivore()) {
            return animal.getName() + " ist ein Fleischfresser";
        } else if(animal.isOmnivore()) {
            return animal.getName() + " ist ein Allesfresser";
        } else {
            return animal.getName() + " mag nix";
        }
    }

}
