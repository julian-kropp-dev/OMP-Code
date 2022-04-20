//Frage: Gibt es eine interne Funktion für einen Deep Copy bei Klassenobjekten in Java?

import javax.swing.*;

class Objekt <T> {
    private T i;

    public Objekt(T i) {
        this.i = i;
    }

    public T getI() {
        return i;
    }

    public void setI(T i) {
        this.i = i;
    }
}

class Main {
    public static void main(String[] args) {
        //Instanz bilden, Objekt erstellen
        Objekt<Integer> original = new Objekt<>(1);

        //Kopie erstellen
        Objekt<Integer> shallowCopy = original;

        shallowCopy.setI(2);

        System.out.println("----------Shallow Copy------------");
        System.out.println("Original: " + original.getI()); //a wird nicht verändert
        System.out.println("Shallow Copy: " + shallowCopy.getI()); //b wird auf 2 verändert

        //Klassen sind Referenztypen; dh. es handelt sich um ein shallow copy: Gewünscht: Deep Copy
        Objekt<Integer> deepCopy = new Objekt<>(original.getI());

        deepCopy.setI(3);


        System.out.println("----------Deep Copy------------");
        System.out.println("Original: " + original.getI());
        System.out.println("Deep Copy: " + deepCopy.getI());

        //unnötig kompliziert, wenn Objekt viele Attribute hat. Swift nutzt dafür structs (value type)


    }


}