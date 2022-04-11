package CodingChallenges.Polymorphie;

import java.util.ArrayList;

/**
 * A Last-In-First-Out(LIFO) stack of objects.
 */
class Stack extends java.util.ArrayList {
    ArrayList<Object> items = new ArrayList<>();
    /**
     * Pushes an item onto the stack.
     *
     * @param item the item to be pushed on.
     */
    public Object push(Object item) {
        items.add(item);
        return "Pushed " + item + " sucessfully onto the stack";
    }

    /**
     * Pops an item off the stack.
     */
    public Object pop() {
        if (empty()) return "stack empty";
        else return items.get(items.size() - 1);
    }


    /**
     * Returns true if the stack is empty.
     */
    public boolean empty() {
        return items.size() == 0;
    }

    /**
     * Sees if an object is on the stack.
     *
     * @param o the desired object
     * @return the distance from the top, or -1 if it is not found.
     */
    public int search(Object o) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(o)) {
                return ((items.size() - 1) - i);
            }
        }
        return -1;
    }
}