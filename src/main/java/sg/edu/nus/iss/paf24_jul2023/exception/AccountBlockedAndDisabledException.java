package sg.edu.nus.iss.paf24_jul2023.exception;

public class AccountBlockedAndDisabledException extends RuntimeException {
    
    public AccountBlockedAndDisabledException(String message) {
        super(message);
    }
}
