package br.com.pietrobondioli.processstorageapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PsBadRequestException extends RuntimeException {

    public PsBadRequestException(String message) {
        super(message);
    }

}
