package com.projet.frigo.controller;

import com.projet.frigo.model.Produit;
import com.projet.frigo.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ProduitControllerImpl implements ProduitController {

    private final ProduitRepository produitRepository;

    // A ProduitRepository is injected by constructor into the controller.
    public ProduitControllerImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @PostMapping("/produits")
    public Produit enregistrerNouveauProduit(@RequestBody Produit nouveauProduit) {
        return produitRepository.save(nouveauProduit);
    }


    @GetMapping("/produits")
    public List<Produit> listerProduits() {
        return produitRepository.findAll();
    }


    @GetMapping("/produits/{id}")
    public Produit trouverUnProduit(@PathVariable Long id) {

        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException(id));
    }


    @PutMapping("/produits/{id}")
    public Produit changerUnProduit(@RequestBody Produit nouveauProduit, @PathVariable Long id) {

        return produitRepository.findById(id)
                .map(monProduit -> {
                    monProduit.setQuantite(nouveauProduit.getQuantite());
                    return produitRepository.save(monProduit);
                })
                .orElseGet(() -> {
                    nouveauProduit.setId(id);
                    return produitRepository.save(nouveauProduit);
                });
    }


    @DeleteMapping("/produits/{id}")
    public void effacerProduit(@PathVariable Long id) {

        produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException(id));

        produitRepository.deleteById(id);

    }
}

/*
    To wrap the repository with a web layer, we must turn to Spring MVC ie use a Controller (servlet http
    with HTTP POST, GET, PUT and DELETE calls)

    @RestController indicates that the data returned by each method will be written straight into the response body
    instead of rendering a template.

    @GetMapping corresponds to HTTP GET calls       >  monRepository.save(newBean);
    @PostMapping corresponds to HTTP POST calls     >  monRepository.findAll()  / monRepository.findById(beanId)
    @PutMapping corresponds to HTTP PUT calls       >  monRepository.findById(beanId)
    @DeleteMapping corresponds to HTTP DELETE calls >  monRepository.deleteById(beanId);

 */