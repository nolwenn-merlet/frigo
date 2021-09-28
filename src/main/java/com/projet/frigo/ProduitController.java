package com.projet.frigo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    private final ProduitRepository produitRepository;

    // A ProduitRepository is injected by constructor into the controller.
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @PostMapping("/produits")
    Produit enregistrerNouveauProduit(@RequestBody Produit nouveauProduit) {
        return produitRepository.save(nouveauProduit);
    }


    @GetMapping("/produits")
    List<Produit> listerProduits() {
        return produitRepository.findAll();
    }


    @GetMapping("/produits/id")
    Produit trouverUnProduit(@PathVariable Long id) {

        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException(id));
    }


    @PutMapping("/produits")
    Produit changerUnProduit(@RequestBody Produit nouveauProduit, @PathVariable Long id) {

        return produitRepository.findById(id)
                .map(monProduit -> {
                    monProduit.setNomProduit(nouveauProduit.getNomProduit());
                    return produitRepository.save(monProduit);
                })
                .orElseGet(() -> {
                    nouveauProduit.setId(id);
                    return produitRepository.save(nouveauProduit);
                });
    }


    @DeleteMapping("/produits")
    void effacerProduit(@PathVariable Long id) {
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