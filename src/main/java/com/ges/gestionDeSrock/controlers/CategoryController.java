package com.ges.gestionDeSrock.controlers;

import com.ges.gestionDeSrock.models.Category;
import com.ges.gestionDeSrock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    void addCategory(@RequestBody Category c){
        categoryService.addCategory(c);
    }

    @GetMapping()
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PutMapping(path = "{id}")
    public void updateCategory(@PathVariable("id") Long id ,
                               @RequestParam(required = false) String designation
                               ){
        categoryService.editCategory(id , designation);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }



}

