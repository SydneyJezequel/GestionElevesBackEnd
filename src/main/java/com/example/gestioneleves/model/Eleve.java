package com.example.gestioneleves.model;


import javax.persistence.*;

@Entity
@Table(name="eleve")
public class Eleve {


    /**
     * Attributs :
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="id")
    private Long id;
    @Column(nullable = false, updatable = false, name="nom")
    private String nom;
    @Column(nullable = false, updatable = false, name="prenom")
    private String prenom;
    @Column(nullable = false, updatable = false, name="email")
    private String email;


    /**
     * Constructeur :
     */
    public Eleve(){}

    public Eleve(String nom, String prenom, String email) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Eleve(Long id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }


    /**
     * Setters & Getters :
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
