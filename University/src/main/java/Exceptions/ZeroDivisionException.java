package Exceptions;

public class ZeroDivisionException extends Exception{

    String message;

    public ZeroDivisionException(String message) {
        super(message);
    }

    public ZeroDivisionException(String message, Throwable cause) {
        super(message, cause);
    }

    public String toString() {
        return ("Division by zero!" + message);
    }
}
