package com.projet.frigo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //JPA annotation to make this object ready for storage in a JPA-based data store
class Produit {

    @Id     // to indicate it’s the primary key
    @GeneratedValue
    private long id;

    private String nomProduit;

    // A custom constructor is created when we need to create a new instance, but don’t yet have an id
    public Produit() {}

    public Produit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

}
