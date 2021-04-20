package Exceptions;

public class LackOfMarksExceptions extends Exception{
    public LackOfMarksExceptions() {
    }

    public LackOfMarksExceptions(String message) {
        super(message);
    }

    public LackOfMarksExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public LackOfMarksExceptions(Throwable cause) {
        super(cause);
    }

    public LackOfMarksExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
