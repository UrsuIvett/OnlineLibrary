//package ro.sci.onlinelibrary.exceptions;
//
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.validation.ValidationException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Exceptions handling class
// * What response to receive when an exception appears
// */
//@ControllerAdvice
//public class ExceptionHandlerAdvice {
//    private static final Logger LOGGER = Logger.getLogger("Book");
//
//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity handleException(ValidationException e) {
//
//        String stackTrace = ExceptionUtils.getStackTrace(e);
//
//        LOGGER.log(Level.WARNING, stackTrace);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("Book id already exist");
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity handleNullPointerException(NullPointerException e) {
//
//        String stackTrace = ExceptionUtils.getStackTrace(e);
//
//        LOGGER.log(Level.WARNING, stackTrace);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("NullPointerException: Please check that entered values EXIST in DATABASE. Maybe you are searching NON EXISTING values in table! "
//                        + e.fillInStackTrace());
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity handleRuntimeException(RuntimeException e) {
//
//        String stackTrace = ExceptionUtils.getStackTrace(e);
//
//        LOGGER.log(Level.WARNING, stackTrace);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("Runtime Exception: Please check SQL Query for accessing database information!  ");
//    }
//}