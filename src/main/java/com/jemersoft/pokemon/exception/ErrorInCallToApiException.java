package com.jemersoft.pokemon.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
public class ErrorInCallToApiException extends Exception {

    public ErrorInCallToApiException(String message) {
        super(message);
    }
}
