package com.projet.frigo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProduitNotFoundException extends RuntimeException {

    public ProduitNotFoundException(Long id) {
        super("Impossible de trouver le produit #" + id);
    }
}
