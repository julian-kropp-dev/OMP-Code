package Uebungsaufgaben.Uebung06.A1;

public interface MultiSet <T> extends Iterable <T> {
    void add(T element);
    int count(T element);
}
