package Uebungsaufgaben.Uebung06.A1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapMultiSet<T> implements MultiSet <T> {
    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T element) {
        //fügt element zur Map hinzu und erhöht entsprechenden Counter um 1
        map.put(element, count(element) + 1);
    }

    @Override
    public int count(T element) {
        //wenn element vorhanden, dann returnen wir es
        if(map.containsKey(element)) return map.get(element);
        return 0;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }
}
