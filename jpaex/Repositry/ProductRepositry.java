package com.example.jpaex.Repositry;

import com.example.jpaex.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepositry extends JpaRepository<Product,Integer> {
    ArrayList<Product> findByCategoryid(int cid);
}
