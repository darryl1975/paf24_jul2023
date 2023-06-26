package sg.edu.nus.iss.paf24_jul2023.exception;

public class AmountNotSufficientException extends RuntimeException {
    
    public AmountNotSufficientException(String message) {
        super(message);
    }
}
