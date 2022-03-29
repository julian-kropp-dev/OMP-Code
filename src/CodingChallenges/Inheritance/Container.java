package CodingChallenges.Inheritance;

// Übung zum Thema Vererbung von D.Boles, umgesetzt von Julian Kropp 2022

class Container {
    int next;
    int[] elems;

    Container(int size) {
        this.elems = new int[size];
        this.next = 0;
    }

    boolean isFull() {
        return this.next == this.elems.length;
    }

    boolean addElement(int value) {
        if (isFull()) {
            return false;
        }
        this.elems[this.next++] = value;
        return true;
    }

    boolean removeElement(int value) {
        boolean result = false;
        int i = 0;
        while (i < this.next) {
            if (this.elems[i] == value) {
                result = true;
                for (int j = i; j < this.next - 1; j++) {
                    this.elems[j] = this.elems[j + 1];
                }
                this.next--;
            } else {
                i++;
            }
        }
        return result;
    }

    boolean existsElement(int value) {
        for (int i = 0; i < this.next; i++) {
            if (this.elems[i] == value) {
                return true;
            }
        }
        return false;
    }
}

class Menge extends Container {

    Menge(int size) {
        super(size);
    }

    boolean addElement(int value) {
        if (isFull()) {
            return false;
        }
        for (int i = 0; i < this.next; i++) {
            if (elems[i] == value) return false;
        }
        this.elems[this.next++] = value;
        return true;
    }

}

