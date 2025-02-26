package squad03.infra.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import squad03.adapter.dtos.ErrorResponseDto;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleInvalidCredentials(IllegalArgumentException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                "Credenciais inválidas!",
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                "/usuarios/login"
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNAUTHORIZED);
    }
}
