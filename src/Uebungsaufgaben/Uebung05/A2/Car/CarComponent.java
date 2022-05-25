package Uebungsaufgaben.Uebung05.A2.Car;

import java.util.LinkedList;

public interface CarComponent {
    LinkedList<CarComponent> components = new LinkedList<>();
    String getName();
}
