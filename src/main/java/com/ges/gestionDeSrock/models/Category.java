package com.ges.gestionDeSrock.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Article> articles;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Category() {
    }

    public Category(Long id, String designation) {
        this.id = id;
        this.designation = designation;
    }
}
