package Uebungsaufgaben.Uebung04.A2;

public interface Sequence {
    int getNext();
}

class Naturals implements Sequence{
    private int elem;

    @Override
    public int getNext() {
        return ++elem;
    }
}

abstract class Filter implements Sequence {
    protected Sequence sequenceObject;

    public Filter(Sequence sequenceObject) {
        this.sequenceObject = sequenceObject;
    }
}

class ZapMultiples extends Filter {
    private final int divisor;

    ZapMultiples(int divisor, Sequence sequence) {
        super(sequence);

        if (divisor < 2) {
            throw new IllegalArgumentException("divisor must be at least 2");
        }
        this.divisor = divisor;

    }

    @Override
    public int getNext() {
        int next = this.sequenceObject.getNext();
        return next % divisor == 0 ? this.getNext() : next;
    }
}

class Primes extends Filter {
    public Primes() {
        super(new Naturals());
        this.sequenceObject.getNext();
    }

    @Override
    public int getNext() {
        int ret = this.sequenceObject.getNext();
        this.sequenceObject = new ZapMultiples(ret, this.sequenceObject);
        return ret;
    }
}