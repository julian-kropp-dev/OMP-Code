//Frage: Gibt es eine interne Funktion für einen Deep Copy bei Klassenobjekten in Java?

class Objekt <T> {
    private T attribut;

    public Objekt(T i) {
        this.attribut = i;
    }

    public T getAttribut() {
        return attribut;
    }

    public void setAttribut(T attribut) {
        this.attribut = attribut;
    }
}

class Main {
    public static void main(String[] args) {
        //Instanz bilden, Objekt erstellen
        Objekt<Integer> original = new Objekt<>(1);

        //Kopie erstellen
        Objekt<Integer> shallowCopy = original;

        shallowCopy.setAttribut(2);

        System.out.println("----------Shallow Copy------------");
        System.out.println("Original: " + original.getAttribut()); //a wird nicht verändert
        System.out.println("Shallow Copy: " + shallowCopy.getAttribut()); //b wird auf 2 verändert

        //Klassen sind Referenztypen; dh. es handelt sich um ein shallow copy: Gewünscht: Deep Copy
        Objekt<Integer> deepCopy = new Objekt<>(original.getAttribut());

        deepCopy.setAttribut(3);


        System.out.println("----------Deep Copy------------");
        System.out.println("Original: " + original.getAttribut());
        System.out.println("Deep Copy: " + deepCopy.getAttribut());

        //unnötig kompliziert, wenn Objekt viele Attribute hat. Swift nutzt dafür structs (value type)


    }


}