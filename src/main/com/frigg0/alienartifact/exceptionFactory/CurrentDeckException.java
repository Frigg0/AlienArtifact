package exceptionFactory;

public class CurrentDeckException extends Exception {
    public CurrentDeckException(String errorMsg){
        super(errorMsg);
    }
}
