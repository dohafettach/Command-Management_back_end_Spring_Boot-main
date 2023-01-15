package com.ges.gestionDeSrock.services;

import com.ges.gestionDeSrock.models.Article;
import com.ges.gestionDeSrock.models.Category;
import com.ges.gestionDeSrock.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void addArticle(Article a){articleRepository.save(a);}
    public void deleteArticle(Long id){articleRepository.deleteById(id);}
    public List<Article> getArticles(){return articleRepository.findAll();}
    @Transactional
    public void editArticle(Long id ,String libelle,Double prix_unitaire ,Category ctgr ){
        Optional<Article> aa = articleRepository.findById(id);
        Article a = aa.get();
        if( !libelle.isEmpty()){
            a.setLibelle(libelle);
        }
        if( prix_unitaire != null){
            a.setPrix_unitaire(prix_unitaire);
        }
        if( ctgr != null){
            a.setCategory(ctgr);
        }
    }

}
