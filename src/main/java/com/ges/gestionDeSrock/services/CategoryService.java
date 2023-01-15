package com.ges.gestionDeSrock.services;

import com.ges.gestionDeSrock.models.Category;
import com.ges.gestionDeSrock.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category c){
        categoryRepository.save(c);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @Transactional
    public void editCategory(Long id,String d){
        Optional<Category> cc = categoryRepository.findById(id);
        Category c = cc.get();
        c.setDesignation(d);
    }

    public void deleteCategory(Long id) {categoryRepository.deleteById(id);}
}
