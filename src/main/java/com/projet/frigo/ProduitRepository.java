package com.projet.frigo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    /**
    By simply declaring the following ProduitRepository interface we AUTOMATICALLY will be able to
    •	Create new Employees
    •	Update existing ones
    •	Delete Employees
    •	Find Employees (one, all, or search by simple or complex properties)

    To get all this free functionality, all we had to do was declare an interface
    which extends Spring Data JPA’s JpaRepository, specifying the domain type as Produit and the id type as Long.
 */

}
