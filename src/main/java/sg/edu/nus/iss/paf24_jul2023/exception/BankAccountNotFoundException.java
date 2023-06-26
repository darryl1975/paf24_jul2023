package sg.edu.nus.iss.paf24_jul2023.exception;

public class BankAccountNotFoundException extends RuntimeException {
    
    public BankAccountNotFoundException() {
        super();
    }

    public BankAccountNotFoundException(String message) {
        super(message);
    }

    public BankAccountNotFoundException(String message, Throwable cause) { 
        super(message, cause);
    }

    public BankAccountNotFoundException(Throwable cause) {
        super(cause);
    }
}
