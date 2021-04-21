package exceptions;

public class SomeExceptions extends Exception {

    public SomeExceptions() {
    }

    public SomeExceptions(String message) {
        super(message);
    }

    public SomeExceptions(String message, Throwable exception) {
        super(message, exception);
    }

    public SomeExceptions(Throwable exception) {
        super(exception);
    }

}
