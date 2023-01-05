package eatda.clone.exception;

import org.springframework.http.HttpStatus;

public class EatDaException extends RuntimeException{

    private final HttpStatus httpStatus;

    public EatDaException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
