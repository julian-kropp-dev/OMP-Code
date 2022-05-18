package Uebungsaufgaben.Uebung04.A4;

import java.awt.*;

public interface Furniture {
}

class Table implements Furniture {

}

class Chair implements Furniture {

}

class Desk extends Table {

}

class Room {
    protected Furniture[] furniture;

    public Room(Furniture[] furniture) {
        this.furniture = furniture;
    }
}

class Office extends Room {
    private Chair chairs[];
    private Desk desks[];

    public Office(Furniture[] furniture, Chair[] chairs, Desk[] desks) {
        super(furniture);
        if (chairs.length == 0) {
            throw new IllegalArgumentException("u have to have at least one chair in ur office, how else do u want to work boy?");
        }
        this.chairs = chairs;

        if (desks.length == 0) {
            throw new IllegalArgumentException("Are u crazy to work with ur laptop just on a chair? Keep aware of back pain!");
        }
        this.desks = desks;
    }
}

class Test {
    Chair chair0 = new Chair();
    Desk desk = new Desk();
    Chair chair1 = new Chair();

    Chair[] chairs = new Chair[]{chair0};
    Furniture[] furnitures = new Furniture[]{chair0, desk, chair1};
    Desk[] desks = new Desk[]{desk};

    Office office = new Office(furnitures, chairs, desks);
}

