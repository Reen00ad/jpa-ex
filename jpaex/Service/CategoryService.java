package com.example.jpaex.Service;

import com.example.jpaex.Model.Category;
import com.example.jpaex.Model.User;
import com.example.jpaex.Repositry.CategoryRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepositry categoryRepositry;



    public List<Category> getCategory(){
        return categoryRepositry.findAll();
    }

    public void addCategory(Category category){
        categoryRepositry.save(category);
    }

    public Boolean updateCategory(Integer id,Category category) {
        Category c = categoryRepositry.getById(id);
        if (c == null) {
            return false;
        }

        c.setName(category.getName());

        categoryRepositry.save(c);

        return true;
    }

    public Boolean deleteCategory(Integer id){
        Category c=categoryRepositry.getById(id);
        if(c==null){
            return false;
        }
        categoryRepositry.delete(c);


        return true;
    }

    public void check(Integer id){
        Category c=categoryRepositry.getById(id);
        //categoryRepositry.existsById(id);

    }




}
