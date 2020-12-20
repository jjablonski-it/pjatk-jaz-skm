package pl.pjatk.skmapi.exception;

public class InternalServerException extends Exception{
    // IDK
    @Override
    public String getMessage() {
        return super.getMessage() + " Test message@";
    }
}
