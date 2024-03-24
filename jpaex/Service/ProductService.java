package com.example.jpaex.Service;

import com.example.jpaex.Model.Category;
import com.example.jpaex.Model.Product;
import com.example.jpaex.Repositry.CategoryRepositry;
import com.example.jpaex.Repositry.ProductRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepositry productRepositry;
    private final CategoryService categoryService;
    private final CategoryRepositry categoryRepositry;


    public List<Product> getProduct(){
        return productRepositry.findAll();
    }

    public void addProduct(Product product){
        productRepositry.save(product);
    }

    public Boolean updateProduct(Integer id,Product product) {
        Product p = productRepositry.getById(id);
        if (p == null) {
            return false;
        }

        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategoryid(product.getCategoryid());

        productRepositry.save(p);

        return true;
    }

    public Boolean deleteProduct(Integer id){
        Product p=productRepositry.getById(id);
        if(p==null){
            return false;
        }
        productRepositry.delete(p);


        return true;
    }

    public ArrayList<Product> bycategory(Integer cid,Integer min){
        ArrayList<Product> products=productRepositry.findByCategoryid(cid);
        ArrayList<Product> filter=new ArrayList<>();
        for(Product p:products){
            if(p.getPrice()>=min){
                filter.add(p);
            }
        }
        return filter;
    }

    }



