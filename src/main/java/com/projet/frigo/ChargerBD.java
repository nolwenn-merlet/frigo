package com.projet.frigo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChargerBD {

    private static final Logger log = LoggerFactory.getLogger(ChargerBD.class);


    @Bean
    CommandLineRunner initialiserBD (ProduitRepository produitRepository) {
        return args ->{
            log.info("Chargement " + produitRepository.save(new Produit("tomates")));
            log.info("Chargement " + produitRepository.save(new Produit("aubergines")));
        };
    }

}


/*
    @Configuration annotation indicates that a class declares one or more @Bean methods and may be processed
    by the Spring container to generate bean definitions and service requests for those beans at runtime.
        > Since spring 2, we were writing our bean configurations to xml files. Spring 3 gave the freedom to move
        bean definitions out of xml files ; we can give bean definitions in Java files itself.
        This is called Spring Java Config feature (using @Configuration annotation).

    @Bean annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
    Spring Bean annotation is usually declared in Configuration classes methods. In this case, bean methods
    may reference other @Bean methods in the same class by calling them directly.

    When ChargerBD gets loaded:
        •	Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
        •	This runner will request a copy of the ProduitRepository.
        •	Using it, it will create two entities (tomates and aubergines) and store them.

    The monRepository.save() method allows us to save an entity to the DB. It belongs to the CrudRepository interface
    defined by Spring Data.

    SLF4J (Simple Log Facade for Java) est une API courante qui permet d’utiliser tous les frameworks de log
    (journalisation) de facon standard.
        > Il existe differents niveaux de log (par ordre d'importance):
        log.error(message) / log.warn(message) / log.info(message) / log.debug(message) / log.trace(message)

 */