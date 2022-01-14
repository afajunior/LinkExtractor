package br.anselmo.LinkExtractor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such TV Show")
public class NotFoundException extends RuntimeException {
}
