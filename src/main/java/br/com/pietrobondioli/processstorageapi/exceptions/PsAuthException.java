package br.com.pietrobondioli.processstorageapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PsAuthException extends RuntimeException {
    public PsAuthException(String message) {
        super(message);
    }
}
