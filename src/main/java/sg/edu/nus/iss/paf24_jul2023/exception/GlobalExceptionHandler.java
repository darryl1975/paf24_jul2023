package sg.edu.nus.iss.paf24_jul2023.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(BankAccountNotFoundException.class)
    // public ResponseEntity<ErrorMessage>
    // handleBankAccountNotFoundException(BankAccountNotFoundException ex,
    // HttpServletRequest request) {
    // // forming the custom error message
    // ErrorMessage errMsg = new ErrorMessage();
    // errMsg.setStatusCode(404);
    // errMsg.setTimeStamp(new Date());
    // errMsg.setMessage("Bank account doesn't exist or have not been created.");
    // errMsg.setDescription(request.getRequestURI());

    // return ResponseEntity.ok().body(errMsg);
    // }

    @ExceptionHandler(BankAccountNotFoundException.class)
    public ModelAndView handleBankAccountNotFoundException(BankAccountNotFoundException ex,
            HttpServletRequest request) {
        // forming the custom error message
        ErrorMessage errMsg = new ErrorMessage();
        errMsg.setStatusCode(404);
        errMsg.setTimeStamp(new Date());
        errMsg.setMessage("Bank account doesn't exist or have not been created.");
        errMsg.setDescription(request.getRequestURI());

        // return the error page with injected error message
        ModelAndView mav = new ModelAndView("error.html");
        mav.addObject("errorMessage", errMsg);
        return mav;
    }
}
