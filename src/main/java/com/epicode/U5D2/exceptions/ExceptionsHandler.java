package com.epicode.U5D2.exceptions;

import com.epicode.U5D2.payload.users.ErrosDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrosDTO handleBadRequest(BadRequestException ex) {
        return new ErrosDTO(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrosDTO handleUnauthorized(UnauthorizedException ex) {
        return new ErrosDTO(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrosDTO handleNotFound(NotFoundException ex) {
        return new ErrosDTO(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrosDTO handleGenericError(Exception ex) {
        ex.printStackTrace();
        return new ErrosDTO("Server issue! We'll resolve this as soon as possible", LocalDateTime.now());
    }
}
