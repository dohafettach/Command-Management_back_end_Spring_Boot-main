package com.ges.gestionDeSrock.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private Double prix_unitaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ctg")//must be category_id
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", prix_unitaire=" + prix_unitaire +
                ", category=" + category +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Article() {
    }

    public Article(Long id, String libelle, Double prix_unitaire, Category category) {
        this.id = id;
        this.libelle = libelle;
        this.prix_unitaire = prix_unitaire;
        this.category = category;
    }
}
