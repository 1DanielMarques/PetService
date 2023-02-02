package br.com.petservice.resources.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class InvalidArgumentsExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> invalidPhoneLength(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Invalid phone number.";
        HttpStatus status = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getAllErrors().get(0).getDefaultMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
