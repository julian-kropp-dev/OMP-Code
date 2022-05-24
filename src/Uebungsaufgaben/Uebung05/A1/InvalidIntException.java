package Uebungsaufgaben.Uebung05.A1;

public class InvalidIntException extends RuntimeException {
    public InvalidIntException() {
    }

    public InvalidIntException(String message) {
        super(message);
    }
}
