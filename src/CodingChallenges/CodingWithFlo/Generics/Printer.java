package CodingChallenges.CodingWithFlo.Generics;

public class Printer<T> {
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    void toPrint() {
        System.out.println(thingToPrint);
    }
}

class Test {
    public static void main(String[] args) {
        Printer <String> myPrinter = new Printer<>("Hallo Welt");
        Printer <Boolean> myPrinterZwei = new Printer<>(false);
        myPrinter.toPrint();
        myPrinterZwei.toPrint();
    }
}
