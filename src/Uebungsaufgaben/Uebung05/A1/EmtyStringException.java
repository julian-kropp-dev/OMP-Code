package Uebungsaufgaben.Uebung05.A1;

public class EmtyStringException extends RuntimeException {
    public EmtyStringException() {
    }

    public EmtyStringException(String message) {
        super(message);
    }
}
