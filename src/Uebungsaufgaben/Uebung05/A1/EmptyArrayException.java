package Uebungsaufgaben.Uebung05.A1;

public class EmptyArrayException extends RuntimeException {
    public EmptyArrayException() {
    }

    public EmptyArrayException(String message) {
        super(message);
    }
}
