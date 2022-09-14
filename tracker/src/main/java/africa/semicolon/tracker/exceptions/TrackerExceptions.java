package africa.semicolon.tracker.exceptions;

public class TrackerExceptions extends Exception {
    private int statusCode;

    public TrackerExceptions(String message) {
        super(message);
    }


}