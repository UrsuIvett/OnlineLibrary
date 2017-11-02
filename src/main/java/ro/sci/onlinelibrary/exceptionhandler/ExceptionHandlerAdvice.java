package ro.sci.onlinelibrary.exceptionhandler;


import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by iulia on 11/1/2017.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    private static final Logger LOGGER = Logger.getLogger("OnlineLibrary");

    @ExceptionHandler(BindException.class)
    public ResponseEntity handleBindException(BindException e) {

        String stackTrace = ExceptionUtils.getStackTrace(e);

        LOGGER.log(Level.WARNING, stackTrace);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Validation BindException: Please check that the entered values ARE correctly written and CAN BE converted in the required Type. Example:Did you put a character where only numbers are allowed? ");
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleException(ValidationException e) {

        String stackTrace = ExceptionUtils.getStackTrace(e);

        LOGGER.log(Level.WARNING, stackTrace);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Wrong entries; Please click Back in your browser");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleNullPointerException(NullPointerException e) {

        String stackTrace = ExceptionUtils.getStackTrace(e);

        LOGGER.log(Level.WARNING, stackTrace);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("NullPointerException: Please check that entered values EXIST in DATABASE. Maybe you are searching NON EXISTING values in table! "
                        + e.fillInStackTrace());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException e) {

        String stackTrace = ExceptionUtils.getStackTrace(e);

        LOGGER.log(Level.WARNING, stackTrace);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Illegal Argument: Please check that the entered values ARE correctly written and CAN BE converted in the required Type. Example:Did you put a character where only numbers are allowed? ");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException e) {

        String stackTrace = ExceptionUtils.getStackTrace(e);

        LOGGER.log(Level.WARNING, stackTrace);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Runtime Exception: Please check SQL Query for accessing database information!  ");
    }
}
