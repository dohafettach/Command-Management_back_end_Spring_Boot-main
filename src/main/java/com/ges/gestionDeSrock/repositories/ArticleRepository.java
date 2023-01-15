package com.ges.gestionDeSrock.repositories;


import com.ges.gestionDeSrock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article , Long> {
}
