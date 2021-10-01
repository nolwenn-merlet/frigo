package com.projet.frigo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity //JPA annotation to make this object ready for storage in a JPA-based data store
class Produit {

    @Id     // to indicate it’s the primary key
    @GeneratedValue
    private long id;

    private String nom;

    // A custom constructor is created when we need to create a new instance, but don’t yet have an id
    public Produit() {}

    public Produit(String nom) {
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Produit {" + "id=" + this.id + ", nom='" + this.nom + "'}";
    }

}
