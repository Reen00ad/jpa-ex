package com.example.jpaex.Repositry;

import com.example.jpaex.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositry extends JpaRepository<Category,Integer> {
}
