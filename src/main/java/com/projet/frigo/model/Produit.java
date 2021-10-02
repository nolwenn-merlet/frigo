package com.projet.frigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity //JPA annotation to make this object ready for storage in a JPA-based data store
public class Produit {

    @Id     // to indicate it’s the primary key
    @GeneratedValue
    private long id;

    @Column(unique=true)
    private String nom;
    private int quantite;

    // A custom constructor is created when we need to create a new instance, but don’t yet have an id
    public Produit() {}

    public Produit(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit {" + "id=" + this.id + ", nom='" + this.nom + "', quantite='" + this.quantite + "'}";
    }
}
