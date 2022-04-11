package CodingChallenges.Polymorphie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack mystack = new Stack();

    @Test
    void push() {
        mystack.push(3);
        assertEquals(3, mystack.items.get(0));
        assertEquals("Pushed 3 sucessfully onto the stack", mystack.push(3));
    }

    @Test
    void pop() {
        mystack.push(4);
        assertEquals(4, mystack.pop());
        mystack.items.remove(0);
        assertEquals("stack empty", mystack.pop());
    }

    @Test
    void empty() {
        assertTrue(mystack.empty());
        mystack.push(4);
        assertFalse(mystack.empty());
    }

    @Test
    void search() {
        mystack.push(4);
        mystack.push(7);
        mystack.push(3);
        mystack.push(77);
        mystack.push(13);

        assertEquals(2, mystack.search(3));


    }
}