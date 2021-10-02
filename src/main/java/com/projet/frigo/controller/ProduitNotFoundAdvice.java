package com.projet.frigo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
class ProduitNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProduitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)       // 404
    String produitNotFoundHandler(ProduitNotFoundException ex) {
        return ex.getMessage();
    }
}

