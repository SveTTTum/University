package Exceptions;

public class ZeroDivisionException extends Exception{
    public ZeroDivisionException(String message) {
        super(message);
    }

    public ZeroDivisionException(String message, Throwable cause) {
        super(message, cause);
    }
}
