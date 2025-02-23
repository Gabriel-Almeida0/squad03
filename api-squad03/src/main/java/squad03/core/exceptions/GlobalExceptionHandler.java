package squad03.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import squad03.core.domain.ErrorResponse;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleInvalidCredentials(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Credenciais inválidas!",
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                "/usuarios/login"
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
