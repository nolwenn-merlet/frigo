package com.projet.frigo;

public class ProduitNotFoundException extends RuntimeException {

    public ProduitNotFoundException(Long id) {
        super("Impossible de trouver le produit #" + id);
    }
}
