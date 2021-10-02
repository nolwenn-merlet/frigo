package com.projet.frigo.controller;

import com.projet.frigo.model.Produit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProduitController {
    Produit enregistrerNouveauProduit(Produit nouveauProduit);
    List<Produit> listerProduits();
    Produit trouverUnProduit(Long id);
    Produit changerUnProduit(Produit nouveauProduit, Long id);
    void effacerProduit(Long id);
}
