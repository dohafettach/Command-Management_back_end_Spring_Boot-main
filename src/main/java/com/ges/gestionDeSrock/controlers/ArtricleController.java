package com.ges.gestionDeSrock.controlers;

import com.ges.gestionDeSrock.models.Article;
import com.ges.gestionDeSrock.models.Category;
import com.ges.gestionDeSrock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/article")
public class ArtricleController {
    private final ArticleService articleService;
    @Autowired
    public ArtricleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping()
    void addArticle(@RequestBody Article a){articleService.addArticle(a);}
    @GetMapping()
    public List<Article> getArticles(){return articleService.getArticles();}
    @DeleteMapping(path = "{id}")
    public void deleteArtivcle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
    }
    @PutMapping(path = "{id}")
    public void updateCategory(@PathVariable("id") Long id ,
                               @RequestParam(required = false) String libelle,
                               @RequestParam(required = false) Double prix_unitaire,
                               @RequestParam(required = false) Category category
    ){
        articleService.editArticle(id , libelle , prix_unitaire , category);
    }



}
