package local.mso.app_rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerOrigin {

    @ExceptionHandler(ExceptionResponseOrigin.class)
    public ResponseEntity<String> handleExceptionResponse(ExceptionResponseOrigin ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
