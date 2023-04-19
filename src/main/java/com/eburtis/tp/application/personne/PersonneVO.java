package com.eburtis.tp.application.personne;

import com.eburtis.tp.domains.departement.Departement;

public class PersonneVO {
    
    private String nom;

    private String prenoms;

    private Long age;

    private Departement departement;

    // Getter

    public String getNom() {
        return this.nom;
    }

    public String getPrenoms() {
        return this.prenoms;
    }

    public Long getAge() {
        return this.age;
    }

    public Departement getDepartement() {
        return this.departement;
    }
}
