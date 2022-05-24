package Uebungsaufgaben.Uebung05.A3;

import java.util.LinkedList;
import java.util.List;

public interface Older<T> {
    public boolean isOlder(T other);
}

class Person implements Older<Person> {
    private String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean isOlder(Person other) {
        return this.getAge() > other.getAge();
    }
}

class Group<T extends Older<T>> {
    private final List<T> members = new LinkedList<>();

    public void add(T member) {
        this.members.add(member);
    }

    public T getOldest() {
        if(this.members.isEmpty()) {
            throw new Error("Gruppe leer");
        }
        T oldest = this.members.get(0);

        for (T member : members) {
            if (member.isOlder(oldest)) {
                oldest = member;
            }
        }
        return oldest;
    }

}

class TestGroup {
    public static void main(String[] args) {
        Group<Person> group = new Group<>();
        group.add(new Person("Alice", 25));
        group.add(new Person("Bob", 23));
        group.add(new Person("Carl", 26));
        System.out.println(group.getOldest().getName() + " ist " + group.getOldest().getAge() + " Jahre alt. Damit ist er der Älteste.");
    }
}