package Uebungsaufgaben.Uebung04.A4;

public interface Furniture {
}

class Table implements Furniture {

}

class Chair implements Furniture {

}

class Desk extends Table {

}

class Room {
    protected Furniture furniture[];

    public Room(Furniture[] furniture) {
        this.furniture = furniture;
    }
}

abstract class Office extends Room {
    private Chair chars[];
    private Desk desks[];

    public Office(Furniture[] furniture, Chair[] chars, Desk[] desks) {
        super(furniture);
        if (chars.length == 0) {
            throw new IllegalArgumentException("u have to have at least one chair in ur office, how else do u want to work boy?");
        }
        this.chars = chars;

        if (desks.length == 0) {
            throw new IllegalArgumentException("Are u crazy to work with ur laptop just on a chair? Keep aware of back pain!");
        }
        this.desks = desks;
    }
}

